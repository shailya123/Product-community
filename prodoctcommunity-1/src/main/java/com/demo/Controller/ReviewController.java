package com.demo.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.demo.model.Product_Review;
import com.demo.service.AllReviewService;
import com.demo.service.AvgReviewService;
import com.demo.service.ReviewService;
import com.demo.service.UpdateStatusService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class ReviewController {
	@Autowired
	private ReviewService serv;
	@Autowired
	private AvgReviewService service;
	@Autowired
	private AllReviewService service1;
	@Autowired
	private UpdateStatusService updateService;

	@PostMapping("/postreview")
	public Product_Review postReview(@RequestBody Product_Review review) throws Exception {
		return serv.saveReview(review);
	}

	@GetMapping("/review")
	ResponseEntity<List<Product_Review>> reviewOfProducts(@RequestParam("query2") String query2) {
		return ResponseEntity.ok(serv.reviewOfProducts(query2));
	}

	@GetMapping("/avgreview")
	ResponseEntity<Double> averageOfReviews(@RequestParam("query3") String query3) {
		return ResponseEntity.ok(service.averageOfReviews(query3));
	}

	@GetMapping("/allreview")
	public List<Product_Review> getAllReview() {
		return service1.findAllReview();
	}

	@GetMapping("/updatestatus")
	public void statusofReviews(int serialNo) {
		updateService.StatusofReviews(serialNo);
	}

	@GetMapping("/rejectstatus")
	public void rejectReview(int serialNo) {
		updateService.rejectReview(serialNo);
	}
}
