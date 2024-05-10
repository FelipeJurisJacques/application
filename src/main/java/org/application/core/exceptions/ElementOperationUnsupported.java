package org.application.core.exceptions;

public class ElementOperationUnsupported extends Throwable {

    @Override
    public String getMessage() {
        String message = super.getMessage();
        if (message.isEmpty()) {
            message = "Operation unsupported";
        }
        return message;
    }
}
