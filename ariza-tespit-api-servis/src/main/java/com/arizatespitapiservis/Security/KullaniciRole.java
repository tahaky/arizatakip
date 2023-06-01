package com.arizatespitapiservis.Security;

import com.arizatespitapiservis.enums.EnumRoles;
import com.arizatespitapiservis.model.BaseModel;
import com.arizatespitapiservis.model.Kullanici;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "kullanici_role")
public @Data
class KullaniciRole extends BaseModel {


    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "kullanici_id", nullable = false)
    private Kullanici kullanici;

    @Column(name = "kullanici_role", nullable = false, length = 50)
    @Enumerated(EnumType.STRING)
    private EnumRoles role;
}