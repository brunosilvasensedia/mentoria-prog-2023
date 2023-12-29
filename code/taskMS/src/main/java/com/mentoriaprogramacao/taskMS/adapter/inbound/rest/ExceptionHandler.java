package com.mentoriaprogramacao.taskMS.adapter.inbound.rest;

import com.mentoriaprogramacao.taskMS.domain.exceptions.CustomError;
import com.mentoriaprogramacao.taskMS.domain.exceptions.EnumExceptions;
import com.mentoriaprogramacao.taskMS.domain.service.exceptions.ListNotFoundException;
import com.mentoriaprogramacao.taskMS.domain.service.exceptions.TaskNotFoundExcpetion;
import com.mentoriaprogramacao.taskMS.domain.service.exceptions.UserNotFoundException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;

import java.time.Instant;

@ControllerAdvice
public class ExceptionHandler extends RuntimeException{

    public ResponseEntity<CustomError> managerUserNotFound(UserNotFoundException e, HttpServletRequest request){
        String title = "User Not Found";
        String code = EnumExceptions.USER_NOT_FOUND_EXCEPTION.getCode();
        HttpStatus status = HttpStatus.NOT_FOUND;
        CustomError err = new CustomError(Instant.now(), code, title, e.getMessage(), request.getRequestURI());
        return ResponseEntity.status(status).body(err);
    }

    public ResponseEntity<CustomError> managerListNotFound(ListNotFoundException e, HttpServletRequest request){
        String title = "List Not Found";
        String code = EnumExceptions.List_NOT_FOUND_EXCEPTION.getCode();
        HttpStatus status = HttpStatus.NOT_FOUND;
        CustomError err = new CustomError(Instant.now(), code, title, e.getMessage(), request.getRequestURI());
        return ResponseEntity.status(status).body(err);
    }

    public ResponseEntity<CustomError> managerTaskNotFound(TaskNotFoundExcpetion e, HttpServletRequest request){
        String title = "Task Not Found";
        String code = EnumExceptions.Task_NOT_FOUND_EXCEPTION.getCode();
        HttpStatus status = HttpStatus.NOT_FOUND;
        CustomError err = new CustomError(Instant.now(), code, title, e.getMessage(), request.getRequestURI());
        return ResponseEntity.status(status).body(err);
    }
}
