package com.arizatespitapiservis.Security;

import com.arizatespitapiservis.enums.EnumRoles;
import com.arizatespitapiservis.model.Person;
import com.arizatespitapiservis.model.PersonRole;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public final class JwtUserFactory {



    public static JwtUser create(Person person) {
        return new JwtUser(
                person.getId(),
                person.getFirstname(),
                person.getLastname(),
                person.getEmail(),
                person.getPassword(),
                person.getActive(),
                person.getPassword(),
                mapToGrantedAuthority(person.getPersonRoles())

        );
    }

    private static List<GrantedAuthority> mapToGrantedAuthorities(List<EnumRoles> authorities) {
        return authorities.stream()
                .map(authority -> new SimpleGrantedAuthority(authority.name()))
                .collect(Collectors.toList());
    }

    private static List<GrantedAuthority> mapToGrantedAuthority(List<PersonRole> roleList) {
        List<GrantedAuthority> authorityList = new ArrayList<>();
        roleList.forEach(userRole -> authorityList.add(new SimpleGrantedAuthority(userRole.getRole().name())));
        return authorityList;
    }
}