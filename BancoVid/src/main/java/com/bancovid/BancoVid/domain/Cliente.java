package com.bancovid.BancoVid.domain;

import javax.persistence.MappedSuperclass;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


@MappedSuperclass
public abstract class Cliente extends AbstractEntity<Long> {

    @NotNull(message = "Nome é um campo obrigatório")
    @Size(min = 3)
    private String nome;

    @NotNull(message = "E-mail é um campo obrigatório")
    @Email(message = "O valor não condiz com um e-mail válido")
    private String email;

}
