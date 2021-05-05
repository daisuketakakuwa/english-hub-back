package jp.english.hub.englishhubback.domain.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jp.english.hub.englishhubback.domain.auth.request.LoginRequest;
import jp.english.hub.englishhubback.domain.auth.request.LoginResponse;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    AuthService authService;

    @PutMapping("/login")
    public LoginResponse authorize(@RequestBody LoginRequest req) {
        String token = authService.authenticate(req.getName(), req.getPassword());
        if (token.isEmpty()) {
            return LoginResponse.builder().success(false).build();
        } else {
            return LoginResponse.builder().success(true).name(req.getName()).token(token).build();
        }
    }

}
