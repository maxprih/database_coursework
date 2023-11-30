package com.example.coursework.models.dto;

import com.example.coursework.models.entity.enums.BetStatus;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.time.Instant;
import java.util.Set;

/**
 * @author max_pri
 */
@Data
@AllArgsConstructor
@Builder
public class BetDto {
    private Integer id;
    private Integer amount;
    @JsonSerialize(using = CustomInstantSerializer.class)
    private Instant date;
    private BetStatus status;
    private Set<MatchEventDto> matchEvents;
    private Double coefficient;
    private Double winnings;
}
