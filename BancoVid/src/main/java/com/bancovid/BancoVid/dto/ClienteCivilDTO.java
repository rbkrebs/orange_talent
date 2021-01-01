package com.bancovid.BancoVid.dto;

import com.bancovid.BancoVid.exceptions.ClienteCivilException;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.IllegalFormatException;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClienteCivilDTO {

    private static final DateTimeFormatter formatter =
            DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");

    private String nome;

    @NotNull
    @Email
    private String email;

    @NotNull
    private String cpf;

    @NotNull
    private String dataNascimento;

    @JsonIgnore
    public LocalDateTime getDataNacimentoConverted() throws IllegalFormatException{

        try{
            return LocalDateTime.parse(this.dataNascimento,formatter);
        }catch (Exception e){
            throw new IllegalArgumentException(ClienteCivilException.FORMATED_DATA);
        }
    }

}
