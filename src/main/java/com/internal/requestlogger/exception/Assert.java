package com.internal.requestlogger.exception;

public class Assert {
    public static void isFalse( boolean exp, int code, String message ) {
        if(exp) {
            throw new ServiceException(code, message);
        }
    }

    public static void isFalse( boolean exp, String message ) {
        isFalse(exp, 500, message);
    }
}
