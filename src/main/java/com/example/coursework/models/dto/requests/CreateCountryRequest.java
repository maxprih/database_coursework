package com.example.coursework.models.dto.requests;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author max_pri
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonSerialize
public class CreateCountryRequest {
    private String name;
}
