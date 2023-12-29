package com.mentoriaprogramacao.userMS.domain.exceptions;

public enum EnumExceptions {
    USER_NOT_FOUND_EXCEPTION("UMS-REQ-001","Não foi encontrado nenhum Usuário com esse ID"),
    USER_ALREADY_EXISTS_EXCEPTION("UMS-REQ-002","Não foi possivel cadastrar as informações! Já existe um Usuário cadastrado com esse email");

    private String code;
    private String message;

    private EnumExceptions(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public String getCode() {
        return code;
    }
}
