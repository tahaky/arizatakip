package com.arizatespitapiservis.service;

import com.arizatespitapiservis.dto.HomeOwnerDTO;
import com.arizatespitapiservis.enums.BlockEnumApartment;
import com.arizatespitapiservis.model.HomeOwner;

import java.util.List;
import java.util.Optional;
import java.util.UUID;


public interface IHomeOwnerSerivce {

    List<HomeOwner> getAllHomeOwner();

    Optional<HomeOwner> findAllByApartmentBlock(BlockEnumApartment blockEnumApartment);

    Optional<HomeOwner> findById(UUID id);

    HomeOwner findByPhoneNumber(String phoneNumber);

    boolean delete(UUID id);

    void save(HomeOwnerDTO homeOwnerDTO);



}
