package test.com.coasterreviewer.model.services;

import junit.framework.TestCase;

import com.coasterreviewer.model.services.*;

public class ServiceFactoryTest extends TestCase {
	
	ServiceFactory factory;

	protected void setUp() throws Exception {
		super.setUp();
		factory = ServiceFactory.getInstance();
	}
	
	public void testGetSearchService() {
		ISearchService iss;
		try {
			iss = (ISearchService)factory.getService(ISearchService.NAME);
			assertTrue(iss instanceof SearchServiceImpl);
			System.out.println("testGetSearchService has passed.");
		} catch (Exception e) {
			e.printStackTrace();
			fail("Exception was thrown.");
		}
	}
	
	public void testGetRateService() {
		IRateService irs;
		try {
			irs = (IRateService)factory.getService(IRateService.NAME);
			assertTrue(irs instanceof RateServiceImpl);
			System.out.println("testGetRateService has passed.");
		} catch (Exception e) {
			e.printStackTrace();
			fail("Exception was thrown.");
		}
	}

}
