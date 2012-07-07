package com.lambda.plugin.ui;

import org.eclipse.jdt.ui.JavaElementLabelProvider;
import org.eclipse.jface.viewers.IStructuredContentProvider;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.search.ui.ISearchResult;
import org.eclipse.search.ui.text.AbstractTextSearchViewPage;
import org.eclipse.ui.IMemento;

public class SearchResultPage extends AbstractTextSearchViewPage {

	private int matchesFound;

	public SearchResultPage() {
		super(FLAG_LAYOUT_FLAT);
	}

	@Override
	public void saveState(IMemento memento) {

	}

	@Override
	protected void elementsChanged(Object[] objects) {
		((TableViewer) getViewer()).refresh();
	}

	@Override
	protected void clear() {
		((TableViewer) getViewer()).getTable().setData(null);
		((TableViewer) getViewer()).refresh();
	}

	@Override
	public void setInput(ISearchResult search, Object uiState) {
		super.setInput(search, uiState);
	}

	@Override
	protected void configureTableViewer(org.eclipse.jface.viewers.TableViewer viewer) {
		viewer.setContentProvider(new ContentProvider());
		viewer.setLabelProvider(new JavaElementLabelProvider());
	}

	@Override
	protected void configureTreeViewer(org.eclipse.jface.viewers.TreeViewer viewer) {
		throw new IllegalStateException("Tree structure is not supported.");
	}

	@Override
	public String getLabel() {
		return matchesFound + (matchesFound == 1 ? " project" : " projects") + " found";
	}

	private class ContentProvider implements IStructuredContentProvider {

		public Object[] getElements(Object inputElement) {
			if (inputElement != null) {
				SearchResult result = (SearchResult) inputElement;
				matchesFound = result.getMatchCount();
				return result.getElements();
			}
			return new Object[0];
		}

		public void dispose() {
		}

		public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
		}
	}
}
