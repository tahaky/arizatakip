package com.arizatespitapiservis.model;


import com.arizatespitapiservis.enums.BlockEnumApartment;
import com.arizatespitapiservis.enums.EnumGender;
import jakarta.persistence.*;
import lombok.*;


@Entity
@NoArgsConstructor
@Data
@Table(name = "home_owner")
public class HomeOwner extends BaseKisi {

    public HomeOwner(String loginId, String password, String firstname, String lastname, String phoneNumber, EnumGender gender, BlockEnumApartment apartmentBlock, String apartmentNumber) {
        super(loginId, password, firstname, lastname, phoneNumber, gender);
        this.apartmentBlock = apartmentBlock;
        this.apartmentNumber = apartmentNumber;
    }

    @Column(name = "apartment_block", nullable = false)
    @Enumerated(EnumType.STRING)
    private BlockEnumApartment apartmentBlock;

    @Column(name = "apartment_number", nullable = false)
    private String apartmentNumber;


}
