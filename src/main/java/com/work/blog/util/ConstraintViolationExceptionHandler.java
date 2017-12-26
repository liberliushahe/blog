package com.work.blog.util;

import java.util.ArrayList;
import java.util.List;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;

import org.apache.commons.lang.StringUtils;

/**
 * bean验证捕获异常信息
 * @author jijiuxue
 * @creation 2017年12月26日
 */
public class ConstraintViolationExceptionHandler {
	public static String getMessage(ConstraintViolationException e){
		List<String> msgList=new ArrayList<String>();
		
		for(ConstraintViolation<?> constraintViolation:e.getConstraintViolations()){
			msgList.add(constraintViolation.getMessage());
		}
		String messages = StringUtils.join(msgList.toArray(), ";");
		return messages;
		
	}
}
