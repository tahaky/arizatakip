package com.arizatespitapiservis.controller;

import com.arizatespitapiservis.dto.HomeOwnerDTO;
import com.arizatespitapiservis.enums.ApartmentBlockEnum;
import com.arizatespitapiservis.model.HomeOwner;
import com.arizatespitapiservis.service.HomeOwnerSerivce;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/homeowner")
@RequiredArgsConstructor
public class HomeOwnerController {

    private final HomeOwnerSerivce homeOwnerSerivce;


    @GetMapping("/")
    public List<HomeOwner> getAllHomeOwner() {
        return this.homeOwnerSerivce.getAllHomeOwner();
    }

    @PostMapping("/")
    public void save(@RequestBody HomeOwnerDTO homeOwnerDTO) {
        this.homeOwnerSerivce.save(homeOwnerDTO);

    }


    @GetMapping("/block")
    public List<UUID> findAllByApartmentBlock(@RequestParam(name = "blockName") String apartmentBlockEnum) {
        return findAllByApartmentBlock(apartmentBlockEnum);
    }


    @GetMapping("/byid")
    public Optional<HomeOwner> findById(@RequestParam(name = "id") UUID id) {
        return this.homeOwnerSerivce.findById(id);
    }


    @GetMapping("/byphone")
    public HomeOwner findByPhoneNumber(@RequestParam(name = "number") String phoneNumber) {
        return this.homeOwnerSerivce.findByPhoneNumber(phoneNumber);
    }


}
