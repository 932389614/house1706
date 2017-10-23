package com.mlz.house1706.controller;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
//@ControllerAdvice
public class ExceptionAspect {
	@ExceptionHandler({Exception.class})
	public String toException() {
		return "error/hint ";		
	}
}
