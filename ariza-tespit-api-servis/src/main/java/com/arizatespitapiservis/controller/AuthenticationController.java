package com.arizatespitapiservis.controller;


import com.arizatespitapiservis.Security.AuthenticationUtils.AuthenticationRequest;
import com.arizatespitapiservis.Security.AuthenticationUtils.AuthenticationResponse;
import com.arizatespitapiservis.dto.PersonDTO;
import com.arizatespitapiservis.service.AuthenticationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthenticationController {

    private final AuthenticationService authenticationService;

    @PostMapping("/register")
    public ResponseEntity<AuthenticationResponse> register(@RequestBody PersonDTO personDto) {
        return ResponseEntity.ok(authenticationService.register(personDto));
    }

    @PostMapping("/login")
    public ResponseEntity<AuthenticationResponse> AuthenticationRequest(@RequestBody AuthenticationRequest request) {
        return ResponseEntity.ok(authenticationService.authenticate(request));
    }


}
