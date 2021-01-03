package com.bancovid.BancoVid.controller;



import com.bancovid.BancoVid.domain.ClienteCivil;
import com.bancovid.BancoVid.dto.ClienteCivilDTO;
import com.bancovid.BancoVid.mappers.ClienteCivilConverter;
import com.bancovid.BancoVid.repository.ClienteCivilRepository;
import com.bancovid.BancoVid.service.ClienteCivilService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.List;

@Controller
@RequestMapping("cliente")
public class ClienteController {

    @Autowired
    private ClienteCivilService clienteCivilService;

    @Autowired
    private ClienteCivilConverter clienteCivilConverter;



    @PostMapping("/save")
    public ClienteCivilDTO clienteSave(ClienteCivilDTO cliente) throws SQLException {

        ClienteCivil clienteCivil = clienteCivilConverter.DTOToModel(cliente);

        ClienteCivilDTO clienteCivilDTO = clienteCivilConverter.modelToDTO(clienteCivilService.salvar(clienteCivil));

        return clienteCivilDTO;
    }




}
