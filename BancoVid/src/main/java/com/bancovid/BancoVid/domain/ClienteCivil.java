package com.bancovid.BancoVid.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.Size;
import java.time.LocalDate;



@Entity
@Data
@Table(name = "cliente_civil",
        uniqueConstraints =
        @UniqueConstraint(columnNames = "email", name = "email_uk"))
@AllArgsConstructor
@NoArgsConstructor
public class ClienteCivil extends Cliente{


    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate dataNascimento;

    @Size(max = 11, min = 11, message = "O valor não condiz com um cpf válido")
    @Column(name = "cpf", unique = true)
    private String cpf;
}
