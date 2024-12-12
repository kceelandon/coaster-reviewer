package test.com.coasterreviewer.model.business;

import junit.framework.Test;
import junit.framework.TestSuite;

public class AllBusinessTests {

	public static Test suite() {
		TestSuite suite = new TestSuite(AllBusinessTests.class.getName());
		//$JUnit-BEGIN$
		suite.addTestSuite(SearchManagerTest.class);
		//$JUnit-END$
		return suite;
	}

}
