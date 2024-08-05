package com.example.demo.domain.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class UserInfoDto {
    private String username;
    private String fullName;
    private String phoneNumber;
    @JsonProperty("last_login_time")
    private Long lastLoginTime;
}
