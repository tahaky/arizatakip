package com.arizatespitapiservis.dto;


import com.arizatespitapiservis.Security.KullaniciRole;
import com.arizatespitapiservis.enums.EnumRoles;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class KullaniciDto {

    private String firstname;
    private String lastname;
    private String email;
    private String password;

}
