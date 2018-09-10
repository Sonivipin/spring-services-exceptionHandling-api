package com.exceptionhandler.api.common.util;

public final class Constant {

	private Constant() {
	}

	public static final String APPLICATION_NAME = "firstApp";

	public static final String JSON_ERROR_MSG = "Unable to write file. Reason errorDescription {} errorFullTrace {}";

	public static final String AWS_ERROR_MSG = "Unable to upload file, upload was aborted. Reason {} errorDescription {} errorFullTrace {}";

	public static final String SCRIPT_LOCATION = "/opt/config/BuildCSScript.sh";

	public static final String GLOBAL_ERROR_MSG = "Please contact your administrator";

	public static final String AWS_S3_FILE_UPLOAD_LOCATION = "/tmp/requestJson.json";

	public static final int ERROR_DESCRIPTION_LIMIT = 20000;

	public static final String SAVE_SUCCESSFULL = "SUCCESS";

	public static final String FAILED_SAVE = "FAILED";

	public static final String NOT_VALID = " are not valid.";

	public static final String ASC = "ASC";

	public static final String TOKEN_HEADER = "token";

	public static final String USER = "user";

	public static final String APPLICATION = "application";

	public static final String ENTER_METHOD = "Enter into method ";

	public static final String EXIT_METHOD = "Exit into method ";

	public static final String ELAPSED_TIME = "Time elapsed for ";

	public static final String MILLISECONDS = " milliseconds";

	public static final String TRUE = "true";

	public static final int MIN_NAME_SIZE = 3;

	public static final int MAX_NAME_SIZE = 25;

	public static final String SAVED = "Saved";

	public static final String OPENING_BRACKET = " (";

	public static final String CLOSING_BRACKET = ")";

	public static final String DATE_PATTERN = "yyyy-MM-dd HH:mm:ss";

}
