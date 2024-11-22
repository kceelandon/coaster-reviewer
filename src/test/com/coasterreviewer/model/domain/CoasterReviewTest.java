package test.com.coasterreviewer.model.domain;

import com.coasterreviewer.model.domain.CoasterReview;
import com.coasterreviewer.model.domain.User;

import junit.framework.TestCase;

public class CoasterReviewTest extends TestCase {

	public void testEqualsCoasterReview() {
		User u1 = new User("Kcee", "Landon", 1);
		User u2 = new User("Kcee", "Brandon", 2);
		CoasterReview c1 = new CoasterReview((byte)1, 1, u1);
		CoasterReview c2 = new CoasterReview((byte)1, 1, u1);
		assertTrue(c1.equals(c2));
		c2.setCreatedByUser(u2);
		assertTrue(c1.equals(c2));
		c2.setCreatedByUser(u1);
		c2.setReviewId(2);
		assertFalse(c1.equals(c2));
		System.out.println("test for equals() has passed");
	}

	public void testValidate() {
		User u = new User("Kcee", "Landon", 1);
		CoasterReview c = new CoasterReview((byte)5, 1, u);
		assertTrue(c.validate());
		c.setRating((byte)-1);
		assertFalse(c.validate());
		c.setRating((byte)5);
		c.setReviewId(-1);
		assertFalse(c.validate());
		c.setReviewId(1);
		c.setTitle("");
		assertFalse(c.validate());
		c.setTitle(null);
		c.setReviewBody("");
		assertFalse(c.validate());
		System.out.println("test for validate() has passed");
	}

}
