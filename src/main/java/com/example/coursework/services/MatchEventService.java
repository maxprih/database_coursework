package com.example.coursework.services;

import com.example.coursework.models.dto.requests.ChangeEventRequest;
import com.example.coursework.models.entity.MatchEvent;
import com.example.coursework.repositories.MatchEventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author max_pri
 */
@Service
public class MatchEventService {
    private final MatchEventRepository matchEventRepository;

    @Autowired
    public MatchEventService(MatchEventRepository matchEventRepository) {
        this.matchEventRepository = matchEventRepository;
    }

    public void changeEventStatus(ChangeEventRequest request) {
        MatchEvent matchEvent = matchEventRepository.findById(request.getId()).get();
        matchEvent.setStatus(request.getStatus());

        matchEventRepository.save(matchEvent);
    }
}
