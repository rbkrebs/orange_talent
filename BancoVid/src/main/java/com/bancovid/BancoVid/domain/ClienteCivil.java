package com.bancovid.BancoVid.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.Size;
import java.time.LocalDate;


@Entity
@Data
@Table(name = "cliente_civil",
        uniqueConstraints =
        @UniqueConstraint(columnNames = "email", name = "cpf_uk"))
@AllArgsConstructor
@NoArgsConstructor
public class ClienteCivil extends Cliente{


    private LocalDate dataNascimento;

    @Size(max = 11, min = 11, message = "O valor não condiz com um cpf válido")
    private Long cpf;
}
