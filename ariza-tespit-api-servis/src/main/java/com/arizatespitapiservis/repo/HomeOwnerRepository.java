package com.arizatespitapiservis.repo;

import com.arizatespitapiservis.enums.BlockEnumApartment;
import com.arizatespitapiservis.model.HomeOwner;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;


@Repository
public interface HomeOwnerRepository extends JpaRepository<HomeOwner, UUID> {

    Optional<HomeOwner> findById(UUID id);

    Optional<HomeOwner> findAllByApartmentBlock(BlockEnumApartment blockEnumApartment);

    HomeOwner findByPhoneNumber(String phoneNumber);

    void deleteById(UUID id);

}
