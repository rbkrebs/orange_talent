package com.bancovid.BancoVid.service;

import java.util.Optional;

public interface EntityService<T> {

    Boolean salvar(T t);
    Optional<T> validar(T t);
}
