package com.lftechnology.raas.sdk.exception;

/**
 * @author Kiran Pariyar <kiranpariyar@lftechnology.com>
 */
public class ApiException extends RuntimeException {
    public ApiException() {
        super("Exception while call RAAS API.");
    }

    public ApiException(String message) {
        super(message);
    }
}