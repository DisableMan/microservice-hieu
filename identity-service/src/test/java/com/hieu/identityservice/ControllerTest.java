package com.hieu.identityservice;

import com.hieu.identityservice.controller.UserController;
import com.hieu.identityservice.dto.AuthRequest;
import com.hieu.identityservice.service.AuthService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.bind.annotation.RequestBody;

@WebMvcTest(UserController.class)
public class ControllerTest {
    @Autowired
    private MockMvc mvc;

    @MockBean
    private AuthService userService;

    @MockBean
    private AuthenticationManager authenticationManager;

    @Test
    public String getToken() {
        Authentication authenticate = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken("vip1","1"));
        if (authenticate.isAuthenticated()) {
            return userService.generateToken("vip1");
        } else {
            throw new RuntimeException("invalid access");
        }
    }

}
