package com.example.coursework.models.dto;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.Instant;
import java.util.LinkedHashSet;
import java.util.Set;

/**
 * @author max_pri
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MatchDto {
    private Integer id;
    private String firstPlayerName;
    private String secondPlayerName;
    @JsonSerialize(using = CustomInstantSerializer.class)
    private Instant date;
    private String leagueName;
    private String countryName;
    private Set<MatchEventDto> matchEvents;

    public MatchDto(Integer id, String firstPlayerName, String secondPlayerName, Instant date, String leagueName, String countryName) {
        this.id = id;
        this.firstPlayerName = firstPlayerName;
        this.secondPlayerName = secondPlayerName;
        this.date = date;
        this.leagueName = leagueName;
        this.countryName = countryName;
    }
}
