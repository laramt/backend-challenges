package com.project.AmeDigital.resources;

import com.project.AmeDigital.models.Planet;
import com.project.AmeDigital.services.PlanetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/planets")
public class PlanetResource {

    @Autowired
    PlanetService service;

    @PostMapping("/new-planet")
    public ResponseEntity<Planet> insert(@RequestBody Planet planet){

        planet = service.insert(planet);

        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(planet.getId()).toUri();
        return ResponseEntity.created(uri).body(planet);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Planet>> findAll(){

        List<Planet> list = service.findAll();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Planet> findById(@PathVariable Long id){

        Planet planet = service.findById(id);
        return ResponseEntity.ok().body(planet);
    }

    @GetMapping("/{name}")
    public ResponseEntity<Planet> findByName(@PathVariable String name){

        Planet planet = service.findByName(name);
        return ResponseEntity.ok().body(planet);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){

        service.delete(id);
        return ResponseEntity.noContent().build();
    }

}
