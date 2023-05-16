package com.project.AmeDigital.repositories;

import com.project.AmeDigital.models.Planet;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlanetRepository extends JpaRepository<Planet, Long> {
    Optional findByName(String name);
}
