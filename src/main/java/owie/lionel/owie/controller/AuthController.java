package owie.lionel.owie.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import owie.lionel.owie.service.security.AuthorizationService;
import owie.lionel.owie.payload.request.LoginRequest;
import owie.lionel.owie.payload.request.SignupRequest;
import owie.lionel.owie.payload.response.JwtResponse;
import owie.lionel.owie.payload.response.MessageResponse;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/auth")
public class AuthController {


        @Autowired
        AuthorizationService authorizationService;

        @PostMapping("/login")
        public ResponseEntity<JwtResponse> authenticateUser(@RequestBody LoginRequest loginRequest) {
            return authorizationService.authenticateUser(loginRequest);
        }

        @PostMapping("/signup")
        public ResponseEntity<MessageResponse> registerUser(@RequestBody SignupRequest signUpRequest) {
            return authorizationService.registerUser(signUpRequest);
        }

    }


