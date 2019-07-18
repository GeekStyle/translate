package com.geekstylecn.translate.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.geekstylecn.translate.dao.MallCustomProductDao;
import com.geekstylecn.translate.model.MallCustomProduct;
import com.geekstylecn.translate.model.Review;
import com.geekstylecn.translate.service.MallCustomProductService;
import com.geekstylecn.translate.service.ReviewService;

@Service
public class MallCustomProductServiceImpl implements MallCustomProductService {

	@Autowired
	MallCustomProductDao mallCustomProductDao;
	
	@Autowired
	ReviewService reviewService;
	
	@Override
	public MallCustomProduct getMallCustomProduct(Long id) {
		MallCustomProduct mallCustomProduct = mallCustomProductDao.getMallCustomProduct(id);
		List<Review> reviewList = reviewService.getReviewList(mallCustomProduct.getId());
		mallCustomProduct.setReviewList(reviewList);
		return mallCustomProduct;
	}

	@Override
	public List<MallCustomProduct> getAllMallCustomProduct() {
		return mallCustomProductDao.getAllMallCustomProduct();
	}

}
