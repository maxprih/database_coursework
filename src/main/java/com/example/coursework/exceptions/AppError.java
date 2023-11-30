package com.example.coursework.exceptions;

import lombok.Data;

import java.util.Date;

/**
 * @author max_pri
 */
@Data
public class AppError extends RuntimeException{
    private int status;
    private String message;
    private Date timestamp;

    public AppError(int status, String message) {
        this.status = status;
        this.message = message;
        this.timestamp = new Date();
    }
}
