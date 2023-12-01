package com.example.coursework.models.dto.requests;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

/**
 * @author max_pri
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonSerialize
public class CreateLeagueRequest {
    private String name;
    private LocalDate startDate;
    private LocalDate endDate;
}
