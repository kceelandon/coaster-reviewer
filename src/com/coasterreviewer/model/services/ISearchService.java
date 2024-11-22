package com.coasterreviewer.model.services;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;
import com.coasterreviewer.model.domain.*;

public interface ISearchService extends IService {
	public final String NAME = "ISearchService";
	
	public SearchQuery createQuery();
	
	public SearchQuery updateQuery(String s, SearchQuery search);
	
	public SearchResult getSearchResults(SearchQuery sq, List<Coaster> coasters);
	
	public void writeCoasterToFile(Coaster c, String dir) throws IOException;
	
	public List<Coaster> loadAllCoasters(String dir) throws FileNotFoundException, IOException, ClassNotFoundException;
}
