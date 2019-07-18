package com.geekstylecn.translate.service;

import java.util.List;

import com.geekstylecn.translate.model.Review;

public interface ReviewService {
	
	public List<Review> getReviewList(Long productId);
	
}
