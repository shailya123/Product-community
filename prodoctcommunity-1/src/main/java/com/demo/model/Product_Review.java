package com.demo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Product_Review {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int serialNo;
	private String id;
	private String heading;
	private double rating;
	private String review;
	private String status;

	public Product_Review(int serialNo, String id, String heading, double rating, String review,String status) {
		super();
		this.serialNo = serialNo;
		this.id = id;
		this.heading = heading;
		this.rating = rating;
		this.review = review;
		this.status=status;
	}

	public Product_Review() {
		super();
	}

	public int getSerialNo() {
		return serialNo;
	}

	public void setSerialNo(int serialNo) {
		this.serialNo = serialNo;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getHeading() {
		return heading;
	}

	public void setHeading(String heading) {
		this.heading = heading;
	}

	public double getRating() {
		return rating;
	}

	public void setRating(double rating) {
		this.rating = rating;
	}

	public String getReview() {
		return review;
	}

	public void setReview(String review) {
		this.review = review;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Product_Review [serialNo=" + serialNo + ", id=" + id + ", heading=" + heading + ", rating=" + rating
				+ ", review=" + review + ", status=" + status + "]";
	}


}