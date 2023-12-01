package com.example.coursework.controllers;

import com.example.coursework.models.dto.PokemonDto;
import com.example.coursework.models.dto.requests.CreatePokemonRequest;
import com.example.coursework.services.PokemonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping
    public ResponseEntity<List<PokemonDto>> getAll() {
        return ResponseEntity.ok(pokemonService.getAll());
    }

    @GetMapping("{name}")
    public ResponseEntity<PokemonDto> getPokemon(@PathVariable String name) {
        return ResponseEntity.ok(pokemonService.getPokemon(name));
    }

    @PostMapping
    public ResponseEntity<?> create(@RequestBody CreatePokemonRequest createPokemonRequest) {
        pokemonService.create(createPokemonRequest);

        return ResponseEntity.ok().build();
    }
}
