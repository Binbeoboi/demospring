package com.example.demo.controller;

import com.example.demo.domain.entity.UserInfo;
import com.example.demo.domain.request.BaseRequest;
import com.example.demo.domain.request.ChangePasswordRequest;
import com.example.demo.domain.response.BaseResponse;
import com.example.demo.service.ApiService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.*;

/**
 * Khai báo các API tại đây
 */
@Log4j2
@RestController
@RequestMapping("api/user")
@RequiredArgsConstructor
public class ApiController {
    private final ApiService apiService;

    @GetMapping("{username}")
    public BaseResponse findById(
            @RequestHeader(value = "Is-Admin", required = false) Boolean isAdmin,
            @RequestHeader(value = "Username", required = false) String usernameAcc,
            @PathVariable String username
    ) {
        String keyLog = "findById";
        log.debug("{} S API isAdmin {}, usernameAcc {}, username {}", keyLog, isAdmin, usernameAcc, username);
        BaseResponse response = apiService.findById(isAdmin, usernameAcc, username, keyLog);
        log.debug("{} E API response {}", keyLog, response.baseInfo());
        return response;
    }

    /**
     * TODO
     * Check chỉ Admin được phép thêm user
     * Validate
     * - password > 8 ký tự và < 50 ký tự, chứ ít nhất 1 chữ hoa & 1 chữ thường & 1 số & 1 ký tự đặc biệt. Bắt buộc có
     * - username > 10 ký tự và < 50 ký tự, chỉ chứa chữ cái thường và chứ số, Không được bắt đầu bằng chữ số,
     * check trùng username nếu đã tồn tại thì không được tạo thêm. Bắt buộc có
     * - fullName < 100 ký tự. Không bắt buộc có
     * - phoneNumber = 10 ký tự. Không bắt buộc có
     */
    @PostMapping
    public BaseResponse createUser(
            @RequestHeader(value = "Is-Admin", required = false) Boolean isAdmin,
            @RequestHeader(value = "Username", required = false) String username,
            @RequestBody BaseRequest<UserInfo> request
    ) {
        // TODO
        return null;
    }

    /**
     * TODO
     * Check Admin hoặc chính người dùng đó được phép sửa user
     * Chỉ được phép update fullName, phoneNumber
     * - fullName < 100 ký tự. Không bắt buộc có
     * - phoneNumber = 10 ký tự. Không bắt buộc có
     */
    @PutMapping("{id}")
    public BaseResponse updateUser(
            @RequestHeader(value = "Is-Admin", required = false) Boolean isAdmin,
            @RequestHeader(value = "Username", required = false) String username,
            @RequestBody BaseRequest<UserInfo> request
    ) {
        // TODO
        return null;
    }

    /**
     * TODO
     * Check Admin hoặc chính người dùng đó được phép đổi mật khẩu
     * - oldPassword Bắt buộc có nếu không phải admin. Nếu không phải Admin check đúng pass cũ mới cho phép đổi pass
     * - newPassword > 8 ký tự và < 50 ký tự, chứ ít nhất 1 chữ hoa & 1 chữ thường & 1 số & 1 ký tự đặc biệt. Bắt buộc có
     */
    @PutMapping("{id}/change-password")
    public BaseResponse updatePasswordUser(
            @RequestHeader(value = "Is-Admin", required = false) Boolean isAdmin,
            @RequestHeader(value = "Username", required = false) String username,
            @RequestBody ChangePasswordRequest request
    ) {
        // TODO
        return null;
    }

    /**
     * TODO
     * Check Admin hoặc chính người dùng đó được phép xoá user
     * Thay vì xoá đi thì thực hiện cập nhật trường deleted = True và thời gian xoá, người xoá
     */
    @DeleteMapping("{id}")
    public BaseResponse deleteUser(
            @RequestHeader(value = "Is-Admin", required = false) Boolean isAdmin,
            @RequestHeader(value = "Username", required = false) String username
            ) {
        // TODO
        return null;
    }
}
