package com.coasterreviewer.model.domain;
import java.io.Serializable;

/**
 * This is the CoasterReview class containing information
 * about a CoasterReview.
 * 
 * @author Kcee Landon
 * @version 1.0
 * @since 2024-11-03
 */
public class CoasterReview implements Serializable {
	private String title;
	private String reviewBody;
	private byte rating;
	private int reviewId;
	private User createdByUser;
	
	/**
	 * @param rating This is the byte value to set the rating field to.
	 * @param reviewId This is the int value to set the reviewId field to.
	 * @param createdByUser This is the User object to set the createdByUser field to.
	 */
	public CoasterReview(byte rating, int reviewId, User createdByUser) {
		this.setTitle(null);
		this.setReviewBody(null);
		this.setRating(rating);
		this.setReviewId(reviewId);
		this.setCreatedByUser(createdByUser);
	}

	/**
	 * @param title This is the String value to set the title field to.
	 * @param reviewBody This is the String value to set the reviewBody field to.
	 * @param rating This is the byte value to set the rating field to.
	 * @param reviewId This is the int value to set the reviewId field to.
	 * @param createdByUser This is the User object to set the createdByUser field to.
	 */
	public CoasterReview(String title, String reviewBody, byte rating, int reviewId, User createdByUser) {
		this.setTitle(title);
		this.setReviewBody(reviewBody);
		this.setRating(rating);
		this.setReviewId(reviewId);
		this.setCreatedByUser(createdByUser);
	}

	/**
	 * @return This returns the String value of the title field.
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * @param title This is the String value to set the title field to.
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * @return This returns the String value of the reviewBody field.
	 */
	public String getReviewBody() {
		return this.reviewBody;
	}

	/**
	 * @param reviewBody This is the String value to set the reviewBody field to.
	 */
	public void setReviewBody(String reviewBody) {
		this.reviewBody = reviewBody;
	}

	/**
	 * @return This returns the byte value of the rating field.
	 */
	public byte getRating() {
		return this.rating;
	}

	/**
	 * @param rating This is the byte value to set the rating field to.
	 */
	public void setRating(byte rating) {
		this.rating = rating;
	}

	/**
	 * @return This returns the int value of the reviewId field.
	 */
	public int getReviewId() {
		return this.reviewId;
	}

	/**
	 * @param reviewId This is the int value to set the reviewId field to.
	 */
	public void setReviewId(int reviewId) {
		this.reviewId = reviewId;
	}
	
	/**
	 * @return This returns the User object value of the createdByUser field.
	 */
	public User getCreatedByUser() {
		return this.createdByUser;
	}

	/**
	 * @param createdByUser This is the User object to set the createdByUser field to.
	 */
	public void setCreatedByUser(User createdByUser) {
		this.createdByUser = createdByUser;
	}
	
	/**
	 * @param other This is the CoasterReview object to compare to this CoasterReview object.
	 * @return This returns a boolean value dependent on if this CoasterReview equals other CoasterReview.
	 */
	public boolean equals(CoasterReview other) {
		return this.hashCode() == other.hashCode();
	}
	
	/**
	 * @return This returns a boolean value dependent on if the initialization of data fields are correct.
	 */
	public boolean validate() {
		if (this.getRating() < 0 || this.getReviewId() < 0) {
			return false;
		}
		if (this.getTitle() == null && this.getReviewBody() != null) {
			return false;
		}
		if (this.getReviewBody() == null && this.getTitle() != null) {
			return false;
		}
		return true;
	}
	
	/**
	 * @return This returns a hashcode value as an integer for usage in equals().
	 */
	public int hashCode() {
		int hash = 7;
		return 31 + hash * this.getReviewId();
	}
	
	/**
	 * @return This returns a String representing the current CoasterReview object.
	 */
	public String toString() {
		return "" + (int) this.getRating() + "reviewID" + this.getReviewId();
	}

}
