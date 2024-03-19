package com.demo.service;

import java.util.List;

import com.demo.model.Product_Review;

public interface ReviewData {
	List<Product_Review> reviewOfProducts(String query);

}
