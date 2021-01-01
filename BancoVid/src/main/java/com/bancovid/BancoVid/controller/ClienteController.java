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

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.List;

@Controller
@RequestMapping("cliente")
public class ClienteController {

    @Autowired
    private ClienteCivilService clienteCivilService;

    @Autowired
    private ClienteCivilRepository clienteCivilRepository;

    @Autowired
    private ClienteCivilConverter clienteCivilConverter;

    @InitBinder
    private void dateBinder(WebDataBinder binder) {
        //The date format to parse or output your dates
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        //Create a new CustomDateEditor
        CustomDateEditor editor = new CustomDateEditor(dateFormat, true);
        //Register it as custom editor for the Date type
        binder.registerCustomEditor(LocalDateTime.class, editor);
    }

    @GetMapping("/")
    public String clienteForm(ClienteCivilDTO cliente){
        return "index";
    }

    @PostMapping("/save")
    public String clienteSave(ClienteCivilDTO cliente){

        ClienteCivil clienteCivil = clienteCivilConverter.DTOToModel(cliente);
        //clienteCivilService.salvar(clienteCivil);
        System.out.println(clienteCivilService.salvar(clienteCivil));

        return "redirect:clientesList";
    }

    @GetMapping(value = "/clientesList")
    public ModelAndView listaClientes(){
        ModelAndView modelAndView = new ModelAndView("cliente/clientesList");
        //List<Disciplina> disciplinas = disciplinaService.findAll();
        //modelAndView.addObject("disciplinas", disciplinas);
        return modelAndView;
    }

    @ModelAttribute("clienteCivil")
    public ClienteCivilDTO clienteCivil(){

        ClienteCivilDTO clienteCivil = new ClienteCivilDTO();
        return clienteCivil;
    }




}
