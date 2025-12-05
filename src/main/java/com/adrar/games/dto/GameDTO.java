package com.adrar.games.dto;

import java.sql.Date;

public record GameDTO(
        String title,
        String type,
        Date publishAt,
        String console
) {
}
