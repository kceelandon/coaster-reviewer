package test.com.coasterreviewer.model.business;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import com.coasterreviewer.model.business.*;
import com.coasterreviewer.model.domain.Coaster;
import com.coasterreviewer.model.domain.SearchResult;

import junit.framework.TestCase;

public class SearchManagerTest extends TestCase {
	private SearchManager sManager;
	private final String testDataPath = "data/testSearchService/testLoadAllCoasters/"; // use same coasters tested in SearchServiceTest
	private List<Coaster> allCoasters = new LinkedList<Coaster>();
	
	protected void setUp() throws Exception {
		super.setUp();
		sManager = SearchManager.getInstance();
	}
	
	/**
	 * This method implicitly contains testing for loadResults() method.
	 */
	public void testInitializeSearch() {
		try {
			sManager.initializeSearch(testDataPath);
			SearchResult r = sManager.loadResults();
			assertTrue(r.getCoasterList().size() == 3);
			List<Integer> l = new ArrayList<Integer>();
			l.add(1);
			l.add(2);
			l.add(3);
			for (Coaster c : r.getCoasterList()) {
				assertTrue(l.contains(c.getCoasterId()));
			}
		} catch (Exception e) {
			fail("An exception was thrown in testInitializeSearch under SearchManagerTest.");
		}
	}
	
	public void testUpdateSearch() {
		try {
			sManager.reset();
			sManager.initializeSearch(testDataPath);
			SearchResult r = sManager.loadResults();
			for (Coaster c : r.getCoasterList()) {
				allCoasters.add(c);
			}
			assertTrue(r.getCoasterList().size() == 3);
			sManager.updateSearch("testloado", allCoasters);
			assertTrue(sManager.loadResults().getCoasterList().size() == 1);
			assertTrue(sManager.loadResults().getCoasterList().get(0).getCoasterId() == 1);
			assertTrue(sManager.loadResults().getCoasterList().get(0).getName().equals("testLoadOne"));
		} catch (Exception e) {
			fail("An exception was thrown in testUpdateSearch under SearchManagerTest");
		}
	}
}
