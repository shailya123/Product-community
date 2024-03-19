package com.demo.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.demo.model.Product_Review;

@Repository
public interface ReviewOfProductRepo extends JpaRepository<Product_Review, Integer> {
	@Query("select p from Product_Review p where " + "p.id like concat('%',:query2,'%')")
	public List<Product_Review> reviewOfProducts(String query2);

	@Query("select coalesce(avg(p.rating),0.0) from Product_Review p where " + "p.id =(:query3)")
	public double averageOfReviews(String query3);

	@Transactional
	@Modifying
	@Query("update Product_Review p set p.status='approved' where " + "p.serialNo =(:serialNo)")
	public void StatusofReviews(int serialNo);

	@Transactional
	@Modifying
	@Query("update Product_Review p set p.status='Not approved' where " + "p.serialNo =(:serialNo)")
	public void rejectReview(int serialNo);
}
