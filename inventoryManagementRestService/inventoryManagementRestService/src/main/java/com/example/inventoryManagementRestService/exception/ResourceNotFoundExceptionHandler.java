package com.example.inventoryManagementRestService.exception;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value= HttpStatus.NOT_FOUND)
public class ResourceNotFoundExceptionHandler extends Exception {

    private static final long serialVersionUID = 1L;

    public ResourceNotFoundExceptionHandler(String message){
        super(message);
    }

}
