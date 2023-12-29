package com.mentoriaprogramacao.taskMS.domain.exceptions;

public enum EnumExceptions {
    USER_NOT_FOUND_EXCEPTION("TMS-REQ-001","Não foi encontrado nenhum Usuário com esse ID"),
    List_NOT_FOUND_EXCEPTION("TMS-REQ-002","Não foi encontrado nenhuma Lista com esse ID"),
    Task_NOT_FOUND_EXCEPTION("TMS-REQ-003","Não foi encontrado nenhuma Tarefa com esse ID");
    private String code, message;

    private EnumExceptions(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
