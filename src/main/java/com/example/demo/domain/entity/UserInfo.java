package com.example.demo.domain.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class UserInfo {
    private String username;
    private String fullName;
    private String phoneNumber;
    private String password;
    @JsonProperty("last_login_time")
    private Long lastLoginTime;
    @JsonProperty("created_at")
    private Long createdAt;
    @JsonProperty("created_by")
    private String createdBy;
    @JsonProperty("updated_at")
    private Long updatedAt;
    @JsonProperty("updated_by")
    private String updatedBy;
    @JsonProperty("deleted_at")
    private Long deletedAt;
    @JsonProperty("deleted_by")
    private String deletedBy;
    @JsonProperty("deleted")
    private Boolean deleted = false;
}
