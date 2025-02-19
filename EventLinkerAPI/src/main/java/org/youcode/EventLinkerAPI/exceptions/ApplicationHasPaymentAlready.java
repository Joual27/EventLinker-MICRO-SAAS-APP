package org.youcode.EventLinkerAPI.exceptions;

public class ApplicationHasPaymentAlready extends RuntimeException {
    public ApplicationHasPaymentAlready(String message) {
        super(message);
    }
}
