package miu.waa.springsecurity.controller;

import miu.waa.springsecurity.entity.User;
import miu.waa.springsecurity.model.request.LoginRequest;
import miu.waa.springsecurity.model.response.LoginResponse;
import miu.waa.springsecurity.model.request.RefreshTokenRequest;
import miu.waa.springsecurity.service.UaaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/uaa")
@CrossOrigin
public class UaaController {

    private final UaaService uaaService;

    public UaaController(UaaService uaaService) {
        this.uaaService = uaaService;
    }

    @PostMapping
    public ResponseEntity<?> login(@RequestBody LoginRequest loginRequest) {
        var loginResponse = uaaService.login(loginRequest);
        return ResponseEntity.ok().body(loginResponse);
    }

    @PostMapping("/refreshToken")
    public LoginResponse refreshToken(@RequestBody RefreshTokenRequest refreshTokenRequest){
        return uaaService.refreshToken(refreshTokenRequest);
    }

    @GetMapping("/users")
    public List<User> userList(){
        return uaaService.userList();
    }

    @PostMapping("/signup")
    public User signUp(@RequestBody User user){
       return uaaService.saveUser(user);
    }

}
