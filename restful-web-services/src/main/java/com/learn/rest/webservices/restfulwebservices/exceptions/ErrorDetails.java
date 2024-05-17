package com.learn.rest.webservices.restfulwebservices.exceptions;

import java.time.LocalDateTime;

public class ErrorDetails {
    private final LocalDateTime timestamp;
    private final String message;
    private final String details;

    public ErrorDetails(final LocalDateTime localDateTime, final String message, final String details) {
        this.timestamp = localDateTime;
        this.message = message;
        this.details = details;
    }


    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public String getMessage() {
        return message;
    }

    public String getDetails() {
        return details;
    }

    @Override
    public String toString() {
        return "ErrorDetails{" +
                "timeStamp=" + timestamp +
                ", message='" + message + '\'' +
                ", details='" + details + '\'' +
                '}';
    }
}
