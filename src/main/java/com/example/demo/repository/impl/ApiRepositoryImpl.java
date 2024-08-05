package com.example.demo.repository.impl;

import com.example.demo.domain.entity.UserInfo;
import com.example.demo.repository.ApiRepository;
import com.example.demo.util.AppUtils;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Repository;

/**
 * Thao tác truy vấn, insert, update, delete với Database tại đây
 */

@Log4j2
@Repository
@RequiredArgsConstructor
public class ApiRepositoryImpl implements ApiRepository {
    @Override
    public UserInfo findByUsername(String username, String keyLog) {
        // TODO Nếu có kết nối Database sẽ get dữ liệu từ DB. Hiện fix code fake dữ liệu lấy từ DB
        int numberRandom = AppUtils.random(1, 10);
        log.debug("{} numberRandom {}", keyLog, numberRandom);
        if (numberRandom % 2 == 0) {
            // Random số chẵn thì Giả lập đây là không tìm thấy id này trong DB
            return null;
        } else {
            // Giả lập đây là dữ liệu lấy được từ DB
            UserInfo userInfo = new UserInfo();
            userInfo.setUsername(username);
            userInfo.setPassword("aaaaaaaa");
            userInfo.setLastLoginTime(System.currentTimeMillis());
            userInfo.setCreatedAt(System.currentTimeMillis());
            userInfo.setUpdatedAt(System.currentTimeMillis());
            userInfo.setCreatedBy("KatoIT_ADMIN");
            userInfo.setUpdatedBy("KatoIT");
            return userInfo;
        }
    }
}
