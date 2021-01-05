package com.bancovid.BancoVid.exceptions;

public abstract class ClienteCivilException {

    public static final String FORMATED_DATE = "O formato da data de nascimento está errado. Deve ser 'dd-MM-yyyy'";
    public static final String REPEATED_REGISTRATION = "CPF ou E-mail já possui registro no banco de dados";
    public static final String FORMATED_CPF = "O formato do CPF está errado. Deve ser uma string de 11 números";
}
