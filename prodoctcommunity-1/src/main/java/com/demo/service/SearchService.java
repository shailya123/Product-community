package com.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.model.ProductDetails;
import com.demo.repo.ProductDetailsRepo;

@Service
public class SearchService implements ProductSearch {
	@Autowired
	private ProductDetailsRepo repo;

	public SearchService(ProductDetailsRepo repo) {
		super();
		this.repo = repo;
	}

	@Override
	public List<ProductDetails> searchProducts(String query) {
		List<ProductDetails> products = repo.searchProducts(query);
		return products;
	}

}
