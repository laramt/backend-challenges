package com.project.AmeDigital.services;

import com.project.AmeDigital.models.Planet;
import com.project.AmeDigital.repositories.PlanetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PlanetService {

    @Autowired
    PlanetRepository repository;

    public Planet insert (Planet planet){
        return repository.save(planet);
    }

    public List<Planet> findAll(){
       return repository.findAll();
    }

    public Planet findById(Long id){
        Optional<Planet> optional = repository.findById(id);
        Planet planet = optional.orElseThrow(
                () -> new RuntimeException("Planet with id " + id + "not found."));
        return planet;
    }

    public Planet findByName(String name){
        Optional<Planet> optional = repository.findByName(name);
        Planet planet = optional.orElseThrow(
                () -> new RuntimeException("Planet with name " + name + "not found."));
        return planet;
    }

    public void delete(Long id){
        Optional<Planet> optional = repository.findById(id);
        Planet planet = optional.orElseThrow(
                () -> new RuntimeException("Planet with id " + id + "not found."));
        repository.deleteById(id);
    }

    public Planet update(Long id, Planet planet){
        Optional<Planet> optional = repository.findById(id);
        Planet entity = optional.orElseThrow(
                () -> new RuntimeException("Planet with id " + id + "not found."));

        entity.setName(planet.getName());
        entity.setTerrain(planet.getTerrain());
        entity.setClimate(planet.getClimate());

        return repository.save(entity);
    }

}
