package test.com.coasterreviewer.model.domain;

import junit.framework.Test;
import junit.framework.TestSuite;

public class AllTests {

	public static Test suite() {
		TestSuite suite = new TestSuite(AllTests.class.getName());
		//$JUnit-BEGIN$
		suite.addTestSuite(CoasterManufacturerTest.class);
		suite.addTestSuite(CoasterReviewTest.class);
		suite.addTestSuite(CoasterTest.class);
		suite.addTestSuite(SearchQueryTest.class);
		suite.addTestSuite(SearchResultTest.class);
		suite.addTestSuite(UserTest.class);
		//$JUnit-END$
		return suite;
	}

}
