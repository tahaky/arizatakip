package com.arizatespitapiservis.service;

import com.arizatespitapiservis.Security.JwtUser;
import com.arizatespitapiservis.Security.JwtUserFactory;
import com.arizatespitapiservis.Security.JwtUtil;
import com.arizatespitapiservis.Security.AuthenticationUtils.AuthenticationRequest;
import com.arizatespitapiservis.Security.AuthenticationUtils.AuthenticationResponse;
import com.arizatespitapiservis.dto.PersonDto;
import com.arizatespitapiservis.model.Person;
import com.arizatespitapiservis.repo.PersonRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationService {

    private final PersonRepository personRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtUtil jwtUtil;
    private final AuthenticationManager authenticationManager;

    public AuthenticationResponse register(PersonDto kullanici) {

        var newPerson = Person.builder()
                .firstname(kullanici.getFirstname())
                .lastname(kullanici.getLastname())
                .password(passwordEncoder.encode(kullanici.getPassword()))
                .email(kullanici.getEmail())
                .Active(true)
                .build();
        personRepository.save(newPerson);


        JwtUser jwtUser = JwtUserFactory.create(newPerson);

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

        var user = personRepository.findByEmail(request.getMail())
                .orElseThrow();
        JwtUser jwtUser = JwtUserFactory.create(user);
        var jwt = jwtUtil.generateToken(jwtUser);
        return AuthenticationResponse.builder()
                .tokken(jwt)
                .build();
    }
}
