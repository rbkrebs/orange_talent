package com.bancovid.BancoVid.controller;



import com.bancovid.BancoVid.domain.ClienteCivil;
import com.bancovid.BancoVid.dto.ClienteCivilDTO;
import com.bancovid.BancoVid.exceptions.ClienteCivilException;
import com.bancovid.BancoVid.mappers.ClienteCivilConverter;
import com.bancovid.BancoVid.service.ClienteCivilService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("cliente")
public class ClienteController {

    @Autowired
    private ClienteCivilService clienteCivilService;

    @Autowired
    private ClienteCivilConverter clienteCivilConverter;



    @PostMapping("/save")
    public ClienteCivilDTO clienteSave(ClienteCivilDTO cliente) {

        ClienteCivil clienteCivil = clienteCivilConverter.DTOToModel(cliente);

       if(!(clienteCivilService.ehcpfRepetido(clienteCivil.getCpf()) &&
               clienteCivilService.ehemailRepetido(clienteCivil.getEmail()))){

        ClienteCivilDTO clienteCivilDTO = clienteCivilConverter.modelToDTO(clienteCivilService.salvar(clienteCivil));
           return clienteCivilDTO;
       }

        throw new IllegalArgumentException(ClienteCivilException.REPEATED_REGISTRATION);
    }






}
