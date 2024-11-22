package com.coasterreviewer.model.domain;
import java.util.*;
import java.io.Serializable;

/**
 * This is the SearchResult class containing
 * information regarding a Search Result.
 * 
 * @author Kcee Landon
 * @version 1.0
 * @since 2024-11-03
 */
public class SearchResult implements Serializable {
	private List<Coaster> coasterList;

	/**
	 * This creates an empty CoasterList to display in a SearchResult.
	 */
	public SearchResult() {
		this.setCoasterList(new LinkedList<Coaster>());
	}

	/**
	 * @return This returns the List<Coaster> coasterList field.
	 */
	public List<Coaster> getCoasterList() {
		return this.coasterList;
	}

	/**
	 * @param coasterList This is the coasterList value to set the coasterList field to.
	 */
	public void setCoasterList(List<Coaster> coasterList) {
		this.coasterList = coasterList;
	}
	
	/**
	 * @param c This is the Coaster value to append to the coasterList field.
	 */
	public void addCoaster(Coaster c) {
		this.coasterList.add(c);
	}
	
	/**
	 * @param other This is the SearchResult object to compare to this SearchResult.
	 * @return This returns a boolean value dependent on if this SearchResult is equal to other.
	 */
	public boolean equals(SearchResult other) {
		return this.hashCode() == other.hashCode();
	}
	
	/**
	 * @return This returns a boolean value dependent on if the initialization of SearchResult fields are correct.
	 */
	public boolean validate() {
		return this.getCoasterList() != null;
	}
	
	/**
	 * @return This returns a hashcode value as an integer for usage in equals().
	 * Note: the hashCode value will be 0 for all empty SearchResult objects.
	 */
	public int hashCode() {
		int hash = 7;
		int result = 0;
		for (Coaster c : this.getCoasterList()) {
			result += 31 + hash * c.getCoasterId();
		}
		return result;
	}
	
	/**
	 * @return This returns a String representing the current SearchResult object.
	 */
	public String toString() {
		String result = "";
		for (Coaster c : this.getCoasterList()) {
			result += c.getCoasterId() + c.getName();
		}
		return result;
	}

}
