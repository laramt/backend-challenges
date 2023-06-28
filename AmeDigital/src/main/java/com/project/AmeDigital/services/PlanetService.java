package com.project.AmeDigital.services;

import com.project.AmeDigital.models.Planet;
import com.project.AmeDigital.repositories.PlanetRepository;

import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PlanetService {

    private final PlanetRepository repository;

    public Planet insert (Planet planet){
        return repository.save(planet);
    }

    public List<Planet> findAll(){
       return repository.findAll();
    }

    public Planet findById(Long id){
        Planet planet = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Planet with id " + id + "not found."));
        return planet;
    }

    public Planet findByName(String name){
        Planet planet = repository.findByName(name);
        return planet;
    }

    public void delete(Long id){
        repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Planet with id " + id + "not found."));
        repository.deleteById(id);
    }

    public Planet update(Long id, Planet planet){
         Planet entity = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Planet with id " + id + "not found."));

        entity.setName(planet.getName());
        entity.setTerrain(planet.getTerrain());
        entity.setClimate(planet.getClimate());

        return repository.save(entity);
    }

}
