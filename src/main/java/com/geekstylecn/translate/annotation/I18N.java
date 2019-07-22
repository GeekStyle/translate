package com.geekstylecn.translate.annotation;

import static java.lang.annotation.ElementType.FIELD;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(FIELD)
public @interface I18N {
	
	 public String table() default "";
	 public String recordId() default "";
	 public String column() default "";
	
}
