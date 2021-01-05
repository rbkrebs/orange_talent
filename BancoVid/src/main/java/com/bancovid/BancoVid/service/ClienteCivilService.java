package com.bancovid.BancoVid.service;

import com.bancovid.BancoVid.domain.ClienteCivil;
import com.bancovid.BancoVid.repository.ClienteCivilRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class ClienteCivilService implements EntityService<ClienteCivil>{

    @Autowired
    private ClienteCivilRepository cvrepository;

    @Override
    public ClienteCivil salvar(ClienteCivil clienteCivil) {

            return cvrepository.save(clienteCivil);

    }

    @Override
    public boolean ehcpfRepetido(String cpf) {

        return cvrepository.findClienteCivilByCpf(cpf).isPresent();
    }

    @Override
    public boolean ehemailRepetido(String email) {
        return cvrepository.findClienteCivilByEmail(email).isPresent();
    }


}
