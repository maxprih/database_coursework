package com.example.coursework.models.dto;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;
import java.time.Instant;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

/**
 * @author max_pri
 */
public class CustomInstantSerializer extends JsonSerializer<Instant> {
    private static final DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");

    @Override
    public void serialize(Instant value, JsonGenerator gen, SerializerProvider serializers) throws IOException {
        String formattedDate = DATE_TIME_FORMATTER.format(value.atZone(ZoneId.systemDefault()));
        gen.writeString(formattedDate);
    }
}
