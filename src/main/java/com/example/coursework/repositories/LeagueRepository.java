package com.example.coursework.repositories;

import com.example.coursework.models.dto.LeagueDto;
import com.example.coursework.models.entity.League;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author max_pri
 */
@Repository
public interface LeagueRepository extends JpaRepository<League, Integer> {

    @Query("select new com.example.coursework.models.dto.LeagueDto(l.id, l.name, l.startDate, l.endDate) from League l")
    List<LeagueDto> getAll();
}
