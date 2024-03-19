package com.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.repo.ReviewOfProductRepo;

@Service
public class UpdateStatusService implements UpdateReviewService {
	@Autowired
	private ReviewOfProductRepo repo;

	public UpdateStatusService(ReviewOfProductRepo repo) {
		super();
		this.repo = repo;
	}

	@Override
	public void StatusofReviews(int serialNo) {
		repo.StatusofReviews(serialNo);

	}

	@Override
	public void rejectReview(int serialNo) {
		repo.rejectReview(serialNo);

	}

}
