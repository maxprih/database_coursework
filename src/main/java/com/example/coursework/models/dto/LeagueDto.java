package com.example.coursework.models.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

/**
 * @author max_pri
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class LeagueDto {
    private Integer id;
    private String name;
    private LocalDate startDate;
    private LocalDate endDate;
}
