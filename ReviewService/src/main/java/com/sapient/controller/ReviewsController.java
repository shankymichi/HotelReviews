package com.sapient.controller;


import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.sapient.entity.HotelReviews;
import com.sapient.entity.RelationshipId;
import com.sapient.entity.Reviews;
import com.sapient.interfaces.IHotelReviews;
import com.sapient.interfaces.IReviews;


@RestController
public class ReviewsController {
	
	@Autowired
	IHotelReviews hotelreview;
	
	@Autowired
	IReviews reviews;
	
	Logger logger = LoggerFactory.getLogger(ReviewsController.class);
	
	@GetMapping(value="/")
	public String getcheck() {
		return "Welcome to review microservice";
	}
	
	@GetMapping(value="review/{id}")
	public List<Reviews> review(@PathVariable int id) {
		return reviews.findAll();
		
	}
	
	@GetMapping(value="/hotel/{id}")
	public List<String> getReviews(@PathVariable int id , HttpServletRequest req) {
		
		List<HotelReviews> hreviews;
		hreviews = hotelreview.findAllByHotelId(id);                  // list of tuples of Hotel_reviews table where hotel_id =id;\
		
		List<String> allreviews =new ArrayList<>();                   // list to store all the reviews
		if(hreviews.isEmpty()) {
			allreviews.add("No reviews yet!!");
			return allreviews;
		}
		
		List<Integer> rids =new ArrayList<>(); // list of review id to be returned
		for(HotelReviews i :hreviews) 
		{
			String temp= i.getReviews();
			
			
			String[] reviewlist = temp.split(",");
			//System.out.println(temp);
			for(var j : reviewlist) {
				rids.add(Integer.parseInt(j));
			}
		}
		for(int i : rids) {
			Reviews temp = reviews.findByReviewId(i);
			
			if(temp==null) {
				System.out.println("review deleted with id= "+i);
			}
			allreviews.add(temp.getReview());
		}
		
		//allreviews.add("end");
		return allreviews;
		
	
	}
	
	@DeleteMapping("/review/{id}")
	public String deleteReview(@PathVariable int id) {
		try {
		reviews.deleteById(id);
		return "Review with review id= "+ id +" deleted";
		}catch(Exception e) {
			return e.getMessage();
		}
	}
	
	//creating post mapping that post the book detail in the database  
	@PostMapping("/review")  
	private String saveReview(@RequestBody Reviews newreview)   
	{ 
		try {
	reviews.save(newreview);
	return "Review save!!"; }
		catch(Exception e) {
			return e.getMessage();
		}
	}  
	//creating put mapping that updates the review detail   
	@PutMapping("/review/{id}")  
	private String updateReview(@PathVariable int id ,@RequestBody Reviews updatedreview)   
	{ 
		try {
			//updatedreview.setReviewId(id);
				if(reviews.updateReview( updatedreview.getReview(),id)==1) {
					
				return "Review Updated!!";
					}
				else {
				return "Review Not Found!!";	
				}
	}
		catch(Exception e) {
			return e.getMessage();
		}
	}  
	
	

		

}
