package com.arizatespitapiservis.repo;

import com.arizatespitapiservis.model.Kullanici;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface KullaniciRepository extends JpaRepository<Kullanici, UUID> {
    Optional<Kullanici> findByEmail(String email);


}
