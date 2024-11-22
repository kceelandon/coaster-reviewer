package test.com.coasterreviewer.model.domain;

import com.coasterreviewer.model.domain.Coaster;
import com.coasterreviewer.model.domain.CoasterManufacturer;
import com.coasterreviewer.model.domain.SearchResult;

import junit.framework.TestCase;

public class SearchResultTest extends TestCase {
	
	public void testAddCoaster() {
		SearchResult s = new SearchResult();
		CoasterManufacturer m = new CoasterManufacturer("RMC", 1);
		s.addCoaster(new Coaster("abcd", m, 100, 1));
		assertTrue(s.getCoasterList().size() == 1);
		System.out.println("test for addCoaster() has passed");
	}

	public void testEqualsSearchResult() {
		SearchResult searchOne = new SearchResult();
		SearchResult searchTwo = new SearchResult();
		CoasterManufacturer m = new CoasterManufacturer("RMC", 1);
		searchOne.addCoaster(new Coaster("Kcee Coaster", m, 1992, 1));
		searchTwo.addCoaster(new Coaster("Kcee Coaster mark 2", m, 1999, 1));
		assertTrue(searchOne.equals(searchTwo));
		System.out.println("test for equals() has passed");
	}

	public void testValidate() {
		SearchResult s = new SearchResult();
		assertTrue(s.validate());
		System.out.println("test for validate() has passed");
	}

}
