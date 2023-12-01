package com.example.coursework.repositories;

import com.example.coursework.models.dto.CountryDto;
import com.example.coursework.models.entity.Country;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * @author max_pri
 */
@Repository
public interface CountryRepository extends JpaRepository<Country, Integer> {

    @Query("select new com.example.coursework.models.dto.CountryDto(c.id, c.name) from Country c")
    List<CountryDto> getAllCountries();

    Optional<Country> findById(Integer id);
}
