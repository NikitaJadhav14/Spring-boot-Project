package com.jsp.product.category.exceptionhandler;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ApplicationExceptionController extends ResponseEntityExceptionHandler {

	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {

		Map<String, String> map = new LinkedHashMap<String, String>();
		List<ObjectError> errors = ex.getAllErrors();

		for (ObjectError error : errors) {
			FieldError fe = (FieldError) error;
			String fieldName = fe.getField();

			// String fieldName=((FieldError)error).getField();

			String message = error.getDefaultMessage();

			map.put(fieldName, message);
		}

		return new ResponseEntity<Object>(map, HttpStatus.BAD_REQUEST);
	}
}
