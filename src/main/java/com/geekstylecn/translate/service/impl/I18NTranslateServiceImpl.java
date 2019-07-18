package com.geekstylecn.translate.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.geekstylecn.translate.dao.I18NTranslateDao;
import com.geekstylecn.translate.model.I18NTranslate;
import com.geekstylecn.translate.service.I18NTranslateService;

@Service
public class I18NTranslateServiceImpl implements I18NTranslateService{

	@Autowired
	I18NTranslateDao i18NTranslateDao;
	
	@Override
	public String getValue(I18NTranslate params) {
		return i18NTranslateDao.getValue(params);
	}

	@Override
	public Map<String, String> batchQuery(List<String> i18nKeyList,String locale) {
		Map<String, String> result = new HashMap<String, String>();
		Map<String,Object> params = new HashMap<String,Object>();
		params.put("keyList", i18nKeyList);
		params.put("locale", locale);
		List<I18NTranslate> i18NTranslateList = i18NTranslateDao.batchQuery(params);
		for(I18NTranslate i18NTranslate : i18NTranslateList) {
			result.put(i18NTranslate.getKey(), i18NTranslate.getValue());
		}
		return result;
	}
	
}
