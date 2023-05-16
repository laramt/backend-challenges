package com.project.AmeDigital.models;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Entity
public class Planet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true, nullable = false)
    private String name;
    @Column(nullable = false)
    private String climate;
    @Column(nullable = false)
    private String terrain;
    private List<String> movies = new ArrayList<>();

    public Planet() {
    }

    public Planet(Long id, String name, String climate, String terrain) {
        this.id = id;
        this.name = name;
        this.climate = climate;
        this.terrain = terrain;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getClimate() {
        return climate;
    }

    public void setClimate(String climate) {
        this.climate = climate;
    }

    public String getTerrain() {
        return terrain;
    }

    public void setTerrain(String terrain) {
        this.terrain = terrain;
    }

    public void setMovies(List<String> movies) {
        this.movies = movies;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Planet planet)) return false;

        return getId() != null ? getId().equals(planet.getId()) : planet.getId() == null;
    }

    @Override
    public int hashCode() {
        return getId() != null ? getId().hashCode() : 0;
    }
}
