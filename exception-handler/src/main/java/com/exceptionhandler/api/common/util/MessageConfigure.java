package com.exceptionhandler.api.common.util;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;

@Service
@PropertySource("classpath:messages.properties")
public class MessageConfigure {

	@Value("${ERRCODE_GLOBAL_001}")
	public String globalErr001;

	@Value("${ERRMSG_NOT_FOUND}")
	public String notFoundMsg;

	@Value("${ERRMSG_REQUIRED_MSG}")
	public String requiredMsg;

	@Value("${ERRMSG_EXIST}")
	public String existMsg;

	@Value("${GLOBAL_ERROR_MSG}")
	public String globalErrMsg;

	@Value("${ERRCODE_PAGE_SIZE_001}")
	public String pageSize001;

	@Value("${ERRMSG_PAGE_SIZE_001}")
	public String pageSizeMsg001;

	@Value("${ERRCODE_PAGE_NUMBER_001}")
	public String pageNumber001;

	@Value("${ERRMSG_PAGE_NUMBER_001}")
	public String pageNumberMsg001;

	@Value("${ERRCODE_USER_001}")
	public String user001;

	@Value("${ERRMSG_USER_001}")
	public String user001Msg;

	@Value("${ERRCODE_ROLE_001}")
	public String role001;

	@Value("${ERRMSG_ROLE_001}")
	public String roleMSG001;

	@Value("${ERRCODE_VALIDATION_001}")
	public String validationErr001;

	@Value("${ERRCODE_INVALID_REQUEST_001}")
	public String request001;

	@Value("${ERRMSG_INVALID_REQUEST_001}")
	public String requestMsg001;

	@Value("${ERRCODE_TOKEN_001}")
	public String token001;

	@Value("${ERRMSG_TOKEN_001}")
	public String tokenMsg001;

}
