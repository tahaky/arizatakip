package com.arizatespitapiservis.controller;


import com.arizatespitapiservis.dto.KullaniciDto;
import com.arizatespitapiservis.service.AuthenticationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class AuthenticationController {

    private final AuthenticationService authenticationService;

    @PostMapping("/register")
    public ResponseEntity<AuthenticationResponse> register(@RequestBody KullaniciDto kullanici) {
        return ResponseEntity.ok(authenticationService.register(kullanici));
    }

    @PostMapping("/auth")
    public ResponseEntity<AuthenticationResponse> AuthenticationRequest(@RequestBody AuthenticationRequest request) {
        return ResponseEntity.ok(authenticationService.authenticate(request));
    }


}
