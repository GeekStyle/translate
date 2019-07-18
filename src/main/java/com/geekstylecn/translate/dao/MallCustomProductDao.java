package com.geekstylecn.translate.dao;
import java.util.List;

import com.geekstylecn.translate.model.MallCustomProduct;

public interface MallCustomProductDao {
	
	public MallCustomProduct getMallCustomProduct(Long id);
	
	public List<MallCustomProduct> getAllMallCustomProduct();
	
}
