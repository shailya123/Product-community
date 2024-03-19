package com.demo.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class ProductDetails {
	@Id
	private long sampleId;
	private String id;
	private String name;
	private String colour;
	private String gender;
	private String size;
	private double price;
	private double rating;
	private String availability;
	private String brand;
	private String image;

	public ProductDetails(long sampleId, String id, String name, String colour, String gender, String size,
			double price, double rating, String availability, String brand, String image) {
		super();
		this.sampleId = sampleId;
		this.id = id;
		this.name = name;
		this.colour = colour;
		this.gender = gender;
		this.size = size;
		this.price = price;
		this.rating = rating;
		this.availability = availability;
		this.brand = brand;
		this.image = image;
	}

	public ProductDetails() {
		super();
	}

	public long getSampleId() {
		return sampleId;
	}

	public void setSampleId(long sampleId) {
		this.sampleId = sampleId;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String Name) {
		this.name = Name;
	}

	public String getColour() {
		return colour;
	}

	public void setColour(String Colour) {
		this.colour = Colour;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getSize() {
		return size;
	}

	public void setSize(String Size) {
		this.size = Size;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double Price) {
		this.price = Price;
	}

	public double getRating() {
		return rating;
	}

	public void setRating(double Rating) {
		this.rating = Rating;
	}

	public String getAvailability() {
		return availability;
	}

	public void setAvailability(String Availability) {
		this.availability = Availability;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

}
