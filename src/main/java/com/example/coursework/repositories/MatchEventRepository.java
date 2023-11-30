package com.example.coursework.repositories;

import com.example.coursework.models.dto.MatchEventDto;
import com.example.coursework.models.entity.MatchEvent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.Set;

/**
 * @author max_pri
 */
@Repository
public interface MatchEventRepository extends JpaRepository<MatchEvent, Integer> {

    @Query("SELECT new com.example.coursework.models.dto.MatchEventDto(me.id, me.name, me.coefficient, m.id, m.firstPlayer.name, m.secondPlayer.name, m.date, me.status) " +
            "FROM MatchEvent me JOIN me.match m WHERE m.id = :id")
    Set<MatchEventDto> findMatchEventsByMatchId(@Param("id") Integer id);

    @Query("SELECT me FROM MatchEvent me WHERE me.id IN :eventIds")
    Set<MatchEvent> findAllByIdIn(@Param("eventIds") Set<Integer> eventIds);

    @Query("select new com.example.coursework.models.dto.MatchEventDto(me.id, me.name, me.coefficient, m.id, m.firstPlayer.name, m.secondPlayer.name, m.date, me.status) FROM MatchEventBet meb JOIN MatchEvent me on meb.matchEvent.id = me.id JOIN Match m  on me.match.id = m.id where meb.bet.id = :betId")
    Set<MatchEventDto> findByBetId(@Param("betId") Integer betId);

    Optional<MatchEvent> findById(Integer id);
}
