package com.arizatespitapiservis.dto;


import com.arizatespitapiservis.enums.EnumRoles;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class KullaniciDto {

    private String userName;
    private String password;
    private String mail;
}
