package com.arizatespitapiservis.service;

import com.arizatespitapiservis.Security.JwtUser;
import com.arizatespitapiservis.Security.JwtUserFactory;
import com.arizatespitapiservis.Security.JwtUtil;
import com.arizatespitapiservis.controller.AuthenticationRequest;
import com.arizatespitapiservis.controller.AuthenticationResponse;
import com.arizatespitapiservis.dto.KullaniciDto;
import com.arizatespitapiservis.model.Kullanici;
import com.arizatespitapiservis.repo.KullaniciRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationService {

    private final KullaniciRepository kullaniciRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtUtil jwtUtil;
    private final AuthenticationManager authenticationManager;

    public AuthenticationResponse register(KullaniciDto kullanici) {

        var yeniKullanici = Kullanici.builder()
                .firstname(kullanici.getFirstname())
                .lastname(kullanici.getLastname())
                .password(passwordEncoder.encode(kullanici.getPassword()))
                .email(kullanici.getEmail())
                .Active(true)
                .build();
        kullaniciRepository.save(yeniKullanici);


        JwtUser jwtUser = JwtUserFactory.create(yeniKullanici);

        var jwt = jwtUtil.generateToken(jwtUser);
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

        var user = kullaniciRepository.findByEmail(request.getMail())
                .orElseThrow();
        JwtUser jwtUser = JwtUserFactory.create(user);
        var jwt = jwtUtil.generateToken(jwtUser);
        return AuthenticationResponse.builder()
                .tokken(jwt)
                .build();
    }
}
