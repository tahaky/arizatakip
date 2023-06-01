package com.arizatespitapiservis.Security;

import com.arizatespitapiservis.enums.EnumRoles;
import com.arizatespitapiservis.model.Kullanici;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public final class JwtUserFactory {



    public static JwtUser create(Kullanici kullanici) {
        return new JwtUser(
                kullanici.getId(),
                kullanici.getFirstname(),
                kullanici.getLastname(),
                kullanici.getEmail(),
                kullanici.getPassword(),
                kullanici.getActive(),
                kullanici.getPassword(),
                mapToGrantedAuthority(kullanici.getKullaniciRoles())

        );
    }

    private static List<GrantedAuthority> mapToGrantedAuthorities(List<EnumRoles> authorities) {
        return authorities.stream()
                .map(authority -> new SimpleGrantedAuthority(authority.name()))
                .collect(Collectors.toList());
    }

    private static List<GrantedAuthority> mapToGrantedAuthority(List<KullaniciRole> roleList) {
        List<GrantedAuthority> authorityList = new ArrayList<>();
        roleList.forEach(userRole -> authorityList.add(new SimpleGrantedAuthority(userRole.getRole().name())));
        return authorityList;
    }
}