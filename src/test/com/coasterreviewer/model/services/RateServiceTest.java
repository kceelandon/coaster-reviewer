package test.com.coasterreviewer.model.services;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

import com.coasterreviewer.model.domain.*;
import com.coasterreviewer.model.services.*;

import junit.framework.TestCase;

public class RateServiceTest extends TestCase {
	private ServiceFactory factory;

	protected void setUp() throws Exception {
		super.setUp();
		factory = ServiceFactory.getInstance();
	}
	
	public final void testAddReview() throws IOException, ClassNotFoundException {
		try {
			User u = new User("Kcee", "Landon", 1);
			Coaster c = new Coaster("kcee coaster", new CoasterManufacturer("abc", 1), 1999, 1);
			CoasterReview review = new CoasterReview((byte) 1, 1, u);
			assertTrue(u.getReviews().size() == 0);
			assertTrue(c.calculateAverageRating() == 0.00);
			assertTrue(c.getReviews().size() == 0);
			IRateService irs;
			irs = (IRateService) factory.getService(IRateService.NAME);
			irs.addReview(c, review, "data/testRateService/");
			String testFilePath = "data/testRateService/kcee_coaster1.txt";
			ObjectInputStream in = new ObjectInputStream(new FileInputStream(testFilePath));
			c = (Coaster)in.readObject();
			in.close();
			assertTrue(c.calculateAverageRating() == 1.00);
			assertTrue(c.getReviews().size() == 1);
			System.out.println("test passed for add review.");
		} catch (IOException ioe) {
			ioe.printStackTrace();
			fail("Some IO exception thrown in testAddReview()");
		} catch (ClassNotFoundException cnfe) {
			cnfe.printStackTrace();
			fail("Some ClassNotFoundException thrown in testAddReview()");
		} catch (Exception e) {
			e.printStackTrace();
			fail("Some other Exception was thrown in testAddReview()");
		}
	}
	
	public final void testGetReviews() throws IOException, ClassNotFoundException {
		try {
			User u = new User("Kcee", "Landon", 1);
			Coaster c = new Coaster("test_coaster", new CoasterManufacturer("rmc", 1), 1999, 2);
			CoasterReview review = new CoasterReview((byte) 1, 1, u);
			IRateService irs = (IRateService) factory.getService(IRateService.NAME);
			assertTrue(irs.getReviews(c).size() == 0);
			String directoryPath = "data/testRateService/";
			String testFilePath = "data/testRateService/test_coaster2.txt";
			irs.addReview(c, review, directoryPath);
			ObjectInputStream in = new ObjectInputStream(new FileInputStream(testFilePath));
			c = (Coaster)in.readObject();
			in.close();
			assertTrue(c.getReviews().get(0).getReviewId() == 1);
			System.out.println("test passed for get reviews.");
		} catch (Exception e) {
			e.printStackTrace();
			fail("Some exception thrown in testGetReviews()");
		}
	}

}
