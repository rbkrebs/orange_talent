package com.bancovid.BancoVid.service;

import com.bancovid.BancoVid.domain.ClienteCivil;
import com.bancovid.BancoVid.mappers.ClienteCivilConverter;
import com.bancovid.BancoVid.mappers.ClienteCivilMapper;
import com.bancovid.BancoVid.repository.ClienteCivilRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class ClienteCivilService implements EntityService<ClienteCivil>{

    @Autowired
    private ClienteCivilRepository cvrepository;

    @Autowired
    private ClienteCivilConverter clienteCivilConverter;

    @Override
    public Boolean salvar(ClienteCivil clienteCivil) {
        try{
            cvrepository.save(clienteCivil);
            return true;
        }catch (Exception e){
            return false;
        }


    }

    @Override
    public Optional<ClienteCivil> validar(ClienteCivil clienteCivil) {
        return Optional.empty();
    }
}
