package test.com.coasterreviewer.model.domain;

import java.util.*;

import com.coasterreviewer.model.domain.Coaster;
import com.coasterreviewer.model.domain.CoasterManufacturer;
import com.coasterreviewer.model.domain.CoasterReview;
import com.coasterreviewer.model.domain.User;

import junit.framework.TestCase;

public class CoasterTest extends TestCase {
	private static final CoasterManufacturer cm = new CoasterManufacturer("RMC", 1);

	public void testCalculateAverageRating() {
		Coaster c = new Coaster("Kcee Coaster", cm, 1999, 1);
		User u = new User("Kcee", "Landon", 1);
		List<CoasterReview> reviews = new LinkedList<CoasterReview>();
		c.setReviews(reviews);
		assertTrue(c.calculateAverageRating() == 0.00);
		reviews.add(new CoasterReview((byte) 5, 1, u));
		reviews.add(new CoasterReview((byte) 3, 2, u));
		c.setReviews(reviews);
		System.out.println("The average rating is : " + c.calculateAverageRating());
		assertTrue(c.calculateAverageRating() == 4.00);
		System.out.println("test for calculateAverageRating() has passed");
	}

	public void testEqualsCoaster() {
		Coaster c1 = new Coaster("Kcee Coaster", cm, 1999, 1);
		Coaster c2 = new Coaster("Kcee Coaster", cm, 1999, 1);
		assertTrue(c1.equals(c2));
		c2.setName("Kcee Coaster 2");
		assertTrue(c1.equals(c2));
		c2.setName("Kcee Coaster");
		c2.setYearCreated(2100);
		assertTrue(c1.equals(c2));
		c2.setYearCreated(1999);
		c2.setCoasterId(2);
		assertFalse(c1.equals(c2));
		System.out.println("test for equals() has passed");
	}

	public void testValidate() {
		Coaster c = new Coaster("abcd", cm, 100, 1);
		assertTrue(c.validate());
		c.setCoasterId(-1);
		assertFalse(c.validate());
		c.setCoasterId(1);
		c.setName(null);
		assertFalse(c.validate());
		c.setName("abcd");
		c.setManufacturer(null);
		assertFalse(c.validate());
		c.setManufacturer(cm);
		c.setYearCreated(-1);
		assertFalse(c.validate());
		System.out.println("test for validate() has passed");
	}

}
