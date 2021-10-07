package com.example.inventoryManagementRestService.exception;


import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Date;

@ControllerAdvice
public class ExceptionHandling extends ResponseEntityExceptionHandler {

    @ExceptionHandler(ResourceNotFoundExceptionHandler.class)
    public ResponseEntity<?> resourceNotFoundException(ResourceNotFoundExceptionHandler ex, WebRequest request) {
        ErrorDetailClass errorDetails = new ErrorDetailClass(new Date(), ex.getMessage(), request.getDescription(false));
        return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<?> globleExcpetionHandler(Exception ex, WebRequest request) {
        ErrorDetailClass errorDetails = new ErrorDetailClass(new Date(), ex.getMessage(), request.getDescription(false));
        return new ResponseEntity<>(errorDetails, HttpStatus.INTERNAL_SERVER_ERROR);
    }


    @ExceptionHandler(InvalidArgumentExceptionClass.class)
    protected ResponseEntity<Object> handleMethodArgumentNotValid(InvalidArgumentExceptionClass ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        ErrorDetailClass errorDetails = new ErrorDetailClass(new Date(), "Validation Failed",
                ex.toString());
        return new ResponseEntity(errorDetails, HttpStatus.BAD_REQUEST);
    }


}
