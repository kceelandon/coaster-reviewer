package com.coasterreviewer.model.services;

import com.coasterreviewer.model.domain.Coaster;
import com.coasterreviewer.model.domain.SearchQuery;
import com.coasterreviewer.model.domain.SearchResult;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.*;

public class SearchServiceImpl implements ISearchService {

	/**
	 * creates a new empty SearchQuery.
	 */
	@Override
	public SearchQuery createQuery() {
		return new SearchQuery();
	}

	/**
	 * Returns an updated SearchQuery object based on the specified String s.
	 */
	@Override
	public SearchQuery updateQuery(String s, SearchQuery search) {
		search.setQuery(s);
		return search;
	}

	/**
	 * Given a SearchQuery and a list of coasters, this returns a SearchResult
	 * filtered down by the SearchQuery object.
	 */
	@Override
	public SearchResult getSearchResults(SearchQuery sq, List<Coaster> coasters) {
		SearchResult result = new SearchResult();
		for (Coaster c : coasters) {
			if (this.isMatch(c.getName(), sq)) {
				result.addCoaster(c);
			}
		}
		return result;
	}
	
	private boolean isMatch(String coasterName, SearchQuery query) {
		String queryBody = query.getQuery().toLowerCase();
		coasterName = coasterName.toLowerCase();
		return coasterName.indexOf(queryBody) != -1;
	}
	
	/**
	 * Writes a Coaster c to a given file at directoryPath. The fileName will automatically
	 * be determined by the Coaster's toString() method.
	 */
	public void writeCoasterToFile(Coaster c, String directoryPath) throws IOException {
		try {
			ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(directoryPath + c.toString() + ".txt", false)); // false to overwrite
			out.writeObject(c);
			out.flush();
			out.close();
		} catch (IOException e) {
			System.out.println("IOException has been thrown.");
		}
	}
	
	/**
	 * This loads all the Coaster objects in a given directory as a List<Coaster>.
	 */
	public List<Coaster> loadAllCoasters(String coasterDirectoryPath) throws FileNotFoundException, IOException, ClassNotFoundException {
		List<Coaster> coasterList = new LinkedList<Coaster>();
		try {
			File directory = new File(coasterDirectoryPath);
			File[] directoryListing = directory.listFiles();
			if (directoryListing != null) {
				for (File f : directoryListing) {
					FileInputStream input = new FileInputStream(f);
					ObjectInputStream ois = new ObjectInputStream(input);
					Coaster c = (Coaster)ois.readObject();
					coasterList.add(c);
					ois.close();
				}
			} else {
				throw new FileNotFoundException("Data directory was not found.");
			}
		} catch (FileNotFoundException fnfe) {
			System.out.println("File was not found. Please make sure the file exists or the path is correctly formatted.");
		} catch (IOException ioe) {
			System.out.println("An IO Exception was found. Please try again.");
		} catch (ClassNotFoundException cnfe) {
			System.out.println("The class that was attempted to be read was not found.");
		}
		return coasterList;
	}
}
