package com.example.qr.exception;

import jakarta.validation.ConstraintViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class QRExceptionHandler {

    @ExceptionHandler(QRContentException.class)
    public ResponseEntity<CustomExceptionMessage> handleQRContentIsEmptyException(
            QRContentException e,
            WebRequest wr
    ) {
        CustomExceptionMessage body = CustomExceptionMessage.of(HttpStatus.BAD_REQUEST, e.getMessage(), wr);
        return new ResponseEntity<>(body, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<CustomExceptionMessage> handleConstraintViolationException(
            ConstraintViolationException e,
            WebRequest wr
    ) {
        CustomExceptionMessage body = CustomExceptionMessage.of(HttpStatus.BAD_REQUEST, e.getMessage(), wr);
        return new ResponseEntity<>(body, HttpStatus.BAD_REQUEST);
    }
}
