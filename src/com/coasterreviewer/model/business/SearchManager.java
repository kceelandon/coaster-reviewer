package com.coasterreviewer.model.business;

import java.util.*;
import com.coasterreviewer.model.domain.*;
import com.coasterreviewer.model.services.*;

public class SearchManager extends CoasterManager {
	private SearchResult result;
	private SearchQuery currentQuery;

	/**
	 * @param dataPath directory containing data of all coasters to be searched through
	 * @throws Exception
	 */
	public void initializeSearch(String dataPath) throws Exception {
		ISearchService iss = (ISearchService) getService(ISearchService.NAME);
		result = new SearchResult();
		List<Coaster> coasters = iss.loadAllCoasters(dataPath);
		result.setCoasterList(coasters);
	}
	
	/**
	 * This method will update the search result list
	 * @param input The input from the user that will be typed into the search bar.
	 * @throws Exception
	 */
	public void updateSearch(String input) throws Exception {
		ISearchService iss = (ISearchService)getService(ISearchService.NAME);
		currentQuery = iss.updateQuery(input, currentQuery);
		result = iss.getSearchResults(currentQuery, this.result.getCoasterList());
	}
	
	/**
	 * @return This method returns the current state of the SearchResult object.
	 */
	public SearchResult loadResults() {
		return this.result;
	}
	
}
