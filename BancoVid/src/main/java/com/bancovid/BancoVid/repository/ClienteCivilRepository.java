package com.bancovid.BancoVid.repository;

import com.bancovid.BancoVid.domain.ClienteCivil;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface ClienteCivilRepository extends JpaRepository<ClienteCivil, Long> {

    ClienteCivil findClienteCivilByCpf(long cpf);

    ClienteCivil findClienteCivilByEmail(String email);

    ClienteCivil save(ClienteCivil clienteCivil);
}
