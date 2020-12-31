package com.bancovid.BancoVid.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
@RequestMapping("cliente")
public class ClienteController {


    @GetMapping("/")
    public String clientePerfil(){
        return "index";
    }


}
