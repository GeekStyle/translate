package com.geekstylecn.translate.dao;

import java.util.List;

import com.geekstylecn.translate.model.Review;

public interface ReviewDao {
	
	public List<Review> getReviewList(Long productId);
	
}
