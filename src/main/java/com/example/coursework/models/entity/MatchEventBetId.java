package com.example.coursework.models.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import org.hibernate.Hibernate;

import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class MatchEventBetId implements Serializable {
    private static final long serialVersionUID = 8989298808127439278L;
    @Column(name = "match_event_id", nullable = false)
    private Integer matchEventId;

    @Column(name = "bet_id", nullable = false)
    private Integer betId;

    public Integer getMatchEventId() {
        return matchEventId;
    }

    public void setMatchEventId(Integer matchEventId) {
        this.matchEventId = matchEventId;
    }

    public Integer getBetId() {
        return betId;
    }

    public void setBetId(Integer betId) {
        this.betId = betId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        MatchEventBetId entity = (MatchEventBetId) o;
        return Objects.equals(this.matchEventId, entity.matchEventId) &&
                Objects.equals(this.betId, entity.betId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(matchEventId, betId);
    }

}