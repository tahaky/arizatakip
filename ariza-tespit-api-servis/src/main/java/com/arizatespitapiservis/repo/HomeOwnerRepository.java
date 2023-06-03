package com.arizatespitapiservis.repo;

import com.arizatespitapiservis.enums.ApartmentBlockEnum;
import com.arizatespitapiservis.model.HomeOwner;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;


@Repository
public interface HomeOwnerRepository extends JpaRepository<HomeOwner, UUID> {

    Optional<HomeOwner> findById(UUID id);

    Optional<HomeOwner> findAllByApartmentBlock(ApartmentBlockEnum apartmentBlockEnum);

    HomeOwner findByPhoneNumber(String phoneNumber);


}
