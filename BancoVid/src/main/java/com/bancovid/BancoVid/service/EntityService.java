package com.bancovid.BancoVid.service;

import com.bancovid.BancoVid.domain.ClienteCivil;

import java.util.Optional;

public interface EntityService<T> {

    ClienteCivil salvar(T t);
    boolean ehcpfRepetido(String cpf);
    boolean ehemailRepetido(String email);

}
