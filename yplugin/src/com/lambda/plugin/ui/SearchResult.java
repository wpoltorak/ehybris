package com.lambda.plugin.ui;

import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.search.ui.ISearchQuery;
import org.eclipse.search.ui.text.AbstractTextSearchResult;
import org.eclipse.search.ui.text.IEditorMatchAdapter;
import org.eclipse.search.ui.text.IFileMatchAdapter;

public class SearchResult extends AbstractTextSearchResult {

	private ISearchQuery query;
	private final String label;
	private final String tooltip;

	public SearchResult(ISearchQuery query) {
		this(query, "");
	}
	
	public SearchResult(ISearchQuery query, String label) {
		this(query, label, label);
	}
	
	public SearchResult(ISearchQuery query, String label, String tooltip) {
		this.query = query;
		this.label = label;
		this.tooltip = tooltip;
	}

	@Override
	public IEditorMatchAdapter getEditorMatchAdapter() {
		return null;
	}

	@Override
	public IFileMatchAdapter getFileMatchAdapter() {
		return null;
	}

	public ImageDescriptor getImageDescriptor() {
		return null;
	}

	public String getLabel() {
		return label;
	}

	public ISearchQuery getQuery() {
		return query;
	}

	public String getTooltip() {
		return tooltip;
	}
}
