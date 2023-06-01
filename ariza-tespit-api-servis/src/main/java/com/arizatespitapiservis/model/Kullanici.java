package com.arizatespitapiservis.model;

import com.arizatespitapiservis.Security.KullaniciRole;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "kullanici")
public class Kullanici extends BaseModel {


    private String firstname;
    private String lastname;
    private String email;
    private String password;
    private Boolean Active;
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    @JoinColumn(foreignKey = @ForeignKey(name = "kullanici_role_fk1"), referencedColumnName = "id", name = "kullanici_id")
    private List<KullaniciRole> kullaniciRoles;


}