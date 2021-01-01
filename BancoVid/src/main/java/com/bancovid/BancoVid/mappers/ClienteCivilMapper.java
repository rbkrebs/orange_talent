package com.bancovid.BancoVid.mappers;


import com.bancovid.BancoVid.domain.ClienteCivil;
import com.bancovid.BancoVid.dto.ClienteCivilDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ClienteCivilMapper {

    ClienteCivilMapper INSTANCE = Mappers.getMapper( ClienteCivilMapper.class );

    @Mappings({
            @Mapping(source = "nome", target = "nome"),
            @Mapping(source = "cpf", target = "cpf", dateFormat = "yyyy-MM-dd HH:mm"),
            @Mapping(source = "email", target = "email", dateFormat = "yyyy-MM-dd HH:mm"),
            @Mapping(source = "dataNascimento", target = "dataNascimento", dateFormat = "yyyy-MM-dd HH:mm")
    })

    ClienteCivilDTO modelToDTO(ClienteCivil clienteCivil);

    ClienteCivil DTOToModel(ClienteCivilDTO clienteCivilDTO);


}
