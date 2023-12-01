package com.example.coursework.services;

import com.example.coursework.models.dto.MatchDto;
import com.example.coursework.models.dto.requests.CreateMatchRequest;
import com.example.coursework.models.dto.responses.GetAllMatchesResponse;
import com.example.coursework.models.entity.Country;
import com.example.coursework.models.entity.League;
import com.example.coursework.models.entity.Match;
import com.example.coursework.models.entity.Pokemon;
import com.example.coursework.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.ZoneOffset;
import java.util.List;

/**
 * @author max_pri
 */
@Service
public class MatchService {
    private final MatchRepository matchRepository;
    private final CountryRepository countryRepository;
    private final LeagueRepository leagueRepository;
    private final MatchEventRepository matchEventRepository;
    private final PokemonRepository pokemonRepository;

    @Autowired
    public MatchService(MatchRepository matchRepository, CountryRepository countryRepository, LeagueRepository leagueRepository, MatchEventRepository matchEventRepository, PokemonRepository pokemonRepository) {
        this.matchRepository = matchRepository;
        this.countryRepository = countryRepository;
        this.leagueRepository = leagueRepository;
        this.matchEventRepository = matchEventRepository;
        this.pokemonRepository = pokemonRepository;
    }

    public GetAllMatchesResponse getAllMatches() {
        List<MatchDto> matchDtos = matchRepository.findAllMatchesInfo();


        return GetAllMatchesResponse.builder()
                .matches(matchDtos)
                .build();
    }

    public void create(CreateMatchRequest createMatchRequest) {
        League league = leagueRepository.findById(createMatchRequest.getLeagueId()).get();
        Country country = countryRepository.findById(createMatchRequest.getCountryId()).get();
        Pokemon pokemon1 = pokemonRepository.findById(createMatchRequest.getFirstPlayerId()).get();
        Pokemon pokemon2 = pokemonRepository.findById(createMatchRequest.getSecondPlayerId()).get();


        Match match = new Match();
        match.setCountry(country);
        match.setLeague(league);
        match.setDate(createMatchRequest.getDate().toInstant(ZoneOffset.UTC)); //change on front to instant
        match.setFirstPlayer(pokemon1);
        match.setSecondPlayer(pokemon2);

        matchRepository.save(match);
    }

    public MatchDto getMatchById(Integer id) {
        MatchDto matchDto = matchRepository.findMatchById(id);
        matchDto.setMatchEvents(matchEventRepository.findMatchEventsByMatchId(id));
        return matchDto;
    }
}
