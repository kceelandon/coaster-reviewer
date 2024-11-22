package test.com.coasterreviewer.model.services;

import com.coasterreviewer.model.services.*;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.*;
import java.util.stream.Collectors;

import com.coasterreviewer.model.domain.*;

import junit.framework.TestCase;

public class SearchServiceTest extends TestCase {
	private ServiceFactory factory;

	protected void setUp() throws Exception {
		super.setUp();
		factory = ServiceFactory.getInstance();
	}
	
	public void testCreateQuery() {
		try {
			ISearchService iss = (ISearchService) factory.getService(ISearchService.NAME);
			SearchQuery sq = iss.createQuery();
			assertTrue(sq.validate());
			System.out.println("test passed for create query.");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			fail("testCreateQuery() threw an exception");
		}
	}
	
	public void testUpdateQuery() {
		try {
			SearchQuery other = new SearchQuery("kcee");
			ISearchService iss = (ISearchService) factory.getService(ISearchService.NAME);
			SearchQuery sq = new SearchQuery();
			assertFalse(other.equals(sq));
			sq = iss.updateQuery("kcee", sq);
			assertTrue(other.equals(sq));
			System.out.println("test passed for update query.");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			fail("testUpdateQuery() threw an exception");
		}
	}
	
	public void testGetSearchResults() {
		try {
			ISearchService iss = (ISearchService) factory.getService(ISearchService.NAME);
			List<Coaster> completeList = new LinkedList<Coaster>();
			List<Coaster> endList = new LinkedList<Coaster>();
			CoasterManufacturer m = new CoasterManufacturer("rmc", 1);
			String[] coasterNames = {"abcd", "abcde", "lmao", "lol", "cd"};
			for (int i = 0; i < 5; i++) {
				completeList.add(new Coaster(coasterNames[i], m, 1999, i));
				if (i < 2) {
					endList.add(new Coaster(coasterNames[i], m, 1999, i));
				}
			}
			SearchResult actualResult = new SearchResult();
			actualResult.setCoasterList(endList);
			// Set the query to filter down the list
			SearchQuery sq = new SearchQuery("ab");
			SearchResult testResult = iss.getSearchResults(sq, completeList);
			assertTrue(actualResult.equals(testResult));
			System.out.println("test passed for get search results.");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			fail("testGetSearchResults() threw an exception");
		}
	}
	
	public void testWriteCoasterToFile() throws FileNotFoundException, IOException, ClassNotFoundException {
		try {
			Coaster c = new Coaster("testWriteCoaster", new CoasterManufacturer("rmc", 1), 1999, 3);
			ISearchService iss = (ISearchService) factory.getService(ISearchService.NAME);
			String directoryName = "data/testSearchService/";
			String finalPathName = "data/testSearchService/testWriteCoaster3.txt";
			iss.writeCoasterToFile(c, directoryName);
			ObjectInputStream in = new ObjectInputStream(new FileInputStream(finalPathName));
			Coaster readCoaster = (Coaster)in.readObject();
			in.close();
			assertTrue(readCoaster.getName().equals("testWriteCoaster"));
			assertTrue(readCoaster.getCoasterId() == 3);
			assertTrue(readCoaster.getYearCreated() == 1999);
			assertTrue(readCoaster.getManufacturer().getName().equals("rmc"));
			assertTrue(readCoaster.getManufacturer().getManufacturerId() == 1);
			System.out.println("test passed for testWriteCoasterToFile");
		} catch (Exception e) {
			e.printStackTrace();
			fail("testWriteCoasterToFile threw an exception");
		}
	}
	
	public void testLoadAllCoasters() throws FileNotFoundException, IOException, ClassNotFoundException {
		Coaster test1  = new Coaster("testLoadOne", new CoasterManufacturer("one", 1), 1, 1);
		Coaster test2 = new Coaster("testLoadTwo", new CoasterManufacturer("two", 2), 2, 2);
		Coaster test3 = new Coaster("testLoadThree", new CoasterManufacturer("three", 3), 3, 3);
		try {
			ISearchService iss = (ISearchService) factory.getService(ISearchService.NAME);
			String directoryName = "data/testSearchService/testLoadAllCoasters/";
			iss.writeCoasterToFile(test1, directoryName);
			iss.writeCoasterToFile(test2, directoryName);
			iss.writeCoasterToFile(test3, directoryName);
			List<Coaster> coasterList = iss.loadAllCoasters(directoryName);
			assertTrue(coasterList.size() == 3);
			List<Integer> coasterIds = coasterList.stream().map(Coaster::getCoasterId).collect(Collectors.toList());
			assertTrue(coasterIds.contains(1));
			assertTrue(coasterIds.contains(2));
			assertTrue(coasterIds.contains(3));
			System.out.println("all tests for loadAllCoasters have passed");
		} catch (Exception e) {
			e.printStackTrace();
			fail("testLoadAllCoasters threw an exception.");
		}
	}
		

}
