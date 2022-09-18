package miu.waa.springsecurity.service;


import miu.waa.springsecurity.entity.User;
import miu.waa.springsecurity.model.request.LoginRequest;
import miu.waa.springsecurity.model.request.RefreshTokenRequest;
import miu.waa.springsecurity.model.response.LoginResponse;

import java.util.List;

public interface UaaService {
    LoginResponse login(LoginRequest loginRequest);
    LoginResponse refreshToken(RefreshTokenRequest refreshTokenRequest);

    List<User> userList();

    User saveUser(User user);
}
