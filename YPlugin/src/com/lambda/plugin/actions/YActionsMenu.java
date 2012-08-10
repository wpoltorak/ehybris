package com.lambda.plugin.actions;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IExtension;
import org.eclipse.core.runtime.IExtensionPoint;
import org.eclipse.core.runtime.IExtensionRegistry;
import org.eclipse.core.runtime.Platform;
import org.eclipse.jface.action.GroupMarker;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.action.IContributionItem;
import org.eclipse.jface.action.IMenuCreator;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.swt.events.MenuAdapter;
import org.eclipse.swt.events.MenuEvent;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.MenuItem;
import org.eclipse.ui.IActionDelegate;
import org.eclipse.ui.IObjectActionDelegate;
import org.eclipse.ui.IWorkbenchPart;

import com.lambda.plugin.YPlugin;

public class YActionsMenu implements IObjectActionDelegate, IActionDelegate, IMenuCreator {

    private static final String EXTENSION_MENU_ITEMS = "com.lambda.plugin.yMenu";

    private List<AbstractActionMenuCreator> creators;
    private IAction delegateAction;

    private boolean fillMenu;

    public void setActivePart(final IAction action, final IWorkbenchPart targetPart) {
        // TODO Auto-generated method stub

    }

    public void run(final IAction action) {

    }

    List<AbstractActionMenuCreator> getCreators() {
        if (creators == null) {
            creators = new ArrayList<AbstractActionMenuCreator>();
            creators.add(new DefaultProjectMenuCreator());

            final IExtensionRegistry registry = Platform.getExtensionRegistry();
            final IExtensionPoint extensionPoint = registry.getExtensionPoint(EXTENSION_MENU_ITEMS);
            if (extensionPoint != null) {
                for (final IExtension extension : extensionPoint.getExtensions()) {
                    final IConfigurationElement[] elements = extension.getConfigurationElements();
                    for (final IConfigurationElement element : elements) {
                        try {
                            final AbstractActionMenuCreator creator = (AbstractActionMenuCreator) element
                                    .createExecutableExtension("class");
                            creators.add(creator);
                        } catch (final CoreException ex) {
                            Logger.getLogger(YPlugin.LOGGER_NAME).log(Level.WARNING, ex.getMessage());
                        }
                    }
                }
            }
        }
        return creators;
    }

    public void selectionChanged(final IAction action, final ISelection selection) {
        if (selection instanceof IStructuredSelection) {
            // this.selection = (IStructuredSelection) selection;
            this.fillMenu = true;

            if (delegateAction != action) {
                delegateAction = action;
                delegateAction.setMenuCreator(this);
            }

            action.setEnabled(!selection.isEmpty());

            for (final AbstractActionMenuCreator creator : getCreators()) {
                creator.selectionChanged(action, selection);
            }
        }

    }

    public void dispose() {

    }

    public Menu getMenu(final Control parent) {
        // TODO Auto-generated method stub
        return null;
    }

    public Menu getMenu(final Menu parent) {
        final Menu menu = new Menu(parent);

        /**
         * Add listener to re-populate the menu each time it is shown because MenuManager.update(boolean, boolean) doesn't dispose pull-down
         * ActionContribution items for each popup menu.
         */
        menu.addMenuListener(new ProjectMenuListener());

        return menu;
    }

    private class ProjectMenuListener extends MenuAdapter {

        @Override
        public void menuShown(final MenuEvent e) {
            if (fillMenu) {
                final Menu m = (Menu) e.widget;

                for (final MenuItem item : m.getItems()) {
                    item.dispose();
                }

                final IMenuManager mgr = new MenuManager("#hybris");
                mgr.add(new GroupMarker(AbstractActionMenuCreator.NEW));
                mgr.insertAfter(AbstractActionMenuCreator.NEW, new GroupMarker(AbstractActionMenuCreator.UPDATE));
                mgr.insertAfter(AbstractActionMenuCreator.UPDATE, new GroupMarker(AbstractActionMenuCreator.OPEN));
                mgr.insertAfter(AbstractActionMenuCreator.OPEN, new GroupMarker(AbstractActionMenuCreator.NATURE));
                mgr.insertAfter(AbstractActionMenuCreator.NATURE, new GroupMarker(AbstractActionMenuCreator.IMPORT));
                mgr.insertAfter(AbstractActionMenuCreator.IMPORT, new GroupMarker(AbstractActionMenuCreator.UTIL));

                for (final AbstractActionMenuCreator creator : getCreators()) {
                    creator.createProjectMenu(mgr);
                }

                for (final IContributionItem item : mgr.getItems()) {
                    item.fill(m, -1);
                }

                fillMenu = false;
            }
        }
    }

}
