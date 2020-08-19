package com.example.demo.exceptionhandling;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityNotFoundException;
import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
public class ExceptionHandlerControllerAdvice {

    @ExceptionHandler(ResourceNotFoundException.class)
    @ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "Resource not found")
    public @ResponseBody ExceptionResponse handleResourceNotFound(final ResourceNotFoundException exception,
                                             final HttpServletRequest request) {

        ExceptionResponse error = new ExceptionResponse();
        error.setErrorMessage(exception.getMessage() + "controller advice");
        error.setRequestURI(request.getRequestURI());

        return error;
    }

    @ExceptionHandler(BadRequestException.class)
    public @ResponseBody ExceptionResponse handleBadRequest(final BadRequestException exception,
                                                           final HttpServletRequest request) {
        ExceptionResponse error = new ExceptionResponse();
        error.setErrorMessage(exception.getMessage());
        error.setRequestURI(request.getRequestURI());
        return error;
    }
    @ExceptionHandler(EntityNotFoundException.class)
    public @ResponseBody ExceptionResponse handleEntityNotFoundException(final EntityNotFoundException exception,
                                                                         final  HttpServletRequest request) {
        ExceptionResponse error = new ExceptionResponse();
        error.setErrorMessage(exception.getMessage());
        error.setRequestURI(request.getRequestURI());
        return error;
    }

}
