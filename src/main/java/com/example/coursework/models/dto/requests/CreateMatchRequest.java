package com.example.coursework.models.dto.requests;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * @author max_pri
 */
@Data
@JsonSerialize
@NoArgsConstructor
@AllArgsConstructor
public class CreateMatchRequest {
    private Integer firstPlayerId;
    private Integer secondPlayerId;
    private LocalDateTime date;
    private Integer leagueId;
    private Integer countryId;
}
