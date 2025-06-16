package com.example.qr.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST)
public class QRTypeException extends RuntimeException {
    public QRTypeException(String message) {
        super(message);
    }
}
