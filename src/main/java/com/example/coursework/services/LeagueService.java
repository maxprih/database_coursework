package com.example.coursework.services;

import com.example.coursework.models.dto.requests.CreateCountryRequest;
import com.example.coursework.models.dto.requests.CreateLeagueRequest;
import com.example.coursework.models.entity.League;
import com.example.coursework.repositories.LeagueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author max_pri
 */
@Service
public class LeagueService {
    private final LeagueRepository leagueRepository;

    @Autowired
    public LeagueService(LeagueRepository leagueRepository) {
        this.leagueRepository = leagueRepository;
    }

    public void createLeague(CreateLeagueRequest request) {
        League league = new League();
        league.setName(request.getName());
        league.setStartDate(request.getStartDate());
        league.setEndDate(request.getEndDate());

        leagueRepository.save(league);
    }
}
