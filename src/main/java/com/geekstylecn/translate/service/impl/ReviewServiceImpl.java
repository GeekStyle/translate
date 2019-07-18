package com.geekstylecn.translate.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.geekstylecn.translate.dao.ReviewDao;
import com.geekstylecn.translate.model.Review;
import com.geekstylecn.translate.service.ReviewService;

@Service
public class ReviewServiceImpl implements ReviewService {
	
	@Autowired
	ReviewDao reviewDao;

	@Override
	public List<Review> getReviewList(Long productId) {
		return reviewDao.getReviewList(productId);
	}
	
}
