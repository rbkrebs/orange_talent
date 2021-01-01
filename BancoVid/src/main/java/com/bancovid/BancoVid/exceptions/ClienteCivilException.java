package com.bancovid.BancoVid.exceptions;

public abstract class ClienteCivilException {

    public static final String FORMATED_DATA = "O formato do está errado. Deve ser 'yyyy-MM-dd HH:mm'";
    public static final String REPEATED_REGISTRATION = "CPF ou E-mail já possui registro no banco de dados";
}
