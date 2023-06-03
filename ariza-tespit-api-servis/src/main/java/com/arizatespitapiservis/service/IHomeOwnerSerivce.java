package com.arizatespitapiservis.service;

import com.arizatespitapiservis.dto.HomeOwnerDTO;
import com.arizatespitapiservis.enums.ApartmentBlockEnum;
import com.arizatespitapiservis.model.HomeOwner;

import java.util.List;
import java.util.Optional;
import java.util.UUID;


public interface IHomeOwnerSerivce {

    List<HomeOwner> getAllHomeOwner();

    Optional<HomeOwner> findAllByApartmentBlock(ApartmentBlockEnum apartmentBlockEnum);

    Optional<HomeOwner> findById(UUID id);

    HomeOwner findByPhoneNumber(String phoneNumber);

    void delete(UUID id);

    void save(HomeOwnerDTO homeOwnerDTO);



}
