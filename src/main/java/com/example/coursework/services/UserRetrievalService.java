package com.example.coursework.services;

import com.example.coursework.exceptions.AppError;
import com.example.coursework.models.entity.User;
import com.example.coursework.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * @author max_pri
 */
@Service
public class UserRetrievalService {
    private final UserRepository userRepository;

    @Autowired
    public UserRetrievalService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public Optional<User> findByLogin(String login) {
        return userRepository.findByLogin(login);
    }

    public User getUserFromContext() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication instanceof AnonymousAuthenticationToken) {
            return null;
        } else {
            String userDetails = (String) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
            return findByLogin(userDetails).orElseThrow(() -> new AppError(1, "123"));
        }
    }
}
