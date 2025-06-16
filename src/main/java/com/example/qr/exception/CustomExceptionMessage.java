package com.example.qr.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDateTime;

public class CustomExceptionMessage {
    private int statusCode;
    private LocalDateTime timestamp;
    private String message;
    private String description;

    public CustomExceptionMessage(int statusCode, LocalDateTime timestamp,
                                  String message, String description) {
        this.statusCode = statusCode;
        this.timestamp = timestamp;
        this.message = message;
        this.description = description;
    }

    public static CustomExceptionMessage of(HttpStatus status, String message, WebRequest wr) {
        return new CustomExceptionMessage(
                status.value(),
                LocalDateTime.now(),
                message,
                wr.getDescription(false)
        );
    }

    public int getStatusCode() {
        return statusCode;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public String getMessage() {
        return message;
    }

    public String getDescription() {
        return description;
    }
}
