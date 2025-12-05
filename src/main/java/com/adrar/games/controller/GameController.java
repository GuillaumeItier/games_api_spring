package com.adrar.games.controller;

import com.adrar.games.dto.GameDTO;
import com.adrar.games.dto.WrapperGameToGameDTO;
import com.adrar.games.exception.GameNotFoundException;
import com.adrar.games.model.Game;
import com.adrar.games.repository.GameRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
public class GameController {

    //Attribut pour utiliser le GameRepository
    private final GameRepository gameRepository;
    private final WrapperGameToGameDTO wrapperGameToGameDTO;


    public GameController(GameRepository gameRepository, WrapperGameToGameDTO wrapperGameToGameDTO) {
        this.gameRepository = gameRepository;
        this.wrapperGameToGameDTO = wrapperGameToGameDTO;
    }

    @GetMapping("/games")
    public ResponseEntity<Iterable<Game>> getAllGames()
    {
        return new ResponseEntity<>(gameRepository.findAll(), HttpStatus.OK);
    }

    @GetMapping("/game/{id}")
    public ResponseEntity<Game> getGameById(@PathVariable Integer id)
    {

        //cas ou le jeu n'existe pas
        return new ResponseEntity<>(gameRepository.findById(id).orElseThrow(
                ()-> new GameNotFoundException("Le jeu avec l'id " + id + " n'existe pas")
        ), HttpStatus.OK);
    }

    @PostMapping("/game")
    public ResponseEntity<Game> saveGame(@RequestBody Game game)
    {
        return new ResponseEntity<>(gameRepository.save(game), HttpStatus.CREATED);
    }

    @GetMapping("/games/dto")
    public ResponseEntity<List<GameDTO>> getAllGamesDTO()
    {
        //Récupération de la liste
        Iterable<Game> games = gameRepository.findAll();
        //List vide
        List<GameDTO> gameDTOs = new ArrayList<>();

        //Parcours la liste des jeux (games)
        for(Game game : games){
            //Transformer un game en GameDTO
            GameDTO gameDto = this.wrapperGameToGameDTO.wrapGameToGameDTO(game);
            //ajouter à la liste
            gameDTOs.add(gameDto);
        }
        //Retourne la liste des GameDTO
        return new ResponseEntity<>(gameDTOs, HttpStatus.OK);
    }
}
