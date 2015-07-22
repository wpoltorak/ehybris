package com.lambda.ycore.views.platform;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.part.ViewPart;
import org.eclipse.zest.core.widgets.Graph;
import org.eclipse.zest.core.widgets.GraphConnection;
import org.eclipse.zest.core.widgets.GraphNode;
import org.eclipse.zest.core.widgets.ZestStyles;
import org.eclipse.zest.layouts.LayoutStyles;
import org.eclipse.zest.layouts.algorithms.SpringLayoutAlgorithm;
import org.eclipse.zest.layouts.algorithms.TreeLayoutAlgorithm;

/**
 * This sample class demonstrates how to plug-in a new workbench view. The view shows data obtained from the model. The
 * sample creates a dummy model on the fly, but a real implementation would connect to the model available either in
 * this or another plug-in (e.g. the workspace). The view is connected to the model using a content provider.
 * <p>
 * The view uses a label provider to define how model objects should be presented in the view. Each view can present the
 * same model objects using different labels and icons, if needed. Alternatively, a single label provider can be shared
 * between views in order to ensure that objects of the same type are presented in the same way everywhere.
 * <p>
 */

public class DependenciesView extends ViewPart {
    public static final String ID = "com.lambda.view.dependencies";
    private Graph graph;
    private int layout = 1;

    @Override
    public void createPartControl(Composite parent) {
        // Graph will hold all other objects
        graph = new Graph(parent, SWT.NONE);
        // now a few nodes
        GraphNode node1 = new GraphNode(graph, SWT.NONE, "Jim");
        GraphNode node2 = new GraphNode(graph, SWT.NONE, "Jack");
        GraphNode node3 = new GraphNode(graph, SWT.NONE, "Joe");
        GraphNode node4 = new GraphNode(graph, SWT.NONE, "Bill");
        // Lets have a directed connection
        new GraphConnection(graph, ZestStyles.CONNECTIONS_DIRECTED, node1, node2);
        // Lets have a dotted graph connection
        new GraphConnection(graph, ZestStyles.CONNECTIONS_DOT, node2, node3);
        // Standard connection
        new GraphConnection(graph, SWT.NONE, node3, node1);
        // Change line color and line width
        GraphConnection graphConnection = new GraphConnection(graph, SWT.NONE, node1, node4);
        graphConnection.changeLineColor(parent.getDisplay().getSystemColor(SWT.COLOR_GREEN));
        // Also set a text
        graphConnection.setText("This is a text");
        graphConnection.setHighlightColor(parent.getDisplay().getSystemColor(SWT.COLOR_RED));
        graphConnection.setLineWidth(3);

        graph.setLayoutAlgorithm(new SpringLayoutAlgorithm(LayoutStyles.NO_LAYOUT_NODE_RESIZING), true);
        // Selection listener on graphConnect or GraphNode is not supported
        // see https://bugs.eclipse.org/bugs/show_bug.cgi?id=236528
        graph.addSelectionListener(new SelectionAdapter() {
            @Override
            public void widgetSelected(SelectionEvent e) {
                System.out.println(e);
            }

        });
    }

    public void setLayoutManager() {
        switch (layout) {
        case 1:
            graph.setLayoutAlgorithm(new TreeLayoutAlgorithm(LayoutStyles.NO_LAYOUT_NODE_RESIZING), true);
            layout++;
            break;
        case 2:
            graph.setLayoutAlgorithm(new SpringLayoutAlgorithm(LayoutStyles.NO_LAYOUT_NODE_RESIZING), true);
            layout = 1;
            break;

        }

    }

    /**
     * Passing the focus request to the viewer's control.
     */

    @Override
    public void setFocus() {
    }
}