package com.mentoriaprogramacao.taskMS.domain.service.exceptions;

import com.mentoriaprogramacao.taskMS.domain.exceptions.EnumExceptions;

public class ListNotFoundException extends RuntimeException{
    private static final long serialVersionUID = 1L;

    public ListNotFoundException() {
        super(EnumExceptions.List_NOT_FOUND_EXCEPTION.getMessage());
    }
}
