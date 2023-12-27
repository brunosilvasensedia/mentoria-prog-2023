package com.mentoriaprogramacao.taskMS.domain.service.exceptions;

import com.mentoriaprogramacao.taskMS.domain.exceptions.EnumExceptions;

public class UserNotFoundException extends RuntimeException{
    private static final long serialVersionUID = 1L;

    public UserNotFoundException(){
        super(EnumExceptions.USER_NOT_FOUND_EXCEPTION.getMessage());
    }
}
