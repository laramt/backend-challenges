package com.project.AmeDigital.services;

import com.project.AmeDigital.dtos.SwapiResponse;
import com.project.AmeDigital.dtos.PlanetResult;
import com.project.AmeDigital.models.Planet;
import com.project.AmeDigital.repositories.PlanetRepository;

import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PlanetService {

    private final PlanetRepository repository;

    public Planet insert(Planet planet){
       planet.setFilmCount(getFilmCount(planet.getName()));
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

    public int getFilmCount(String planetName) {
        RestTemplate restTemplate = new RestTemplate();
        String planetUrl = "https://swapi.dev/api/planets/?search=" + planetName;
        SwapiResponse swapiResponse = restTemplate.getForObject(planetUrl, SwapiResponse.class);

        if (swapiResponse != null && !swapiResponse.getResults().isEmpty()) {
            List<PlanetResult> planetResults = swapiResponse.getResults();
            int filmCount = 0;

            for (PlanetResult planetResult : planetResults) {
                List<String> filmUrls = planetResult.getFilms();
                filmCount += filmUrls.size();
            }

        return filmCount;
    }

    return 0;

}


}
