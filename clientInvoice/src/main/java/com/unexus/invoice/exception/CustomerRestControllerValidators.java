/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unexus.invoice.exception;

import java.util.HashMap;
import java.util.Map;
import javax.validation.ConstraintViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.util.pattern.PatternParseException;

/**
 *
 * @author geova
 */

@RestControllerAdvice
public class CustomerRestControllerValidators {
    
    @ResponseStatus(code = HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, String> handleValidateExceptions(MethodArgumentNotValidException ex){
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach((error)->{
            String fieldName = ((FieldError) error).getField();
            String message = error.getDefaultMessage();
            errors.put("status", "400");
            errors.put(fieldName, message);
            
        });
        return errors;
    }
    
    @ExceptionHandler(Exception.class)
    public ResponseEntity<StandarizedApiExceptionResponse> handleException(Exception ex) {
       StandarizedApiExceptionResponse response = 
          new StandarizedApiExceptionResponse("Error de validacion",HttpStatus.PARTIAL_CONTENT.name(),ex.getMessage());
       return new ResponseEntity(response, HttpStatus.PARTIAL_CONTENT);
   }
    
    @ExceptionHandler(BussinesTransactionResponse.class)
    public ResponseEntity<StandarizedApiExceptionResponse> handleBussinesTransactionException(BussinesTransactionResponse ex) {
        StandarizedApiExceptionResponse response = 
           new StandarizedApiExceptionResponse("Error de validacion",ex.getCode(),ex.getMessage());
        return new ResponseEntity(response, HttpStatus.PARTIAL_CONTENT);
    }
    
    
    
}
