package com.example.coursework.services;

import com.example.coursework.models.dto.MatchDto;
import com.example.coursework.models.dto.responses.GetAllMatchesResponse;
import com.example.coursework.repositories.MatchEventRepository;
import com.example.coursework.repositories.MatchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author max_pri
 */
@Service
public class MatchService {
    private final MatchRepository matchRepository;
    private final MatchEventRepository matchEventRepository;

    @Autowired
    public MatchService(MatchRepository matchRepository, MatchEventRepository matchEventRepository) {
        this.matchRepository = matchRepository;
        this.matchEventRepository = matchEventRepository;
    }

    public GetAllMatchesResponse getAllMatches() {
        List<MatchDto> matchDtos = matchRepository.findAllMatchesInfo();


        return GetAllMatchesResponse.builder()
                .matches(matchDtos)
                .build();
    }

    public MatchDto getMatchById(Integer id) {
        MatchDto matchDto = matchRepository.findMatchById(id);
        matchDto.setMatchEvents(matchEventRepository.findMatchEventsByMatchId(id));
        return matchDto;
    }
}
