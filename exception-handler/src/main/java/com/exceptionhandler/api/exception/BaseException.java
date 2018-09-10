package com.exceptionhandler.api.exception;

import org.springframework.http.HttpStatus;

public abstract class BaseException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	private String errorCode;
	private String defaultMessage;
	private String[] params;
	private HttpStatus responseCode;

	public BaseException(final String errorCode, final String defaultMessage) {
		this.errorCode = errorCode;
		this.defaultMessage = defaultMessage;
	}

	public BaseException(final String errorCode, final String defaultMessage, final HttpStatus responseCode) {
		this(errorCode, defaultMessage);
		this.responseCode = responseCode;
	}

	public BaseException(final String errorCode, final String defaultMessage, final Exception ex) {
		super(ex);
		this.errorCode = errorCode;
		this.defaultMessage = defaultMessage;
	}

	public BaseException(final String errorCode, final Exception ex, final String[] params) {
		super(ex);
		this.errorCode = errorCode;
		this.params = params;
	}

	@Override
	public String getMessage() {
		return defaultMessage;
	}

	public void setMessage(final String defaultMessage) {
		this.defaultMessage = defaultMessage;
	}

	public String[] getParams() {
		return params;
	}

	public void setParams(final String[] params) {
		this.params = params;
	}

	public String getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(final String errorCode) {
		this.errorCode = errorCode;
	}

	public HttpStatus getResponseCode() {
		return responseCode;
	}

	public void setResponseCode(final HttpStatus responseCode) {
		this.responseCode = responseCode;
	}
}
