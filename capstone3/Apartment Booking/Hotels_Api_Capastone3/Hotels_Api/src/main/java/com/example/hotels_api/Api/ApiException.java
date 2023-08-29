package com.example.hotels_api.Api;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class ApiException extends RuntimeException{
    public ApiException(String message){
        super(message);
    }

}
