package com.arizatespitapiservis.model;


import com.arizatespitapiservis.enums.EnumGender;
import jakarta.persistence.*;
import lombok.Data;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;


@Data
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public class BaseKisi extends BaseModel{


    @Column(name = "login_id", nullable = false, length = 250)
    private String loginId;

    @Column(name = "password", nullable = false, length = 150)
    private String password;

    @Column(name = "first_name", nullable = false, length = 50)
    private String firstname;

    @Column(name = "last_name", nullable = false, length = 50)
    private String lastname;

    @Column(name = "phone_number", nullable = false, length = 50)
    private String phoneNumber;

    @Enumerated(EnumType.STRING)
    @Column(name = "gender",nullable = false)
    private EnumGender gender;

}
