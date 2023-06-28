package com.project.AmeDigital.resources;

import com.project.AmeDigital.models.Planet;
import com.project.AmeDigital.services.PlanetService;

import lombok.RequiredArgsConstructor;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/planets")
@RequiredArgsConstructor
public class PlanetResource {

    private final PlanetService service;

    @PostMapping("/")
    public ResponseEntity<Planet> insert(@RequestBody Planet planet){
        return ResponseEntity.created(null).body(service.insert(planet));
    }

    @GetMapping("/")
    public ResponseEntity<List<Planet>> findAll(){
        return ResponseEntity.ok().body(service.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Planet> findById(@PathVariable Long id){
        return ResponseEntity.ok().body(service.findById(id));
    }

    @GetMapping("/")
    public ResponseEntity<Planet> findByName(@RequestParam String name){
        return ResponseEntity.ok().body(service.findByName(name));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

}
