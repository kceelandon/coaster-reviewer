package test;

import junit.framework.Test;
import test.com.coasterreviewer.model.domain.AllDomainTests;
import test.com.coasterreviewer.model.business.AllBusinessTests;
import test.com.coasterreviewer.model.services.AllServiceTests;
import junit.framework.TestCase;
import junit.framework.TestSuite;

public class ApplicationTestSuite extends TestCase {

	public static Test suite() {
		TestSuite suite = new TestSuite(ApplicationTestSuite.class.getName());
		//$JUnit-BEGIN$
		suite.addTest(AllDomainTests.suite());
		suite.addTest(AllServiceTests.suite());
		suite.addTest(AllBusinessTests.suite());
		//$JUnit-END$
		return suite;
	}

}
