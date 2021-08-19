package com.sapient.interfaces;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sapient.entity.HotelReviews;
import com.sapient.entity.RelationshipId;


@Repository
public interface IHotelReviews extends JpaRepository<HotelReviews, RelationshipId> {
	
	List<HotelReviews> findAllByHotelId(int id);
}
