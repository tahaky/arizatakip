package com.arizatespitapiservis.model;


import jakarta.persistence.*;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;
import java.util.List;

@Entity

@Table(name = "kullanici")
public @Data
class Kullanici extends BaseModel implements Serializable {


    @Serial
    private static final long serialVersionUID = -3398406361887750293L;


    @Column(name = "kullanici_kodu", unique = true, updatable = false, length = 50)
    private String kullaniciKodu;

    @Column(name = "kullanici_adi", nullable = false, length = 155)
    private String kullaniciAdi;

    @Column(name = "sifre")
    private String sifre;

    @Column(name = "mail", nullable = false, unique = true, length = 100)
    private String mail;

    @Column(name = "active")
    private boolean isActive;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    @JoinColumn(foreignKey = @ForeignKey(name = "kullanici_role_fk1"), referencedColumnName = "id", name = "kullanici_id")
    private List<KullaniciRole> roles;

}
