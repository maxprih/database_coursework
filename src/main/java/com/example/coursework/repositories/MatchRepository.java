package com.example.coursework.repositories;

import com.example.coursework.models.dto.MatchDto;
import com.example.coursework.models.entity.Match;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author max_pri
 */
@Repository
public interface MatchRepository extends JpaRepository<Match, Integer> {
    @Query("SELECT new com.example.coursework.models.dto.MatchDto(m.id, m.firstPlayer.name, m.secondPlayer.name, m.date, m.league.name, m.country.name) FROM Match m")
    List<MatchDto> findAllMatchesInfo();



    @Query("SELECT new com.example.coursework.models.dto.MatchDto(m.id, m.firstPlayer.name, m.secondPlayer.name, m.date, m.league.name, m.country.name) " +
            "FROM Match m WHERE m.id = :id")
    MatchDto findMatchById(@Param("id") Integer id);


}
