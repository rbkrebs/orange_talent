package com.bancovid.BancoVid.mappers;

import com.bancovid.BancoVid.domain.ClienteCivil;
import com.bancovid.BancoVid.dto.ClienteCivilDTO;
import org.springframework.stereotype.Component;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


@Component
public class ClienteCivilConverter implements ClienteCivilMapper{

    private static final Pattern p = Pattern.compile("([0-9]{3}[\\.]?[0-9]{3}[\\.]?[0-9]{3}[\\-]?[0-9]{2})|([0-9]{11})");
    private static  final String delimiters = "[\\-\\.]?";

    @Override
    public ClienteCivilDTO modelToDTO(ClienteCivil clienteCivil) {
        return null;
    }

    @Override
    public ClienteCivil DTOToModel(ClienteCivilDTO clienteCivilDTO) {

        ClienteCivil clienteCivil = new ClienteCivil();
        Matcher m = p.matcher(clienteCivilDTO.getCpf());

        if(m.find()){
            clienteCivil.setCpf(String.join("",clienteCivilDTO.getCpf().split(delimiters)));
        }

        clienteCivil.setEmail(clienteCivilDTO.getEmail());
        clienteCivil.setNome(clienteCivilDTO.getNome());
        clienteCivil.setDataNascimento(clienteCivilDTO.getDataNascimento());


        return clienteCivil;
    }
}
