package com.project.AmeDigital.dtos;


import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SwapiResponse {

    @JsonProperty("results")
    private List<PlanetResult> results = new ArrayList<>();

}
