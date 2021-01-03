package com.bancovid.BancoVid.service;

import com.bancovid.BancoVid.domain.ClienteCivil;
import com.bancovid.BancoVid.exceptions.ClienteCivilException;
import com.bancovid.BancoVid.mappers.ClienteCivilConverter;
import com.bancovid.BancoVid.repository.ClienteCivilRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.Optional;


@Service
public class ClienteCivilService implements EntityService<ClienteCivil>{

    @Autowired
    private ClienteCivilRepository cvrepository;

    @Autowired
    private ClienteCivilConverter clienteCivilConverter;

    @Override
    public ClienteCivil salvar(ClienteCivil clienteCivil) throws SQLException {
        try{

            return cvrepository.save(clienteCivil);
        }catch (Exception e){
            throw new SQLException(ClienteCivilException.REPEATED_REGISTRATION);
        }


    }

    @Override
    public Optional<ClienteCivil> validar(ClienteCivil clienteCivil) {
        return Optional.empty();
    }
}
