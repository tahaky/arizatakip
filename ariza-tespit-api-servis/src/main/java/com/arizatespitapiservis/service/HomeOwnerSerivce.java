package com.arizatespitapiservis.service;


import com.arizatespitapiservis.Security.Utils.HomeOwnerUtils;
import com.arizatespitapiservis.dto.HomeOwnerDTO;
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
    private final HomeOwnerUtils homeOwnerUtils;

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

    @Override
    public void delete(UUID id) {
        this.homeOwnerRepository.deleteById(id);
    }

    @Override
    public void save(HomeOwnerDTO homeOwnerDTO) {

        HomeOwner newHomeOwner = new HomeOwner(
                homeOwnerUtils.generateLoginId(homeOwnerDTO),
                homeOwnerDTO.getPassword(),
                homeOwnerDTO.getFirstname(),
                homeOwnerDTO.getLastname(),
                homeOwnerDTO.getPhoneNumber(),
                homeOwnerDTO.getGender(),
                homeOwnerDTO.getApartmentBlock(),
                homeOwnerDTO.getApartmentNumber()
        );
        this.homeOwnerRepository.save(newHomeOwner);
    }

}
