package com.example.coursework.services;

/**
 * @author max_pri
 */
import com.example.coursework.exceptions.AppError;
import com.example.coursework.models.dto.RegistrationUserDto;
import com.example.coursework.models.dto.UserDto;
import com.example.coursework.models.dto.requests.JwtRequest;
import com.example.coursework.models.dto.responses.SignInResponse;
import com.example.coursework.models.entity.User;
import com.example.coursework.utils.JwtTokenUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public class AuthService {
    private final UserService userService;
    private final UserRetrievalService userRetrievalService;
    private final JwtTokenUtils jwtTokenUtils;
    private final AuthenticationManager authenticationManager;

    @Autowired
    public AuthService(UserService userService, UserRetrievalService userRetrievalService, JwtTokenUtils jwtTokenUtils, AuthenticationManager authenticationManager) {
        this.userService = userService;
        this.userRetrievalService = userRetrievalService;
        this.jwtTokenUtils = jwtTokenUtils;
        this.authenticationManager = authenticationManager;
    }

    public ResponseEntity<?> createAuthToken(@RequestBody JwtRequest authRequest) {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authRequest.getLogin(), authRequest.getPassword())).isAuthenticated();
        } catch (BadCredentialsException e) {
            return new ResponseEntity<>(new AppError(HttpStatus.UNAUTHORIZED.value(), "Неправильный логин или пароль"), HttpStatus.UNAUTHORIZED);
        }
        UserDetails userDetails = userService.loadUserByUsername(authRequest.getLogin());
        User user = userRetrievalService.findByLogin(userDetails.getUsername()).get();
        String token = jwtTokenUtils.generateToken(userDetails);

        return ResponseEntity.ok(new SignInResponse(token, user.getId(), user.getLogin(), user.getName(), user.getBalance().getAmount(), user.getRoles()));
    }

    public ResponseEntity<?> createNewUser(@RequestBody RegistrationUserDto registrationUserDto) {
        if (!registrationUserDto.getPassword().equals(registrationUserDto.getConfirmPassword())) {
            return new ResponseEntity<>(new AppError(HttpStatus.BAD_REQUEST.value(), "Пароли не совпадают"), HttpStatus.BAD_REQUEST);
        }
        if (userRetrievalService.findByLogin(registrationUserDto.getLogin()).isPresent()) {
            return new ResponseEntity<>(new AppError(HttpStatus.BAD_REQUEST.value(), "Пользователь с указанным логином уже существует"), HttpStatus.BAD_REQUEST);
        }
        User user = userService.createNewUser(registrationUserDto);
        return ResponseEntity.ok(new UserDto(user.getId(), user.getLogin(), user.getName(), user.getBalance().getAmount(), user.getRoles()));
    }

    public UserDto getMe() {
        User user = userRetrievalService.getUserFromContext();
        return new UserDto(user.getId(), user.getLogin(), user.getName(), user.getBalance().getAmount(), user.getRoles());
    }
}
