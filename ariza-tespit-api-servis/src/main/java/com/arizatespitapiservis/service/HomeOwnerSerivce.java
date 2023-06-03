package com.arizatespitapiservis.service;


import com.arizatespitapiservis.enums.ApartmentBlockEnum;
import com.arizatespitapiservis.model.HomeOwner;
import com.arizatespitapiservis.repo.HomeOwnerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class HomeOwnerSerivce implements IHomeOwnerSerivce {

    private final HomeOwnerRepository homeOwnerRepository;


    @Override
    public List<HomeOwner> getAllHomeOwner() {
        return this.homeOwnerRepository.findAll();
    }

    @Override
    public Optional<HomeOwner> findAllByApartmentBlock(ApartmentBlockEnum apartmentBlockEnum) {
        return this.homeOwnerRepository.findAllByApartmentBlock(apartmentBlockEnum);
    }

    @Override
    public Optional<HomeOwner> findById(UUID id) {
        return this.homeOwnerRepository.findById(id);
    }

    @Override
    public HomeOwner findByPhoneNumber(String phoneNumber) {
        return this.homeOwnerRepository.findByPhoneNumber(phoneNumber);
    }
}
