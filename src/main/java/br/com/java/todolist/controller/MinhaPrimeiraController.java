package br.com.java.todolist.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//Controller camada de requisição de banco de dados

// @Controller
@RestController
@RequestMapping("/primeiraRota")
//http://localhost:8080/primeiraRota -------
public class MinhaPrimeiraController {
    /**
     * Métodos de acesso ao HTTP
     * GET - Buscar uma informação
     * POST - Adicionar um dado/informação
     * PUT - Alterar um dado/informação
     * DELETE - Remover um dado/informação
     * PATCH - Alterar somente uma parte do dado/informação
     * @return
     */
    //Método (Funcionalidades) de uma classe
    @GetMapping("/primeiroMetodo")
    public String primeiraMensagem(){

        return "Funcionou, na segunda vez!";        

    }

}
