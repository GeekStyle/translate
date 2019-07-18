package com.geekstylecn.translate.service;

import java.util.List;

import com.geekstylecn.translate.model.MallCustomProduct;

public interface MallCustomProductService {
	
	public MallCustomProduct getMallCustomProduct(Long id);
	
	public List<MallCustomProduct> getAllMallCustomProduct();
}
