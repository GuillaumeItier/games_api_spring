package com.adrar.games.dto;

import com.adrar.games.model.Game;
import org.springframework.stereotype.Service;

@Service
public class WrapperGameToGameDTO {

    public GameDTO wrapGameToGameDTO(Game game)
    {
        return new GameDTO(
                game.getTitle(),
                game.getType(),
                game.getPublishAt(),
                game.getConsole().getName()
        );
    }
}
