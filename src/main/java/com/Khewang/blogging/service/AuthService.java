package com.Khewang.blogging.service;

import com.Khewang.blogging.payload.JwtAuthRequest;

public interface AuthService {
    public String verify(JwtAuthRequest user);
}
