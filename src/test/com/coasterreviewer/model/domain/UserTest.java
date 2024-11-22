package test.com.coasterreviewer.model.domain;

import com.coasterreviewer.model.domain.User;

import junit.framework.TestCase;

public class UserTest extends TestCase {

	public void testEqualsUser() {
		User u1 = new User("Kcee", "Landon", 1);
		User u2 = new User("Kcee", "Landon", 1);
		assertTrue(u1.equals(u2));
		u2.setUserId(0);
		assertFalse(u1.equals(u2));
		u2.setUserId(1);
		u2.setLastName("Lando");
		assertTrue(u1.equals(u2));
		u2.setLastName("Landon");
		u2.setFirstName("kcee");
		assertTrue(u1.equals(u2));
		System.out.println("test for equals() has passed");
	}

	public void testValidate() {
		User u = new User(null, "Landon", 1);
		assertFalse(u.validate());
		u.setLastName(null);
		assertFalse(u.validate());
		u.setUserId(-1);
		assertFalse(u.validate());
		u.setFirstName("");
		u.setLastName("");
		u.setUserId(0);
		assertTrue(u.validate());
		System.out.println("test for validate() has passed");
	}

}
