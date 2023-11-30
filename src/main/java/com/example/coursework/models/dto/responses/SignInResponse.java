package com.example.coursework.models.dto.responses;

import com.example.coursework.models.dto.UserDto;
import com.example.coursework.models.entity.Role;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Set;

/**
 * @author max_pri
 */
@Data
@AllArgsConstructor
public class SignInResponse {
    private String accessToken;
    private Integer id;
    private String login;
    private String name;
    private Integer balanceAmount;
    private Set<Role> roles;
}
