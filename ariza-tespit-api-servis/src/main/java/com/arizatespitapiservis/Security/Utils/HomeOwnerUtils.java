package com.arizatespitapiservis.Security.Utils;

import com.arizatespitapiservis.dto.HomeOwnerDTO;
import org.springframework.stereotype.Component;

@Component
public class HomeOwnerUtils {


    public String generateLoginId(HomeOwnerDTO homeOwnerDTO) {
        return homeOwnerDTO.getFirstname() +
                homeOwnerDTO.getLastname() +
                homeOwnerDTO.getApartmentBlock() +
                homeOwnerDTO.getApartmentNumber();
    }
}
