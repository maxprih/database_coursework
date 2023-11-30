package com.example.coursework.services;

import com.example.coursework.models.dto.PokemonDto;
import com.example.coursework.repositories.PokemonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author max_pri
 */
@Service
public class PokemonService {
    private final PokemonRepository pokemonRepository;

    @Autowired
    public PokemonService(PokemonRepository pokemonRepository) {
        this.pokemonRepository = pokemonRepository;
    }

    public PokemonDto getPokemon(String name) {
        return pokemonRepository.findPokemonByName(name);
    }
}
