package test.com.coasterreviewer.model.services;

import junit.framework.Test;
import junit.framework.TestSuite;

public class AllServiceTests {

	public static Test suite() {
		TestSuite suite = new TestSuite(AllServiceTests.class.getName());
		//$JUnit-BEGIN$
		suite.addTestSuite(RateServiceTest.class);
		suite.addTestSuite(SearchServiceTest.class);
		suite.addTestSuite(ServiceFactoryTest.class);
		//$JUnit-END$
		return suite;
	}

}
