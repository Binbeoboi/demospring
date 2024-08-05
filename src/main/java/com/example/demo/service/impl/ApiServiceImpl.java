package com.example.demo.service.impl;

import com.example.demo.common.ResponseCode;
import com.example.demo.common.ResponseMsg;
import com.example.demo.domain.dto.UserInfoDto;
import com.example.demo.domain.entity.UserInfo;
import com.example.demo.domain.response.BaseResponse;
import com.example.demo.repository.ApiRepository;
import com.example.demo.service.ApiService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.Objects;

/**
 * Xử lý validate dữ liệu input từ client
 * Xử lý nghiệp vụ tại đây
 */

@Log4j2
@Service
@RequiredArgsConstructor
public class ApiServiceImpl implements ApiService {
    private final ApiRepository apiRepository;

    @Override
    public BaseResponse findById(Boolean isAdmin, String usernameAcc, String username, String keyLog) {
        BaseResponse response = new BaseResponse();
        // Validate isAdmin
        if (usernameAcc == null || usernameAcc.isEmpty()) {
            response.setCode(ResponseCode.FAIL);
            response.setMsg("Thiếu thông tin Username!");
            return response;
        }
        // Validate isAdmin
        if (isAdmin == null || !isAdmin) {
            if (!Objects.equals(usernameAcc, username)) {
                response.setCode(ResponseCode.FAIL);
                response.setMsg("Bạn không có quyền lấy thông tin này!");
                return response;
            }
        }
        // Validate id
        if (username == null || username.isEmpty()) {
            response.setCode(ResponseCode.FAIL);
            response.setMsg("Thiếu thông tin username!");
            return response;
        }

        UserInfo userInfo = apiRepository.findByUsername(username, keyLog);
        log.debug("{} user info {}", keyLog, userInfo);
        if (userInfo == null) {
            response.setCode(ResponseCode.FAIL);
            response.setMsg("Không tìm thấy thông tin người dùng với username = " + username);
            return response;
        }
        // Map to DTO Do user có 1 số thông tin không được phép trả về VD password nên phải xử lý dữ liệu trước khi trả về
        UserInfoDto userInfoDto = new UserInfoDto();
        userInfoDto.setUsername(username);
        userInfoDto.setPhoneNumber(userInfo.getPhoneNumber());
        userInfoDto.setFullName(userInfo.getFullName());
        userInfoDto.setPhoneNumber(userInfo.getPhoneNumber());
        //
        response.setCode(ResponseCode.SUCCESS);
        response.setMsg(ResponseMsg.SUCCESS);
        response.setData(userInfoDto);
        return response;
    }
}
