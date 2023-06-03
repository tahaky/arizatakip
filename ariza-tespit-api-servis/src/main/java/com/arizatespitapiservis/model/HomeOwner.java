package com.arizatespitapiservis.model;


import com.arizatespitapiservis.enums.ApartmentBlockEnum;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "home_owner")
public class HomeOwner extends BaseKisi {

    @Column(name = "apartment_block" ,nullable = false)
    @Enumerated(EnumType.STRING)
    private ApartmentBlockEnum apartmentBlock;

    @Column(name = "apartment_number",nullable = false)
    private String apartmentNumber;






}
