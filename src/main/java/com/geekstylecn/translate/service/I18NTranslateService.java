package com.geekstylecn.translate.service;

import java.util.List;
import java.util.Map;

import com.geekstylecn.translate.model.I18NTranslate;

public interface I18NTranslateService {
	
	public String getValue(I18NTranslate params);
	
	public Map<String, String> batchQuery(List<String> i18nKeyList,String locale);
}
