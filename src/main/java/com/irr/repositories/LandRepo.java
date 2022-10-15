package com.irr.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.irr.model.Land;

@Repository
public interface LandRepo extends JpaRepository<Land, Long> {
	 Optional<Land> findByCode(String code);
	 
}
