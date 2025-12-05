package com.adrar.games.controller;

import com.adrar.games.model.Console;
import com.adrar.games.repository.ConsoleRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
public class ConsoleController {

    //Instancier le ConsoleRepository
    private ConsoleRepository consoleRepository;

    //Créer le constructeur et injecter la dépendance
    public ConsoleController(ConsoleRepository consoleRepository)
    {
        this.consoleRepository = consoleRepository;
    }

    @GetMapping("/consoles")
    public ResponseEntity<ArrayList<Console>> getAllConsoles()
    {
        //Récupérer la liste des consoles
        ArrayList<Console> consoles = (ArrayList<Console>) consoleRepository.findAll();
        //Réponse HTTP
        return new ResponseEntity<>(consoles, HttpStatus.OK);
    }
}
