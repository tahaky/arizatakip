package com.arizatespitapiservis.service;

import com.arizatespitapiservis.enums.ApartmentBlockEnum;
import com.arizatespitapiservis.model.HomeOwner;

import java.util.List;
import java.util.Optional;
import java.util.UUID;


public interface IHomeOwnerSerivce {

    public List<HomeOwner> getAllHomeOwner();
    public  Optional<HomeOwner> findAllByApartmentBlock(ApartmentBlockEnum apartmentBlockEnum);
    public Optional<HomeOwner> findById(UUID id);
    public  HomeOwner findByPhoneNumber(String phoneNumber);



}
