package com.geekstylecn.translate.annotation;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import com.geekstylecn.translate.model.MallCustomProduct;

public class TestMain {

	public static void main(String[] args) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		MallCustomProduct mallCustomerProduct = new MallCustomProduct();

		for (Field field : mallCustomerProduct.getClass().getDeclaredFields()) {
			if (field.isAnnotationPresent(I18N.class)) {
				I18N i18n = field.getAnnotation(I18N.class);
				for (Method method : i18n.annotationType().getDeclaredMethods()) {
	                Object value = method.invoke(i18n, (Object[])null);
	                System.out.println(" " + method.getName() + ": " + value);
	                if(method.getName().equals("recordId")) {
	                	String idFieldName = value.toString();
	                	Method getIdMethod = mallCustomerProduct.getClass().getMethod("idFieldName");
	                }
	            }
			}
		}

	}

}
