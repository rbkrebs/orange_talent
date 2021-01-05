package com.bancovid.BancoVid.dto;

import com.bancovid.BancoVid.exceptions.ClienteCivilException;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.IllegalFormatException;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClienteCivilDTO {

    private static final DateTimeFormatter formatter =
            DateTimeFormatter.ofPattern("dd-MM-yyyy");

    @NotBlank(message = "Nome é um campo obrigatório")
    private String nome;

    @NotBlank(message = "Nome é um campo obrigatório")
    @Email(message = "O valor não condiz com um e-mail válido")
    private String email;

    @NotBlank(message = "Nome é um campo obrigatório")
    @Size(max = 11, min = 11, message = "O valor não condiz com um cpf válido")
    private String cpf;
    /*
    @NotNull
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate dataNascimento;*/

    @NotBlank(message = "Nome é um campo obrigatório")
    private String dataNascimento;

    @JsonIgnore
    public LocalDate getDataNacimentoConverted() throws IllegalFormatException {

        try{
            return LocalDate.parse(this.dataNascimento,formatter);
        }catch (Exception e){
            throw new IllegalArgumentException(ClienteCivilException.FORMATED_DATE);
        }
    }

}
