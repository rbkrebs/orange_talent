package com.bancovid.BancoVid.domain;

import lombok.Data;

import javax.persistence.MappedSuperclass;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;


@MappedSuperclass
@Data
public abstract class Cliente extends AbstractEntity<Long> {

    @NotBlank(message = "Nome é um campo obrigatório")
    @Size(min = 3)
    private String nome;


    @Email(message = "O valor não condiz com um e-mail válido")
    private String email;

}
