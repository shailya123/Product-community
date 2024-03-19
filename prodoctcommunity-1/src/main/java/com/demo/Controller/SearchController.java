package com.demo.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.demo.model.ProductDetails;
import com.demo.service.SaveDataService;
import com.demo.service.SearchService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class SearchController {
	@Autowired
	private SaveDataService service;
	@Autowired
	private SearchService serv;

	@GetMapping("/welcome/product")
	public List<ProductDetails> getProduct() {
		return service.getAllData();
	}

	@GetMapping("/search")
	ResponseEntity<List<ProductDetails>> searchProduct(@RequestParam("query") String query) {
		return ResponseEntity.ok(serv.searchProducts(query));
	}
}
