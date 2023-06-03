package com.arizatespitapiservis.dto;

import com.arizatespitapiservis.enums.ApartmentBlockEnum;
import com.arizatespitapiservis.enums.EnumGender;
import com.arizatespitapiservis.model.BaseKisi;
import lombok.*;

import java.util.UUID;

@Data
@RequiredArgsConstructor
public class HomeOwnerDTO {

    private String password;
    private String firstname;
    private String lastname;
    private String phoneNumber;
    private EnumGender gender;
    private ApartmentBlockEnum apartmentBlock;
    private String apartmentNumber;


}
