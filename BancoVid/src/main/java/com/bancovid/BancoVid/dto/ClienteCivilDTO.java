package com.bancovid.BancoVid.dto;

import com.bancovid.BancoVid.exceptions.ClienteCivilException;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClienteCivilDTO {

    /*private static final DateTimeFormatter formatter =
            DateTimeFormatter.ofPattern("dd-MM-yyyy");*/

    private String nome;

    @NotNull
    @Email
    private String email;

    @NotNull
    private String cpf;

    @NotNull
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate dataNascimento;
/*
    @JsonIgnore
    public LocalDateTime getDataNacimentoConverted() throws IllegalFormatException{

        try{
            return LocalDateTime.parse(this.dataNascimento,formatter);
        }catch (Exception e){
            throw new IllegalArgumentException(ClienteCivilException.FORMATED_DATA);
        }
    }*/

}
