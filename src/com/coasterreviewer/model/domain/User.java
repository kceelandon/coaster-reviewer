package com.coasterreviewer.model.domain;

import java.util.*;
import java.io.Serializable;

/**
 * This is the User class containing information
 * modeling a User in the CoasterReviewer app.
 * 
 * @author Kcee Landon
 * @version 1.0
 * @since 2024-11-03
 */
public class User implements Serializable {
	private String firstName;
	private String lastName;
	private byte age;
	private int id;
	private List<CoasterReview> reviews;
	
	/**
	 * @param firstName This is the String value to initialize the firstName field to.
	 * @param lastName This is the String value to initialize the lastName field to.
	 * @param id This is the int value to initialize the id field to.
	 */
	public User(String firstName, String lastName, int id) {
		this.setFirstName(firstName);
		this.setLastName(lastName);
		this.setUserId(id);
		this.setReviews(new LinkedList<CoasterReview>());
	}
	
	/**
	 * @return This returns the String value of the firstName field.
	 */
	public String getFirstName() {
		return this.firstName;
	}
	
	/**
	 * @return This returns the String value of the lastName field.
	 */
	public String getLastName() {
		return this.lastName;
	}
	
	/**
	 * @param firstName This is the String value to set the firstName data field to.
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	/**
	 * @param lastName This is the String value to set the lastName data field to.
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	/**
	 * @return This returns the byte value of the age data field.
	 */
	public byte getAge() {
		return this.age;
	}
	
	/**
	 * @param age This is the byte value to set the age data field to.
	 */
	public void setAge(byte age) {
		this.age = age;
	}
	
	/**
	 * @return This returns the int value of the id data field.
	 */
	public int getUserId() {
		return this.id;
	}
	
	/**
	 * @param id This is the int value to set the id data field to.
	 */
	public void setUserId(int id) {
		this.id = id;
	}
	
	/**
	 * @return This returns a list of CoasterReview objects associated with the current User.
	 */
	public List<CoasterReview> getReviews() {
		return reviews;
	}

	/**
	 * @param reviews This is the list of CoasterReview objects to set the reviews data field to.
	 */
	public void setReviews(List<CoasterReview> reviews) {
		this.reviews = reviews;
	}
	
	/**
	 * @param u This is the other user being compared to this User object.
	 * @return This returns a boolean value dependent on if this User object equals the other User object.
	 */
	public boolean equals(User other) {
		return this.hashCode() == other.hashCode();
	}
	
	/**
	 * @return This returns a boolean value dependent on if the data fields have been initialized correctly.
	 */
	public boolean validate() {
		if (this.getFirstName() == null || this.getLastName() == null || this.getUserId() < 0) {
			return false;
		}
		return true;
	}
	
	/**
	 * @return This returns a hashcode value as an integer for usage in equals().
	 */
	public int hashCode() {
		int hash = 11;
		return hash * 31 + this.getUserId();
	}
	
	/**
	 * @return This returns a String representing the current User object.
	 */
	public String toString() {
		return "" + this.getFirstName() + this.getLastName() + this.getUserId();
	}
}
