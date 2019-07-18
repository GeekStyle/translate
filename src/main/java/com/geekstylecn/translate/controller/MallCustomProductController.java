package com.geekstylecn.translate.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.geekstylecn.translate.model.MallCustomProduct;
import com.geekstylecn.translate.service.I18NTranslateService;
import com.geekstylecn.translate.service.MallCustomProductService;

@RestController
@RequestMapping("/product")
public class MallCustomProductController {
	
	@Autowired
	MallCustomProductService mallCustomProductService;
	
	@Autowired
	I18NTranslateService i18NTranslateService;
	
	@GetMapping("/{id}")
	public String getMallCustomProduct(HttpServletRequest request, @PathVariable Long id) {
		long startTime = System.currentTimeMillis();
		//get all the dao keys and get them in just one dao access
		
		MallCustomProduct mallCustomProduct = mallCustomProductService.getMallCustomProduct(id);
		String locale = request.getHeader("i18n");
		JSONObject result = new JSONObject(mallCustomProduct);
		List<String> i18nKeyList = getI18nKeyList(result,null);
		Map<String, String> i18nMap =  i18NTranslateService.batchQuery(i18nKeyList,locale); // one time batch dao
		result = translate(result, locale, i18nMap);
		
		System.out.println("time spent: " + (System.currentTimeMillis() - startTime));
		return result.toString();
	}
	
	@GetMapping
	public ResponseEntity<?> getAllMallCustomProduct(HttpServletRequest request) {
		List<MallCustomProduct> mallCustomProductList = mallCustomProductService.getAllMallCustomProduct();
		return ResponseEntity.status(HttpStatus.OK).body(mallCustomProductList);
	}
	
	private List<String> getI18nKeyList(JSONObject source, List<String> i18nKeyList) {
		if(i18nKeyList == null) {
			i18nKeyList = new ArrayList<String>();
		}
		
		Set<String> keys = source.keySet();
		for(String key : keys) {
			Object value = source.get(key);
			if( value instanceof String && ((String)value).startsWith("i18n_") ) {
				i18nKeyList.add((String)value);
			}else if( value instanceof JSONObject ) {
				getI18nKeyList( (JSONObject)value, i18nKeyList);
			}else if( value instanceof JSONArray ) {
				for (int i = 0; i < ((JSONArray) value).length(); i++) {
					getI18nKeyList(((JSONArray) value).getJSONObject(i), i18nKeyList);
				}
			}
		}
		
		return i18nKeyList;
	}
	
	private JSONObject translate(JSONObject source,String locale, Map<String, String> i18nMap ) {
		
		Set<String> keys = source.keySet();
		for(String key : keys) {
			Object value = source.get(key);
			if( value instanceof String && ((String)value).startsWith("i18n_") ) {
				source.put(key, i18nMap.get(value));
			}else if( value instanceof JSONObject ) {
				translate( (JSONObject)value, locale,i18nMap);
			}else if( value instanceof JSONArray ) {
				for (int i = 0; i < ((JSONArray) value).length(); i++) {
					translate(((JSONArray) value).getJSONObject(i), locale,i18nMap);
				}
			}
		}
		
		return source;
	}
	
}
