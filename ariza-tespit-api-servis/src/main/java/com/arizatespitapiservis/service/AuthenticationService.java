package com.arizatespitapiservis.service;

import com.arizatespitapiservis.Security.JwtUtil;
import com.arizatespitapiservis.controller.AuthenticationRequest;
import com.arizatespitapiservis.controller.AuthenticationResponse;
import com.arizatespitapiservis.dto.KullaniciDto;
import com.arizatespitapiservis.enums.EnumRoles;
import com.arizatespitapiservis.model.User;
import com.arizatespitapiservis.repo.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtUtil jwtUtil;
    private final AuthenticationManager authenticationManager;

    public AuthenticationResponse register(KullaniciDto kullanici) {

        var yeniKullanici = User.builder()
                .username(kullanici.getUserName())
                .password(passwordEncoder.encode(kullanici.getPassword()))
                .mail(kullanici.getMail())
                .role(EnumRoles.ADMIN)
                .build();
        System.out.println(yeniKullanici.getId() + yeniKullanici.getUsername() + yeniKullanici.getAuthorities());
        userRepository.save(yeniKullanici);
        var jwt = jwtUtil.generateToken(yeniKullanici);
        return AuthenticationResponse.builder()
                .tokken(jwt)
                .build();
    }

    public AuthenticationResponse authenticate(AuthenticationRequest request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getMail(),
                        request.getPassword()
                )
        );
        var user = userRepository.findByMail(request.getMail())
                .orElseThrow();
        var jwt = jwtUtil.generateToken(user);

        return AuthenticationResponse.builder()
                .tokken(jwt)
                .build();
    }
}
