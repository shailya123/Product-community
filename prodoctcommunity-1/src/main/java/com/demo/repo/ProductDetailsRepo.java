package com.demo.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.demo.model.ProductDetails;

@Repository
public interface ProductDetailsRepo extends JpaRepository<ProductDetails, Integer> {
	@Query("select p from ProductDetails p where " + "p.name like concat('%',:query,'%')"
			+ "or p.brand like concat('%',:query,'%')" + "or p.id like concat('%',:query,'%')")
	public List<ProductDetails> searchProducts(String query);
}
