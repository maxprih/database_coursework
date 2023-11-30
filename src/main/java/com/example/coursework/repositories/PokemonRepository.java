package com.example.coursework.repositories;

import com.example.coursework.models.dto.PokemonDto;
import com.example.coursework.models.entity.Pokemon;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


/**
 * @author max_pri
 */
@Repository
public interface PokemonRepository extends JpaRepository<Pokemon, Integer> {

    @Query("select new com.example.coursework.models.dto.PokemonDto(p.id, p.name, p.health, p.damage, p.defense, p.country.name) FROM Pokemon p where p.name=:name")
    PokemonDto findPokemonByName(@Param("name") String name);
}
