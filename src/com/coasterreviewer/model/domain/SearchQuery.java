package com.coasterreviewer.model.domain;
import java.io.Serializable;

/**
 * This is the SearchQuery class containing information
 * to encapsulate and model a SearchQuery.
 * 
 * @author Kcee Landon
 * @version 1.0
 * @since 2024-11-03
 */
public class SearchQuery implements Serializable {
	private String query;
	
	/**
	 * This initializes the SearchQuery object with the query data field being an empty string.
	 */
	public SearchQuery() {
		this.setQuery("");
	}
	
	/**
	 * This is an overridden constructor of the SearchQuery object to initialize the query data field
	 * to a specific value.
	 * @param query This is the String value to initialize the query field to.
	 */
	public SearchQuery(String query) {
		this.setQuery(query);
	}

	/**
	 * @return This returns the String value of the query field.
	 */
	public String getQuery() {
		return this.query;
	}

	/**
	 * @param query This is the String value to set the query field to.
	 */
	public void setQuery(String query) {
		this.query = query;
	}
	
	/**
	 * @param other This is the other SearchQuery object to compare to this SearchQuery.
	 * @return This returns a boolean value dependent on if this SearchQuery equals other SearchQuery.
	 */
	public boolean equals(SearchQuery other) {
		return this.hashCode() == other.hashCode();
	}
	
	/**
	 * @return This returns a boolean value dependent on if the data fields are initialized correctly.
	 */
	public boolean validate() {
		return this.getQuery() != null;
	}
	
	/**
	 * @return This returns a hashcode value as an integer for usage in equals().
	 */
	public int hashCode() {
		int result = 0;
		int hash = 7;
		String s = this.getQuery();
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			result += 31 + hash * (int) c;
		}
		return result;
	}
	
	/**
	 * @return This returns a String representing the current SearchQuery object.
	 */
	public String toString() {
		return this.getQuery();
	}
}
