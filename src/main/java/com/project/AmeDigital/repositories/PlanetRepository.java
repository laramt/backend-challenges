package com.project.AmeDigital.repositories;

import com.project.AmeDigital.models.Planet;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlanetRepository extends JpaRepository<Planet, Long> {
    Planet findByName(String name);
}
