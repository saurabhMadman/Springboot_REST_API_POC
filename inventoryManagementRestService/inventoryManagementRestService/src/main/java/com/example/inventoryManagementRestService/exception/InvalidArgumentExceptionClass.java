package com.example.inventoryManagementRestService.exception;

import com.sun.javaws.exceptions.InvalidArgumentException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class InvalidArgumentExceptionClass extends InvalidArgumentException {

    private static final long serialVersionUID = 1L;

    public InvalidArgumentExceptionClass(String[] message){
        super(message);
    }
}
