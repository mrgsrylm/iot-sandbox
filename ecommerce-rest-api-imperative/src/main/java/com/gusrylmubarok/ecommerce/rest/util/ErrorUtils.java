package com.gusrylmubarok.ecommerce.rest.util;

import com.gusrylmubarok.ecommerce.rest.exceptions.Error;

public class ErrorUtils {
    public ErrorUtils() {
    }
    public static Error createError(final String errMsgKey, final String errorCode,
                                    final Integer httpStatusCode) {
        Error error = new Error();
        error.setMessage(errMsgKey);
        error.setErrorCode(errorCode);
        error.setStatus(httpStatusCode);
        return error;
    }
}
