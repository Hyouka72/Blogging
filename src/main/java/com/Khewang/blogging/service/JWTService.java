package com.Khewang.blogging.service;

import org.springframework.security.core.userdetails.UserDetails;

public interface JWTService {
    public String generateToken(String username);

    String extactUserName(String token);

    boolean validateToken(String token, UserDetails userDetails);
}
