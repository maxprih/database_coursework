package com.example.coursework.controllers;

import com.example.coursework.models.dto.PokemonDto;
import com.example.coursework.services.PokemonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author max_pri
 */
@RestController
@RequestMapping("api/v1/pokemon")
public class PokemonController {
    private final PokemonService pokemonService;

    @Autowired
    public PokemonController(PokemonService pokemonService) {
        this.pokemonService = pokemonService;
    }

    @GetMapping("{name}")
    public ResponseEntity<PokemonDto> getPokemon(@PathVariable String name) {
        return ResponseEntity.ok(pokemonService.getPokemon(name));
    }
}
