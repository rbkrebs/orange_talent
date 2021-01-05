package com.bancovid.BancoVid.rest.v1;


import com.bancovid.BancoVid.controller.ClienteController;
import com.bancovid.BancoVid.dto.ClienteCivilDTO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/v1/cliente_civil")
@Api(value="API REST Cliente Civil")
@CrossOrigin(origins = "*")
public class ClienteCivilRest {



    @Autowired
    private ClienteController clienteController;


    @GetMapping("/cliente")
    @ApiOperation(value = "Retorna todos os registros de cliente")
    public List<ClienteCivilDTO> findAll(){

        return null;//this.clienteController.listarTodos().get();
    }

    @PostMapping("/cliente")
    @ApiOperation(value = "Cria um registro de cliente civil")

    public ResponseEntity create(
            @Valid @RequestBody ClienteCivilDTO clienteCivilDTO ){

        try{
            return ResponseEntity.ok(this.clienteController.clienteSave(clienteCivilDTO));
        }catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }





    }
}
