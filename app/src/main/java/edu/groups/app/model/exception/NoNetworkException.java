package edu.groups.app.model.exception;

/**
 * Created by Dawid Świnoga on 25.11.2017.
 */

public class NoNetworkException extends RuntimeException {
    public NoNetworkException() {
        super();
    }

    public NoNetworkException(String message) {
        super(message);
    }

    public NoNetworkException(String message, Throwable cause) {
        super(message, cause);
    }

    public NoNetworkException(Throwable cause) {
        super(cause);
    }

    protected NoNetworkException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
