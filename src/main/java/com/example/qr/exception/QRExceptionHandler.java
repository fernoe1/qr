package com.example.qr.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class QRExceptionHandler {
    @ExceptionHandler(QRSizeException.class)
    public ResponseEntity<CustomExceptionMessage> handleQRSizeException(QRSizeException e,
                                                                        WebRequest wr)
    {
        CustomExceptionMessage body = CustomExceptionMessage.of(HttpStatus.BAD_REQUEST, e.getMessage(), wr);
        return new ResponseEntity<>(body, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(QRTypeException.class)
    public ResponseEntity<CustomExceptionMessage> handleQRTypeException(QRTypeException e,
                                                                        WebRequest wr)
    {
        CustomExceptionMessage body = CustomExceptionMessage.of(HttpStatus.BAD_REQUEST, e.getMessage(), wr);
        return new ResponseEntity<>(body, HttpStatus.BAD_REQUEST);
    }
}
