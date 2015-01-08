package com.lambda.plugin.yunit.view.action;

import java.lang.reflect.InvocationTargetException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.SubProgressMonitor;
import org.eclipse.jdt.core.IJavaElement;
import org.eclipse.jdt.core.IJavaModel;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.core.IType;
import org.eclipse.jdt.core.JavaModelException;
import org.eclipse.jdt.core.search.IJavaSearchConstants;
import org.eclipse.jdt.core.search.SearchEngine;
import org.eclipse.jdt.core.search.SearchPattern;
import org.eclipse.jdt.core.search.TypeNameMatch;
import org.eclipse.jdt.core.search.TypeNameMatchRequestor;
import org.eclipse.jdt.ui.JavaUI;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.dialogs.ErrorDialog;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.operation.IRunnableWithProgress;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.texteditor.ITextEditor;

import com.lambda.plugin.YPlugin;
import com.lambda.plugin.YMessages;
import com.lambda.plugin.yunit.view.YUnitView;

public abstract class OpenEditorAction extends Action {
    protected String fClassName;
    protected YUnitView fTestRunner;
    private final boolean fActivate;

    protected OpenEditorAction(final YUnitView testRunner, final String testClassName) {
        this(testRunner, testClassName, true);
    }

    public OpenEditorAction(final YUnitView testRunner, final String className, final boolean activate) {
        super(YMessages.OpenEditorAction_action_label);
        fClassName = className;
        fTestRunner = testRunner;
        fActivate = activate;
    }

    /*
     * @see IAction#run()
     */
    @Override
    public void run() {
        ITextEditor textEditor = null;
        try {
            final IJavaElement element = findElement(getLaunchedProjects(), fClassName);
            if (element == null) {
                MessageDialog.openError(getShell(), YMessages.OpenEditorAction_error_cannotopen_title,
                        YMessages.OpenEditorAction_error_cannotopen_message);
                return;
            }
            textEditor = (ITextEditor) JavaUI.openInEditor(element, fActivate, false);
        } catch (final CoreException e) {
            ErrorDialog.openError(getShell(), YMessages.OpenEditorAction_error_dialog_title,
                    YMessages.OpenEditorAction_error_dialog_message, e.getStatus());
            return;
        }
        if (textEditor == null) {
            fTestRunner.registerInfoMessage(YMessages.OpenEditorAction_message_cannotopen);
            return;
        }
        reveal(textEditor);
    }

    protected Shell getShell() {
        return fTestRunner.getSite().getShell();
    }

    /**
     * @return the Java project, or <code>null</code>
     */
    protected List<IJavaProject> getLaunchedProjects() {
        return fTestRunner.getLaunchedProjects();
    }

    protected String getClassName() {
        return fClassName;
    }

    protected abstract IJavaElement findElement(List<IJavaProject> projects, String className) throws CoreException;

    protected abstract void reveal(ITextEditor editor);

    protected final IType findType(final List<IJavaProject> projects, final String className) {
        final IType[] result = { null };
        final String dottedName = className.replace('$', '.'); // for nested
        // classes...
        try {
            PlatformUI.getWorkbench().getProgressService().busyCursorWhile(new IRunnableWithProgress() {
                public void run(final IProgressMonitor monitor) throws InvocationTargetException, InterruptedException {
                    try {
                        if (projects == null) {
                            final int lastDot = dottedName.lastIndexOf('.');
                            final TypeNameMatchRequestor nameMatchRequestor = new TypeNameMatchRequestor() {
                                @Override
                                public void acceptTypeNameMatch(final TypeNameMatch match) {
                                    result[0] = match.getType();
                                }
                            };
                            new SearchEngine().searchAllTypeNames(lastDot >= 0 ? dottedName.substring(0, lastDot).toCharArray() : null,
                                    SearchPattern.R_EXACT_MATCH | SearchPattern.R_CASE_SENSITIVE,
                                    (lastDot >= 0 ? dottedName.substring(lastDot + 1) : dottedName).toCharArray(),
                                    SearchPattern.R_EXACT_MATCH | SearchPattern.R_CASE_SENSITIVE, IJavaSearchConstants.TYPE,
                                    SearchEngine.createWorkspaceScope(), nameMatchRequestor,
                                    IJavaSearchConstants.WAIT_UNTIL_READY_TO_SEARCH, monitor);
                        } else {
                            for (final IJavaProject project : projects) {
                                result[0] = internalFindType(project, dottedName, new HashSet<IJavaProject>(), monitor);
                                if (result[0] != null) {
                                    break;
                                }
                            }

                        }
                    } catch (final JavaModelException e) {
                        throw new InvocationTargetException(e);
                    }
                }
            });
        } catch (final InvocationTargetException e) {
            YPlugin.logError(e);
        } catch (final InterruptedException e) {
            // user cancelled
        }
        return result[0];
    }

    private IType internalFindType(final IJavaProject project, final String className, final Set<IJavaProject> visitedProjects,
            final IProgressMonitor monitor) throws JavaModelException {
        try {
            if (visitedProjects.contains(project)) {
                return null;
            }
            monitor.beginTask("", 2); //$NON-NLS-1$
            IType type = project.findType(className, new SubProgressMonitor(monitor, 1));
            if (type != null) {
                return type;
            }
            // fix for bug 87492: visit required projects explicitly to also find not
            // exported types
            visitedProjects.add(project);
            final IJavaModel javaModel = project.getJavaModel();
            final String[] requiredProjectNames = project.getRequiredProjectNames();
            final IProgressMonitor reqMonitor = new SubProgressMonitor(monitor, 1);
            reqMonitor.beginTask("", requiredProjectNames.length); //$NON-NLS-1$
            for (int i = 0; i < requiredProjectNames.length; i++) {
                final IJavaProject requiredProject = javaModel.getJavaProject(requiredProjectNames[i]);
                if (requiredProject.exists()) {
                    type = internalFindType(requiredProject, className, visitedProjects, new SubProgressMonitor(reqMonitor, 1));
                    if (type != null) {
                        return type;
                    }
                }
            }
            return null;
        } finally {
            monitor.done();
        }
    }

}