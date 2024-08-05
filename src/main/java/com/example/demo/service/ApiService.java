package com.example.demo.service;

import com.example.demo.domain.response.BaseResponse;

public interface ApiService {
    BaseResponse findById(Boolean isAdmin, String usernameAcc, String username, String keyLog);
}
