package com.arizatespitapiservis.model;

import com.arizatespitapiservis.enums.EnumRoles;
import jakarta.persistence.*;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;


@Data
@Entity
@Table(name = "kullanıcı_role")
public class KullaniciRole extends BaseModel{

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "kullanici_id", nullable = false)
    private Kullanici kullanici;

    @Column(name = "role", nullable = false, length = 50)
    @Enumerated(EnumType.STRING)
    private EnumRoles role;
}
