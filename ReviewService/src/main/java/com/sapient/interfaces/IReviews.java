package com.sapient.interfaces;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.sapient.entity.Reviews;

@Repository
public interface IReviews extends JpaRepository<Reviews, Integer> {
	
	Reviews findByReviewId(int id);
	
	@Transactional
	@Modifying
	@Query(value ="Update reviews r set r.review= ?1 where r.review_id =?2" , nativeQuery =true)
	int updateReview(@Param(value = "review") String review, @Param(value = "id") int id);


}
