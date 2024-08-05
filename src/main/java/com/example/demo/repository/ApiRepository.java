package com.example.demo.repository;

import com.example.demo.domain.entity.UserInfo;

public interface ApiRepository {
    UserInfo findByUsername(String username, String keyLog);
}
