package test.com.coasterreviewer.model.domain;

import com.coasterreviewer.model.domain.SearchQuery;

import junit.framework.TestCase;

public class SearchQueryTest extends TestCase {

	public void testEqualsSearchQuery() {
		SearchQuery s1 = new SearchQuery("KCEE");
		SearchQuery s2 = new SearchQuery("kcee");
		assertFalse(s1.equals(s2));
		s2.setQuery("abcd");
		assertFalse(s1.equals(s2));
		s2.setQuery("KCEE");
		assertTrue(s1.equals(s2));
		System.out.println("test for equals() has passed");
	}

	public void testValidate() {
		SearchQuery s1 = new SearchQuery();
		assertTrue(s1.validate());
		s1.setQuery(null);
		assertFalse(s1.validate());
		System.out.println("test for validate() has passed");
	}

}
