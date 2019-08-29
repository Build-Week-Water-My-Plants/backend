package com.example.watermyplants.services;

import com.example.watermyplants.models.Plant;
import org.springframework.security.core.Authentication;

import java.util.List;

public interface PlantService {

    List<Plant> findAll();

    Plant findPlantById(long id);

    List<Plant> findByUserName(String username);

    void delete(long id);

    Plant save(Plant plant, Authentication authentication);

}
