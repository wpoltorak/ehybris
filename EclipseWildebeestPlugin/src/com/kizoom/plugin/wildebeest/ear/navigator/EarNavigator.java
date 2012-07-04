package com.kizoom.plugin.wildebeest.ear.navigator;

import org.eclipse.core.resources.IResourceChangeEvent;
import org.eclipse.core.resources.IResourceChangeListener;
import org.eclipse.core.resources.IResourceDelta;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.navigator.CommonNavigator;

import com.kizoom.plugin.KizoomPlugin;
import com.kizoom.plugin.wildebeest.WildebeestPlugin;
import com.kizoom.plugin.wildebeest.ear.event.EarChangeEvent;
import com.kizoom.plugin.wildebeest.ear.event.IEarChangeListener;

public class EarNavigator extends CommonNavigator {

	private static final String VIEW_ID = "com.kizoom.ear.navigator.view";

	// private DrillDownAdapter drillDownAdapter;
	// private Action action1;
	// private Action action2;
	// private Action doubleClickAction;

	public static EarNavigator openInActivePerspective() {
		try {
			return (EarNavigator) KizoomPlugin.getActivePage().showView(VIEW_ID);
		} catch (PartInitException pe) {
			return null;
		}
	}

	/**
	 * The constructor.
	 */
	public EarNavigator() {
		super();
	}

	@Override
	protected IAdaptable getInitialInput() {
		this.getCommonViewer().refresh();
		return WildebeestPlugin.getDefault().getEarManager().getRoot();
	}

	@Override
	public void createPartControl(Composite parent) {
		super.createPartControl(parent);
		IResourceChangeListener listener = new IResourceChangeListener() {
			public void resourceChanged(IResourceChangeEvent event) {
				if (getCommonViewer().getInput() == null) {
					return;
				}
				IResourceDelta delta = event.getDelta();
				if (delta == null)
					return;
				IResourceDelta[] projDeltas = delta.getAffectedChildren(IResourceDelta.CHANGED);
				for (int i = 0; i < projDeltas.length; i++) {
					IResourceDelta pDelta = projDeltas[i];
					if ((pDelta.getFlags() & IResourceDelta.DESCRIPTION) != 0) {
						//TODO KizoomPlugin: thread safe exception
						getCommonViewer().refresh(pDelta.getResource());
					}
				}
			}
		};
		ResourcesPlugin.getWorkspace().addResourceChangeListener(listener);

		IEarChangeListener earListener = new IEarChangeListener() {

			public void earChanged(EarChangeEvent event) {
				getCommonViewer().refresh();

			}

		};
		WildebeestPlugin.getDefault().getEarManager().getRoot().addEarChangeListener(earListener);
	}

	/**
	 * This is a callback that will allow us to create the viewer and initialize
	 * it.
	 */
	// @Override
	// public void createPartControl(Composite parent) {
	// viewer = new TreeViewer(parent, SWT.MULTI | SWT.H_SCROLL | SWT.V_SCROLL);
	// drillDownAdapter = new DrillDownAdapter(viewer);
	// viewer.setContentProvider(new EarNavigatorViewContentProvider());
	// viewer.setLabelProvider(new EarNavigatorViewLabelProvider());
	// viewer.setSorter(new NameSorter());
	// viewer.setInput(getViewSite());
	//
	// // Create the help context id for the viewer's control
	// PlatformUI.getWorkbench().getHelpSystem().setHelp(viewer.getControl(),
	// "KizoomPlugin.viewer");
	// makeActions();
	// hookContextMenu();
	// hookDoubleClickAction();
	// contributeToActionBars();
	// }
	// private void hookContextMenu() {
	// MenuManager menuMgr = new MenuManager("#PopupMenu");
	// menuMgr.setRemoveAllWhenShown(true);
	// menuMgr.addMenuListener(new IMenuListener() {
	// public void menuAboutToShow(IMenuManager manager) {
	// EarNavigator.this.fillContextMenu(manager);
	// }
	// });
	// Menu menu = menuMgr.createContextMenu(viewer.getControl());
	// // viewer.getControl().setMenu(menu);
	// getSite().registerContextMenu(menuMgr, viewer);
	// }
	// private void contributeToActionBars() {
	// IActionBars bars = getViewSite().getActionBars();
	// fillLocalPullDown(bars.getMenuManager());
	// fillLocalToolBar(bars.getToolBarManager());
	// }
	// private void fillLocalPullDown(IMenuManager manager) {
	// manager.add(action1);
	// manager.add(new Separator());
	// manager.add(action2);
	// }
	// @Override
	// private void fillContextMenu(IMenuManager manager) {
	// manager.add(action1);
	// manager.add(action2);
	// manager.add(new Separator());
	// drillDownAdapter.addNavigationActions(manager);
	// // Other plug-ins can contribute there actions here
	// manager.add(new Separator(IWorkbenchActionConstants.MB_ADDITIONS));
	// }
	// private void fillLocalToolBar(IToolBarManager manager) {
	// manager.add(action1);
	// manager.add(action2);
	// manager.add(new Separator());
	// drillDownAdapter.addNavigationActions(manager);
	// }
	// @Override
	// private void makeActions() {
	// action1 = new Action() {
	// @Override
	// public void run() {
	// showMessage("Action 1 executed");
	// }
	// };
	// action1.setText("Action 1");
	// action1.setToolTipText("Action 1 tooltip");
	// action1.setImageDescriptor(PlatformUI.getWorkbench().getSharedImages().
	// getImageDescriptor(
	// ISharedImages.IMG_OBJS_INFO_TSK));
	//
	// action2 = new Action() {
	// @Override
	// public void run() {
	// showMessage("Action 2 executed");
	// }
	// };
	// action2.setText("Action 2");
	// action2.setToolTipText("Action 2 tooltip");
	// action2.setImageDescriptor(PlatformUI.getWorkbench().getSharedImages().
	// getImageDescriptor(
	// ISharedImages.IMG_OBJS_INFO_TSK));
	// doubleClickAction = new Action() {
	// @Override
	// public void run() {
	// ISelection selection = viewer.getSelection();
	// Object obj = ((IStructuredSelection) selection).getFirstElement();
	// showMessage("Double-click detected on " + obj.toString());
	// }
	// };
	// }
	// private void hookDoubleClickAction() {
	// viewer.addDoubleClickListener(new IDoubleClickListener() {
	// public void doubleClick(DoubleClickEvent event) {
	// doubleClickAction.run();
	// }
	// });
	// }
	// private void showMessage(String message) {
	// MessageDialog.openInformation(viewer.getControl().getShell(),
	// "EarNavigatorView", message);
	// }
	/**
	 * Passing the focus request to the viewer's control.
	 */
	// @Override
	// public void setFocus() {
	// viewer.getControl().setFocus();
	// }
}