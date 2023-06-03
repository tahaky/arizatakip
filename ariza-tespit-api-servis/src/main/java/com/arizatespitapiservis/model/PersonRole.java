package com.arizatespitapiservis.model;

import com.arizatespitapiservis.enums.EnumRoles;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "person_role")
public @Data
class PersonRole extends BaseModel {


    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "person_id", nullable = false)
    private Person person;

    @Column(name = "role_name", nullable = false, length = 50)
    @Enumerated(EnumType.STRING)
    private EnumRoles role;
}