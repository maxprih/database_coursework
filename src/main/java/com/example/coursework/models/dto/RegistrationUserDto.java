package com.example.coursework.models.dto;

import lombok.Data;

/**
 * @author max_pri
 */
@Data
public class RegistrationUserDto {
    private String login;
    private String name;
    private String password;
    private String confirmPassword;
}
