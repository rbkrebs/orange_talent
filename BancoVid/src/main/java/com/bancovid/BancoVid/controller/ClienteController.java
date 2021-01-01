package com.bancovid.BancoVid.controller;



import com.bancovid.BancoVid.dto.ClienteCivilDTO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("cliente")
public class ClienteController {


    @GetMapping("/")
    public String clienteForm(ClienteCivilDTO cliente){
        return "index";
    }

    @PostMapping("/save")
    public String clienteSave(ClienteCivilDTO cliente){

        return "redirect:clientesList";
    }

    @ModelAttribute("clienteCivil")
    public ClienteCivilDTO clienteCivil(){

        ClienteCivilDTO clienteCivil = new ClienteCivilDTO();
        return clienteCivil;
    }


}
