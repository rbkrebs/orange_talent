package com.bancovid.BancoVid.service;

import com.bancovid.BancoVid.domain.ClienteCivil;
import com.bancovid.BancoVid.repository.ClienteCivilRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

public class ClienteCivilService implements EntityService<ClienteCivil>{

    @Autowired
    private ClienteCivilRepository cvrepository;

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
