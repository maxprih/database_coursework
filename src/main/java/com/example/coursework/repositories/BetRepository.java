package com.example.coursework.repositories;

import com.example.coursework.models.dto.BetDto;
import com.example.coursework.models.entity.Bet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author max_pri
 */
@Repository
public interface BetRepository extends JpaRepository<Bet, Integer> {
    List<Bet> findAllByUserId(Integer userId);

    @Query(nativeQuery = true, value = "select * from calculate_bet_winnings(:betId)")
    Double getBetWinning(@Param("betId") Integer betId);
}
