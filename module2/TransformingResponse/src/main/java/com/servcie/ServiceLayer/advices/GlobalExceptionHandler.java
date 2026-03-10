package com.servcie.ServiceLayer.advices;


import com.servcie.ServiceLayer.exception.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@RestControllerAdvice
public class GlobalExceptionHandler {

//    @ExceptionHandler(NoSuchElementException.class)
//    public ResponseEntity<APIError> handelResourceNotFound(NoSuchElementException exception){
//
//        APIError apiError=APIError
//                .builder()
//                .status(HttpStatus.NOT_FOUND).
//                message("Resource not found").build();
//
//       return  new ResponseEntity<>(apiError,HttpStatus.NOT_FOUND);
//    }


    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<APIResponse<?>> handelResourceNotFound( ResourceNotFoundException exception){

        APIError apiError=APIError
                .builder()
                .status(HttpStatus.NOT_FOUND).
                message(exception.getMessage())
                .build();

        return buildErrorResponseEntity(apiError);

       // return  new ResponseEntity<>(apiError,HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(Exception.class)
    public  ResponseEntity<APIResponse<?>> handelInternalServerError(Exception exception){

        APIError apiError=APIError.builder()
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .message(exception.getMessage())
                .build();
       // return new ResponseEntity<>(apiError, HttpStatus.INTERNAL_SERVER_ERROR);

       return buildErrorResponseEntity(apiError);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<APIResponse<?>>handelInputValidationError(MethodArgumentNotValidException exception){
       List<String> errors= exception.getBindingResult().getAllErrors().stream()
                .map(error -> error.getDefaultMessage())
                .collect(Collectors.toList());

//       APIError apiError=APIError.builder()
//               .status(HttpStatus.BAD_REQUEST)
//               .message(errors.toString()).build();

        APIError apiError=APIError.builder()
                .status(HttpStatus.BAD_REQUEST)
                .message("Input Validation Failed").subErrors(errors).build();

       //return  new ResponseEntity<>(apiError,HttpStatus.BAD_REQUEST);

        return buildErrorResponseEntity(apiError);
    }


    private ResponseEntity<APIResponse<?>>buildErrorResponseEntity(APIError apiError){
        return  new ResponseEntity<>(new APIResponse<>(apiError),apiError.getStatus());
    }




}
