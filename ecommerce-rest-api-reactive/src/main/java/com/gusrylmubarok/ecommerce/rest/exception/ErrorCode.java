package com.gusrylmubarok.ecommerce.rest.exception;

public enum ErrorCode {
  // Internal Errors: 1 to 0999
  GENERIC_ERROR("SERVER-0001", "The system is unable to complete the request. Contact system support."),
  HTTP_MEDIATYPE_NOT_SUPPORTED("SERVER-0002", "Requested media type is not supported. Please use application/json or application/xml as 'Content-Type' header value"),
  HTTP_MESSAGE_NOT_WRITABLE("SERVER-0003", "Missing 'Accept' header. Please add 'Accept' header."),
  HTTP_MEDIA_TYPE_NOT_ACCEPTABLE("SERVER-0004", "Requested 'Accept' header value is not supported. Please use application/json or application/xml as 'Accept' value"),
  JSON_PARSE_ERROR("SERVER-0005", "Make sure request payload should be a valid JSON object."),
  HTTP_MESSAGE_NOT_READABLE("SERVER-0006", "Make sure request payload should be a valid JSON or XML object according to 'Content-Type'."),
  HTTP_REQUEST_METHOD_NOT_SUPPORTED("SERVER-0007", "Request method not supported."),
  CONSTRAINT_VIOLATION("SERVER-0008", "Validation failed."),
  ILLEGAL_ARGUMENT_EXCEPTION("SERVER-0009", "Invalid data passed."),
  RESOURCE_NOT_FOUND("SERVER-0010", "Requested resource not found."),
  CUSTOMER_NOT_FOUND("SERVER-0011", "Requested customer not found."),
  ITEM_NOT_FOUND("SERVER-0012", "Requested item not found."),
  GENERIC_ALREADY_EXISTS("SERVER-0013", "Already exists."),
  CARD_ALREADY_EXISTS("SERVER-0013", "Card already exists.");

  private String errCode;
  private String errMsgKey;

  private ErrorCode(final String errCode, final String errMsgKey) {
    this.errCode = errCode;
    this.errMsgKey = errMsgKey;
  }

  public String getErrCode() {
    return errCode;
  }

  public String getErrMsgKey() {
    return errMsgKey;
  }
}
