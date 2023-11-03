package com.learnwithme.curd.exception;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.learnwithme.curd.commons.PersonConstant;

/**
 * Controller for Global Exception handling
 * */
@RestControllerAdvice
public class GlobalExceptionHandling {

	/**
	 * Global Exception handler
	 * */
	@ExceptionHandler(Exception.class)
	public ResponseEntity<Map<String, String>> handleGlobalExecption(Exception exception) {
		Map<String, String> errorMap = new HashMap<>();
		errorMap.put("error", PersonConstant.UNEXCEPTED_ERROR_OCCURED);
		errorMap.put("message", exception.getMessage());
		errorMap.put("timestamp", LocalDateTime.now().toString());
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorMap);
	}
}
