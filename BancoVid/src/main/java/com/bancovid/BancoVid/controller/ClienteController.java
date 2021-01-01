package com.bancovid.BancoVid.controller;



import com.bancovid.BancoVid.dto.ClienteCivilDTO;
import com.bancovid.BancoVid.service.ClienteCivilService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("cliente")
public class ClienteController {

    @Autowired
    private ClienteCivilService clienteCivilService;


    @GetMapping("/")
    public String clienteForm(ClienteCivilDTO cliente){
        return "index";
    }

    @PostMapping("/save")
    public String clienteSave(ClienteCivilDTO cliente){

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
