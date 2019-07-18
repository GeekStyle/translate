package com.geekstylecn.translate.dao;
import java.util.List;
import java.util.Map;

import com.geekstylecn.translate.model.I18NTranslate;

public interface I18NTranslateDao {
	
	public String getValue(I18NTranslate params);
	
	public List<I18NTranslate> batchQuery(Map<String,Object> params);
	
}
