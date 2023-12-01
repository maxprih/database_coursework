package com.example.coursework.controllers;

import com.example.coursework.models.dto.LeagueDto;
import com.example.coursework.models.dto.requests.CreateLeagueRequest;
import com.example.coursework.repositories.LeagueRepository;
import com.example.coursework.services.LeagueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author max_pri
 */
@RestController
@RequestMapping("api/v1/league")
public class LeagueController {
    private final LeagueRepository leagueRepository;
    private final LeagueService leagueService;

    @Autowired
    public LeagueController(LeagueRepository leagueRepository, LeagueService leagueService) {
        this.leagueRepository = leagueRepository;
        this.leagueService = leagueService;
    }

    @GetMapping()
    public ResponseEntity<List<LeagueDto>> getAll() {
        return ResponseEntity.ok(leagueRepository.getAll());
    }

    @PostMapping()
    public ResponseEntity<?> create(@RequestBody CreateLeagueRequest request) {
        leagueService.createLeague(request);
        return ResponseEntity.ok().build();
    }
}
