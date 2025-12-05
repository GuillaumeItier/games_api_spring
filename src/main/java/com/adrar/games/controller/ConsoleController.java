package com.adrar.games.controller;

import com.adrar.games.model.Console;
import com.adrar.games.repository.ConsoleRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Optional;

@RestController
public class ConsoleController {

    //Instancier le ConsoleRepository
    private ConsoleRepository consoleRepository;

    //Créer le constructeur et injecter la dépendance
    public ConsoleController(ConsoleRepository consoleRepository)
    {
        this.consoleRepository = consoleRepository;
    }

    //Méthode qui retourne toutes les consoles
    @GetMapping("/consoles")
    public ResponseEntity<ArrayList<Console>> getAllConsoles()
    {
        //Récupérer la liste des consoles
        ArrayList<Console> consoles = (ArrayList<Console>) consoleRepository.findAll();
        //Réponse HTTP
        return new ResponseEntity<>(consoles, HttpStatus.OK);
    }

    //Méthode qui retourne une console avec son id
    @GetMapping("/console/{id}")
    public ResponseEntity<Optional<Console>> getConsoleById(@PathVariable Integer id)
    {
        //récupération de la console
        Optional<Console> console = consoleRepository.findById(id);

        //Test si la console existe
        if (console.isPresent()) {
            //Retourner réponse HTTP
            return new ResponseEntity<>(console, HttpStatus.OK);
        }
        //Si la console n'existe pas
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
