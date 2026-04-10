package com.example.Department.advices;

import com.example.Department.exception.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestControllerAdvice
public class GlobalExceptionHandler {

//
//    @ResponseStatus(HttpStatus.BAD_REQUEST)
//    @ExceptionHandler(MethodArgumentNotValidException.class)
//    public Map<String,String> handelInvalidArgument(MethodArgumentNotValidException  ex){
//        Map<String,String> errorMap=new HashMap<>();
//        ex.getBindingResult().getFieldErrors().forEach(error -> {
//            errorMap.put(error.getField(), error.getDefaultMessage());
//        });
//
//        return errorMap;


    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<APIError> handelResourceNotFound(ResourceNotFoundException exception){
        APIError apierror=APIError
                .builder()
                .status(HttpStatus.NOT_FOUND)
                .message(exception.getMessage())
                .build();

        return new ResponseEntity<>(apierror, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<APIError>handelInternalServerError(Exception exception){
     APIError apiError=APIError.builder()
             .status(HttpStatus.INTERNAL_SERVER_ERROR)
             .message(exception.getMessage())
             .build();
     return  new ResponseEntity<>(apiError,HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public  ResponseEntity<APIError>handelInputValidationErro(MethodArgumentNotValidException exception){

        List<String> errors= exception.
                getBindingResult().getAllErrors().stream()
                .map(error -> error.getDefaultMessage())
                .collect(Collectors.toList());

        APIError apiError=APIError.builder()
                .status(HttpStatus.BAD_REQUEST)
                .message("Input Validation Failed")
                .suberrors(errors).build();

        return  new ResponseEntity<>(apiError,HttpStatus.BAD_REQUEST);


    }








}
