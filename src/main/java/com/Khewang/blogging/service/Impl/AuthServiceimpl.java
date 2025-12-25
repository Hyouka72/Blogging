package com.Khewang.blogging.service.Impl;

import com.Khewang.blogging.payload.JwtAuthRequest;
import com.Khewang.blogging.service.AuthService;
import org.springframework.security.core.Authentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceimpl implements AuthService {

    @Autowired
    AuthenticationManager authManager;

    @Override
    public String verify(JwtAuthRequest user) {
        Authentication authentication = authManager.authenticate(new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword()));

        if(authentication.isAuthenticated())
            return "Success";

        return "Denied";
    }
}
