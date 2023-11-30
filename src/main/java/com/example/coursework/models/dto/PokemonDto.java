package com.example.coursework.models.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

/**
 * @author max_pri
 */
@Data
@Builder
@AllArgsConstructor
public class PokemonDto {
    private Integer id;
    private String name;
    private Integer health;
    private Integer damage;
    private Integer defense;
    private String countryName;
}
