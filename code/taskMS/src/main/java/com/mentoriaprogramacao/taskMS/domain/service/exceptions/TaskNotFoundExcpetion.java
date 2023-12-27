package com.mentoriaprogramacao.taskMS.domain.service.exceptions;

import com.mentoriaprogramacao.taskMS.domain.exceptions.EnumExceptions;

public class TaskNotFoundExcpetion extends RuntimeException{
    private static final long serialVersionUID = 1L;

    public TaskNotFoundExcpetion() {
        super(EnumExceptions.Task_NOT_FOUND_EXCEPTION.getMessage());
    }
}

