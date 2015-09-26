package com.lambda.ecommerce.dependencies.views.handler;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.ui.IViewPart;
import org.eclipse.ui.handlers.HandlerUtil;

import com.lambda.ecommerce.dependencies.views.DependenciesView;

public class ChangeLayout extends AbstractHandler {

    @Override
    public Object execute(ExecutionEvent event) throws ExecutionException {
        IViewPart findView = HandlerUtil.getActiveWorkbenchWindow(event).getActivePage().findView(DependenciesView.ID);
        DependenciesView view = (DependenciesView) findView;
        view.setLayoutManager();
        return null;
    }

}
