package com.arizatespitapiservis.model;

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
@Table(name = "person")
public class Person extends BaseModel {
    private String firstname;
    private String lastname;
    private String email;
    private String password;
    private Boolean Active;
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    @JoinColumn(foreignKey = @ForeignKey(name = "person_role_fk1"), referencedColumnName = "id", name = "person_id")
    private List<PersonRole> personRoles;


}