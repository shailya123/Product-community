package com.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.model.Product_Review;
import com.demo.repo.ReviewOfProductRepo;

@Service
public class AllReviewService {
	@Autowired
	private ReviewOfProductRepo repo;

	public List<Product_Review> findAllReview() {
		return repo.findAll();
	}

}
