package com.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.model.Product_Review;
import com.demo.repo.ReviewOfProductRepo;

@Service
public class ReviewService implements ReviewData {
	@Autowired
	private ReviewOfProductRepo repo;

	public ReviewService(ReviewOfProductRepo repo) {
		super();
		this.repo = repo;
	}

	public Product_Review saveReview(Product_Review review) {
		return repo.save(review);
	}

	@Override
	public List<Product_Review> reviewOfProducts(String query2) {
		List<Product_Review> products = repo.reviewOfProducts(query2);
		return products;
	}

}
