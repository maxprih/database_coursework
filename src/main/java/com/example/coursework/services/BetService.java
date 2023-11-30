package com.example.coursework.services;

import com.example.coursework.exceptions.AppError;
import com.example.coursework.models.dto.BetDto;
import com.example.coursework.models.dto.MatchEventDto;
import com.example.coursework.models.dto.requests.MakeBetRequest;
import com.example.coursework.models.entity.Bet;
import com.example.coursework.models.entity.MatchEvent;
import com.example.coursework.models.entity.User;
import com.example.coursework.models.entity.enums.BetStatus;
import com.example.coursework.repositories.BetRepository;
import com.example.coursework.repositories.MatchEventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author max_pri
 */
@Service
public class BetService {
    private final BetRepository betRepository;
    private final BalanceService balanceService;
    private final MatchEventRepository matchEventRepository;
    private final UserRetrievalService userRetrievalService;

    @Autowired
    public BetService(BetRepository betRepository, BalanceService balanceService, MatchEventRepository matchEventRepository, UserRetrievalService userRetrievalService) {
        this.betRepository = betRepository;
        this.balanceService = balanceService;
        this.matchEventRepository = matchEventRepository;
        this.userRetrievalService = userRetrievalService;
    }

    public List<BetDto> getAllBets() {
        User user = userRetrievalService.getUserFromContext();
        List<Bet> bets = betRepository.findAllByUserId(user.getId());
        return bets.stream()
                .map(bet -> {
                    Set<MatchEventDto> matchEventDtos = matchEventRepository.findByBetId(bet.getId());
                    double productOfCoefficients = matchEventDtos.stream()
                            .mapToDouble(MatchEventDto::getCoefficient)
                            .reduce(1, (a, b) -> a * b);
                    double winnings = betRepository.getBetWinning(bet.getId());

                    return BetDto.builder()
                            .id(bet.getId())
                            .status(bet.getStatus())
                            .date(bet.getDate())
                            .amount(bet.getAmount())
                            .matchEvents(matchEventDtos)
                            .coefficient(productOfCoefficients)
                            .winnings(winnings)
                            .build();
                })
                .toList();
    }

    @Transactional
    public void makeBet(MakeBetRequest request) {
        User user = userRetrievalService.getUserFromContext();
        if (user.getBalance().getAmount() < request.getAmount()) {
            throw new AppError(HttpStatus.BAD_REQUEST.value(), "Недостаточно денег");
        }
        Set<Integer> eventIds = request.getIds();

        Set<MatchEvent> events = matchEventRepository.findAllByIdIn(eventIds);

        Bet bet = Bet.builder()
                .matchEvents(events)
                .amount(request.getAmount())
                .date(Instant.now())
                .status(BetStatus.TBD)
                .user(user)
                .build();
        betRepository.save(bet);
        balanceService.changeUserBalance(user, -request.getAmount());
    }
}
