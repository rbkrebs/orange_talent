package com.bancovid.BancoVid.controller;



import com.bancovid.BancoVid.domain.ClienteCivil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("cliente")
public class ClienteController {


    @GetMapping("/")
    public String clienteForm(ClienteCivil cliente){
        return "index";
    }

    @PostMapping("/save")
    public String clienteSave(ClienteCivil cliente){

        return "redirect:clientesList";
    }

    @ModelAttribute("clienteCivil")
    public ClienteCivil clienteCivil(){

        ClienteCivil clienteCivil = new ClienteCivil();
        return clienteCivil;
    }


}
