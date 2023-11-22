package com.mentoriaprogramacao.userMS.domain.exceptions;

import com.mentoriaprogramacao.userMS.domain.service.exceptions.UserAlreadyExistsException;
import com.mentoriaprogramacao.userMS.domain.service.exceptions.UserNotFoundException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;

import java.time.Instant;

@ControllerAdvice
public class ExceptionHandler extends RuntimeException{

    @org.springframework.web.bind.annotation.ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<CustomError> managerInfoNotFound(UserNotFoundException e, HttpServletRequest request) {
        String title = "User Not Found";
        String code = EnumExceptions.USER_NOT_FOUND_EXCEPTION.getCode();
        HttpStatus status = HttpStatus.NOT_FOUND;
        CustomError err = new CustomError(Instant.now(), code, title, e.getMessage(), request.getRequestURI());
        return ResponseEntity.status(status).body(err);
    }

    @org.springframework.web.bind.annotation.ExceptionHandler(UserAlreadyExistsException.class)
    public ResponseEntity<CustomError> managerAlreadyExists(UserAlreadyExistsException e, HttpServletRequest request) {
        String title = "User Already Exists";
        String code = EnumExceptions.USER_ALREADY_EXISTS_EXCEPTION.getCode();
        HttpStatus status = HttpStatus.BAD_REQUEST;
        CustomError err = new CustomError(Instant.now(), code, title, e.getMessage(), request.getRequestURI());
        return ResponseEntity.status(status).body(err);
    }
}
