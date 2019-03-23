package com.obs.patient.exception.handler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;

import com.obs.patient.exception.BadRequestException;
import com.obs.patient.exception.NotFoundException;

/**
 * Handler exception to customize the error response 
 * @author Felipe
 *
 */
@ControllerAdvice
@RestController
public class CustomizedResponseEntityExceptionHandler
{

    @ExceptionHandler (BadRequestException.class)
    public final ResponseEntity<ErrorDetails> handleBadRequestExceptions(BadRequestException ex, WebRequest request)
    {
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler (NotFoundException.class)
    public final ResponseEntity<ErrorDetails> handleNotFoundExceptions(NotFoundException ex, WebRequest request)
    {
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

}
