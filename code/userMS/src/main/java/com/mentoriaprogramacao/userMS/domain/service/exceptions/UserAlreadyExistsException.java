package com.mentoriaprogramacao.userMS.domain.service.exceptions;

import com.mentoriaprogramacao.userMS.domain.exceptions.EnumExceptions;

public class UserAlreadyExistsException extends RuntimeException{
    private static final long serialVersionUID = 1L;

    public UserAlreadyExistsException() {
        super(EnumExceptions.USER_ALREADY_EXISTS_EXCEPTION.getMessage());
    }
}
