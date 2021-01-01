package com.bancovid.BancoVid.mappers;

import com.bancovid.BancoVid.domain.ClienteCivil;
import com.bancovid.BancoVid.dto.ClienteCivilDTO;
import org.springframework.stereotype.Component;


@Component
public class ClienteCivilConverter implements ClienteCivilMapper{

    @Override
    public ClienteCivilDTO modelToDTO(ClienteCivil clienteCivil) {
        return null;
    }

    @Override
    public ClienteCivil DTOToModel(ClienteCivilDTO clienteCivilDTO) {
        return null;
    }
}
