package com.example.watermyplants.repositories;

import com.example.watermyplants.models.Plant;
import org.springframework.data.repository.CrudRepository;

public interface PlantRepository extends CrudRepository<Plant, Long> {

}
