package com.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.repo.ReviewOfProductRepo;

@Service
public class AvgReviewService implements avgReviewData {
	@Autowired
	private ReviewOfProductRepo repo;

	public AvgReviewService(ReviewOfProductRepo repo) {
		super();
		this.repo = repo;
	}

	@Override
	public double averageOfReviews(String query3) {
		Double avg = 0.0;
		avg = repo.averageOfReviews(query3);
		return avg;
	}

}
