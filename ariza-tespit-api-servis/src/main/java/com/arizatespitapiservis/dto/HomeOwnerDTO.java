package com.arizatespitapiservis.dto;

import com.arizatespitapiservis.enums.BlockEnumApartment;
import com.arizatespitapiservis.enums.EnumGender;
import lombok.*;

@Data
@RequiredArgsConstructor
public class HomeOwnerDTO {

    private String password;
    private String firstname;
    private String lastname;
    private String phoneNumber;
    private EnumGender gender;
    private BlockEnumApartment apartmentBlock;
    private String apartmentNumber;


}
