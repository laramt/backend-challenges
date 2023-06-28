package com.project.AmeDigital.resources;

import com.project.AmeDigital.models.Planet;
import com.project.AmeDigital.services.PlanetService;

import lombok.RequiredArgsConstructor;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/planets")
@RequiredArgsConstructor
public class PlanetResource {

    private final PlanetService service;

    @PostMapping("/new")
    public ResponseEntity<Planet> insert(@RequestBody Planet planet){

        planet = service.insert(planet);

        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(planet.getId()).toUri();
        return ResponseEntity.created(uri).body(planet);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Planet>> findAll(){
        return ResponseEntity.ok().body(service.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Planet> findById(@PathVariable Long id){
        return ResponseEntity.ok().body(service.findById(id));
    }

    @GetMapping("/{name}")
    public ResponseEntity<Planet> findByName(@PathVariable String name){
        return ResponseEntity.ok().body(service.findByName(name));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

}
