package com.demoappn.pojos;

import java.util.Date;

public class Review {

	
	private String reviewID;
	
	private int objectClass;
	
	private String review;
	
	private String location;
	
	private String createdBy;
	
	private Date createdAt;
	
	private Date updatedAt;

	public String getReviewID() {
		return reviewID;
	}

	public void setReviewID(String reviewID) {
		this.reviewID = reviewID;
	}

	public int getObjectClass() {
		return objectClass;
	}

	public void setObjectClass(int objectClass) {
		this.objectClass = objectClass;
	}

	public String getReview() {
		return review;
	}

	public void setReview(String review) {
		this.review = review;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Date getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}
	
}
