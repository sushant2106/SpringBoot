package com.servcie.ServiceLayer.advice;

import com.servcie.ServiceLayer.exception.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class ApplicationExceptionHandler {

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String,String> handelInvalidArgument(MethodArgumentNotValidException ex){
        Map<String,String> errorMap=new HashMap<>();

        ex.getBindingResult().getFieldErrors().forEach(error->{
               errorMap.put(error.getField(),error.getDefaultMessage());
        });
        return  errorMap;

    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(ResourceNotFoundException.class)
    public Map<String,String>handelBusinessException(ResourceNotFoundException ex){
        Map<String,String>errorMap=new HashMap<>();
        errorMap.put("errorMessage",ex.getMessage());
        return errorMap;
    }

}
