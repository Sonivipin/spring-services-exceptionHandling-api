package com.exceptionhandler.api.controller;

import java.util.List;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.exceptionhandler.api.common.util.Constant;
import com.exceptionhandler.api.common.util.MessageConfigure;
import com.exceptionhandler.api.dto.ErrorResponse;
import com.exceptionhandler.api.exception.BaseException;

@RestControllerAdvice
public class ExceptionControllerAdvice {

	private static final Logger logger = LoggerFactory.getLogger(ExceptionControllerAdvice.class);

	private final MessageConfigure messageConfigure;
	private final MessageSource msgSource;

	@Autowired
	public ExceptionControllerAdvice(final MessageConfigure messageConfigure, final MessageSource msgSource) {
		super();
		this.messageConfigure = messageConfigure;
		this.msgSource = msgSource;
	}

	/**
	 * Exception handler for Base Exception and its sub class Exception.
	 * 
	 * @param t
	 * @return
	 */
	@ExceptionHandler(BaseException.class)
	public <T extends BaseException> ResponseEntity<ErrorResponse> exceptionHandler(T t) {
		if (logger.isDebugEnabled()) {
			logger.debug(Constant.ENTER_METHOD + "exceptionHandler");
		}
		logger.error("Error occured with message " + t.getMessage(), t);
		ErrorResponse error = new ErrorResponse();
		error.setErrorCode(t.getErrorCode());
		error.setMessage(t.getMessage());
		HttpStatus responseCode = HttpStatus.INTERNAL_SERVER_ERROR;
		if (t.getResponseCode() != null) {
			responseCode = t.getResponseCode();
		}
		ResponseEntity<ErrorResponse> response = new ResponseEntity<ErrorResponse>(error, responseCode);
		if (logger.isDebugEnabled()) {
			logger.debug(Constant.EXIT_METHOD + "exceptionHandler");
		}
		return response;
	}

	/**
	 * Exception handler for General Exception.
	 * 
	 * @param ex
	 * @return
	 */
	@ExceptionHandler(Exception.class)
	public ResponseEntity<ErrorResponse> exceptionHandler(Exception ex) {
		if (logger.isDebugEnabled()) {
			logger.debug(Constant.ENTER_METHOD + "exceptionHandler");
		}
		logger.error("Error occured with message " + ex.getMessage(), ex);
		ErrorResponse error = new ErrorResponse();
		error.setErrorCode(HttpStatus.INTERNAL_SERVER_ERROR.toString());
		error.setMessage(Constant.GLOBAL_ERROR_MSG);
		ResponseEntity<ErrorResponse> response = new ResponseEntity<ErrorResponse>(error,
				HttpStatus.INTERNAL_SERVER_ERROR);
		if (logger.isDebugEnabled()) {
			logger.debug(Constant.EXIT_METHOD + "exceptionHandler");
		}
		return response;
	}

	/**
	 * Exception handler for MethodArgumentNotValidException and its sub class
	 * Exception.
	 * 
	 * @param t
	 * @return
	 */
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public <T extends MethodArgumentNotValidException> ResponseEntity<ErrorResponse> exceptionHandler(T t) {
		if (logger.isDebugEnabled()) {
			logger.debug(Constant.ENTER_METHOD + "exceptionHandler");
		}
		BindingResult result = t.getBindingResult();
		List<FieldError> errors = result.getFieldErrors();
		ErrorResponse errorResponse = new ErrorResponse();
		for (FieldError error : errors) {
			if (error != null) {
				Locale currentLocale = LocaleContextHolder.getLocale();
				String msg = null;
				try {
					msg = msgSource.getMessage(error.getDefaultMessage(), null, currentLocale);
				} catch (Exception ex) {
					logger.error("Error occured with message " + ex.getMessage(), ex);
					msg = error.getDefaultMessage();
				}
				String field = null;
				try {
					field = msgSource.getMessage(error.getField(), null, currentLocale);
				} catch (Exception ex) {
					logger.error("Error occured with message " + ex.getMessage(), ex);
					field = error.getField();
					field = Character.toUpperCase(field.charAt(0)) + field.substring(1);
				}
				errorResponse.setErrorCode(messageConfigure.validationErr001);
				errorResponse.setMessage(field + " " + msg);
			}
		}
		ResponseEntity<ErrorResponse> response = new ResponseEntity<ErrorResponse>(errorResponse,
				HttpStatus.BAD_REQUEST);
		if (logger.isDebugEnabled()) {
			logger.debug(Constant.EXIT_METHOD + "exceptionHandler");
		}
		return response;
	}
}
