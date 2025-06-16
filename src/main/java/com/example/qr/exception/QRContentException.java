package com.example.qr.exception;

public class QRContentException extends RuntimeException {
    public QRContentException(Throwable e) {
        super(e);
    }

    public QRContentException(String message) {
        super(message);
    }
}
