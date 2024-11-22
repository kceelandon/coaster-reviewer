package com.coasterreviewer.model.domain;
import java.util.*;
import java.io.Serializable;

/**
 * This is a domain class modeling a Coaster. It contains
 * useful methods for gathering information surrounding
 * a coaster.
 * 
 * @author Kcee Landon
 * @version 1.0
 * @since 2024-11-03
 * 
 */
public class Coaster implements Serializable {
	private String name;
	private String description;
	private CoasterManufacturer manufacturer;
	private int yearCreated;
	private int coasterId;
	private String imagePath;
	private List<CoasterReview> reviews;
	
	/**
	 * @param name The String value to set the name field to.
	 * @param manufacturer The CoasterManufacturer value of the Coaster to set the manufacturer field to.
	 * @param yearCreated The int value representing the year the Coaster was created.
	 * @param coasterId A unique integer id to set the coasterId field to.
	 */
	public Coaster(String name, CoasterManufacturer manufacturer, int yearCreated, int coasterId) {
		this.name = name;
		this.description = null;
		this.manufacturer = manufacturer;
		this.yearCreated = yearCreated;
		this.coasterId = coasterId;
		this.imagePath = null;
		this.reviews = new LinkedList<CoasterReview>();
	}
	
	/**
	 * @return String This returns the name field.
	 */
	public String getName() {
		return this.name;
	}
	
	/**
	 * @param name This is the String value to set the name field to.
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * @return This returns the description field.
	 */
	public String getDescription() {
		return this.description;
	}
	

	/**
	 * @param description This is the String value to set the description field to.
	 */
	public void setDescription(String description) {
		this.description = description;
	}
	
	/**
	 * @return This returns the manufacturer field of type CoasterManufacturer.
	 */
	public CoasterManufacturer getManufacturer() {
		return this.manufacturer;
	}
	
	/**
	 * @param manufacturer This is the CoasterManufacturer value to set the manufacturer field to.
	 */
	public void setManufacturer(CoasterManufacturer manufacturer) {
		this.manufacturer = manufacturer;
	}
	
	/**
	 * @return This returns the integer field of yearCreated.
	 */
	public int getYearCreated() {
		return this.yearCreated;
	}
	
	/**
	 * @param yearCreated This is the integer value to set the yearCreated field to.
	 */
	public void setYearCreated(int yearCreated) {
		this.yearCreated = yearCreated;
	}
	
	/**
	 * @return This returns the String field of imagePath.
	 */
	public String getImagePath() {
		return this.imagePath;
	}
	
	/**
	 * @param imagePath This is the String value to set the imagePath field to.
	 */
	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}
	
	/**
	 * @return This returns the integer field of the coasterId.
	 */
	public int getCoasterId() {
		return this.coasterId;
	}
	
	/**
	 * @param coasterId This is the integer value to set the coasterId field to.
	 */
	public void setCoasterId(int coasterId) {
		this.coasterId = coasterId;
	}
	
	/**
	 * @return This returns the List of CoasterReview that is associated with the current Coaster.
	 */
	public List<CoasterReview> getReviews() {
		return this.reviews;
	}
	
	/**
	 * @param reviews This is the List<CoasterReview> value to set the reviews field to.
	 */
	public void setReviews(List<CoasterReview> reviews) {
		this.reviews = reviews;
	}
	
	/**
	 * @return This returns the double value of the average rating across all reviews for this Coaster.
	 */
	public double calculateAverageRating() {
		if (this.getReviews().size() == 0) {
			return 0.00;
		}
		int counter = 0;
		int sum = 0;
		for (CoasterReview r : this.getReviews()) {
			counter++;
			sum += r.getRating();
		}
		return Math.round((((double) sum / counter) * 100.0) / 100.0);
	}
	
	/**
	 * @param other This is the Coaster value to compare to the current Coaster.
	 * @return This returns a boolean value dependent on if other Coaster is equal to this Coaster.
	 */
	public boolean equals(Coaster other) {
		return this.hashCode() == other.hashCode();
	}

	/**
	 * @return This returns a boolean value dependent on if the initialization of variables is validated.
	 */
	public boolean validate() {
		if (this.getName() == null || this.getManufacturer() == null || this.getYearCreated() < 0 || this.getCoasterId() < 0) {
			return false;
		}
		return true;
	}
	
	/**
	 * @return This returns a hashcode value as an integer for usage in equals().
	 */
	public int hashCode() {
		int hash = 5;
		return (int) this.getCoasterId() + 31 * hash;
	}
	
	/**
	 * @return This returns a String representing the current Coaster object.
	 */
	public String toString() {
		return "" + this.getName().replaceAll(" ", "_") + this.getCoasterId();
	}

}
