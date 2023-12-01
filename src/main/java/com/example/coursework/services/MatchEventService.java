package com.example.coursework.services;

import com.example.coursework.models.dto.requests.ChangeEventRequest;
import com.example.coursework.models.dto.requests.CreateMatchEventRequest;
import com.example.coursework.models.entity.Match;
import com.example.coursework.models.entity.MatchEvent;
import com.example.coursework.repositories.MatchEventRepository;
import com.example.coursework.repositories.MatchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author max_pri
 */
@Service
public class MatchEventService {
    private final MatchEventRepository matchEventRepository;
    private final MatchRepository matchRepository;

    @Autowired
    public MatchEventService(MatchEventRepository matchEventRepository, MatchRepository matchRepository) {
        this.matchEventRepository = matchEventRepository;
        this.matchRepository = matchRepository;
    }

    public void changeEventStatus(ChangeEventRequest request) {
        MatchEvent matchEvent = matchEventRepository.findById(request.getId()).get();
        matchEvent.setStatus(request.getStatus());

        matchEventRepository.save(matchEvent);
    }

    public void create(CreateMatchEventRequest request) {
        Match match = matchRepository.findById(request.getMatchId()).get();

        MatchEvent matchEvent = new MatchEvent();
        matchEvent.setStatus(request.getStatus());
        matchEvent.setMatch(match);
        matchEvent.setName(request.getName());
        matchEvent.setCoefficient(request.getCoefficient());

        matchEventRepository.save(matchEvent);
    }
}
