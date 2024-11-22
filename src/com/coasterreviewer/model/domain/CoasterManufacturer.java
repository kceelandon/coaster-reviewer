package com.coasterreviewer.model.domain;

import java.time.LocalDate;
import java.io.Serializable;

/**
 * This is the CoasterManufacturer class containing information
 * regarding a Coaster's manufacturer.
 * 
 * @author Kcee Landon
 * @version 1.0
 * @since 2024-11-03
 */
public class CoasterManufacturer implements Serializable {
	private String name;
	private LocalDate dateEstablished;
	private int manufacturerId;

	/**
	 * @param name This is the String value to initialize the name field to.
	 * @param id This is the int value to initialize the manufacturerId field to.
	 */
	public CoasterManufacturer(String name, int id) {
		this.setName(name);
		this.setDateEstablished(null);
		this.setManufacturerId(id);
	}
	
	/**
	 * @return This returns the LocalDate value of the date the manufacturer was established.
	 */
	public LocalDate getDateEstablished() {
		return this.dateEstablished;
	}

	/**
	 * @param dateEstablished This is the LocalDate value to set the dateEstablished field to.
	 */
	public void setDateEstablished(LocalDate dateEstablished) {
		this.dateEstablished = dateEstablished;
	}

	/**
	 * @return This returns the String value of the name field.
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
	 * @return This returns the unique int id of the manufacturerId field.
	 */
	public int getManufacturerId() {
		return this.manufacturerId;
	}
	
	/**
	 * @param manufacturerId This is the int value of the manufacturerId field.
	 */
	public void setManufacturerId(int manufacturerId) {
		this.manufacturerId = manufacturerId;
	}
	
	/**
	 * @param other This is the CoasterManufacturer object of the other CoasterManufacturer being compared to this.
	 * @return This returns the boolean value of whether or not this equals other.
	 */
	public boolean equals(CoasterManufacturer other) {
		return this.getManufacturerId() == other.getManufacturerId();
	}
	
	/**
	 * @return This returns the boolean value of whether or not the data fields are initialized correctly.
	 */
	public boolean validate() {
		if (this.getName() == null) {
			return false;
		}
		if (this.getManufacturerId() < 0) {
			return false;
		}
		return true;
	}
	
	/**
	 * @return This returns a hashcode value as an integer for usage in equals().
	 */
	public int hashCode() {
		int hash = 13;
		return 31 + hash * this.getManufacturerId();
	}
	
	/**
	 * @return This returns a String representing the current CoasterManufacturer object.
	 */
	public String toString() {
		return "" + this.getManufacturerId() + this.getName();
	}

}
