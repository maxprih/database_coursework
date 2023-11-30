package com.example.coursework.models.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "match_event_bet")
public class MatchEventBet {
    @EmbeddedId
    private MatchEventBetId id;

    @MapsId("matchEventId")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "match_event_id", nullable = false)
    private MatchEvent matchEvent;

    @MapsId("betId")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "bet_id", nullable = false)
    private Bet bet;

    public MatchEventBetId getId() {
        return id;
    }

    public void setId(MatchEventBetId id) {
        this.id = id;
    }

    public MatchEvent getMatchEvent() {
        return matchEvent;
    }

    public void setMatchEvent(MatchEvent matchEvent) {
        this.matchEvent = matchEvent;
    }

    public Bet getBet() {
        return bet;
    }

    public void setBet(Bet bet) {
        this.bet = bet;
    }

}