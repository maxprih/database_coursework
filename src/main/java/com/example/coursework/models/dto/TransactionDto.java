package com.example.coursework.models.dto;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.Builder;
import lombok.Data;
import lombok.Value;

import java.io.Serializable;
import java.time.Instant;

@Data
@Builder
public class TransactionDto {
    private Integer id;
    private Integer amount;
    @JsonSerialize(using = CustomInstantSerializer.class)
    private Instant date;
    private String type;
}