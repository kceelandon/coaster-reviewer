package test.com.coasterreviewer.model.domain;

import com.coasterreviewer.model.domain.CoasterManufacturer;

import junit.framework.TestCase;

public class CoasterManufacturerTest extends TestCase {

	public void testEqualsCoasterManufacturer() {
		CoasterManufacturer cm1 = new CoasterManufacturer("RMC", 1);
		CoasterManufacturer cm2 = new CoasterManufacturer("RMC", 1);
		assertTrue(cm1.equals(cm2));
		cm2.setManufacturerId(2);
		assertFalse(cm1.equals(cm2));
		System.out.println("test for equals() has passed");
	}

	public void testValidate() {
		CoasterManufacturer cm = new CoasterManufacturer("asdf", 1);
		assertTrue(cm.validate());
		cm.setName(null);
		assertFalse(cm.validate());
		cm.setName("asdf");
		cm.setManufacturerId(-1);
		assertFalse(cm.validate());
		System.out.println("test for validate() has passed");
	}

}
