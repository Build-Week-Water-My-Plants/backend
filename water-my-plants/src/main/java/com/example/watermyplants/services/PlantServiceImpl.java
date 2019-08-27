package com.example.watermyplants.services;


import com.example.watermyplants.exceptions.ResourceNotFoundException;
import com.example.watermyplants.models.Plant;
import com.example.watermyplants.repositories.PlantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service(value = "plantService")
public class PlantServiceImpl implements PlantService{

    @Autowired
    private PlantRepository plantRepository;

    @Override
    public List<Plant> findAll() {
        List<Plant> list = new ArrayList<>();
        plantRepository.findAll().iterator().forEachRemaining((list::add));
        return list;
    }

    @Override
    public Plant findPlantById(long id)
    {
        return plantRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(Long.toString(id)));
    }

    @Override
    public void delete(long id)
    {
        if (plantRepository.findById(id).isPresent())
        {
            Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
            if (plantRepository.findById(id).get().getUser().getUsername().equalsIgnoreCase(authentication.getName()))
            {
                plantRepository.deleteById(id);
            } else
            {
                throw new ResourceNotFoundException(id + " " + authentication.getName());
            }
        } else
        {
            throw new ResourceNotFoundException(Long.toString(id));
        }
    }

    @Transactional
    @Override
    public Plant save(Plant plant)
    {
        return plantRepository.save(plant);
    }

    @Override
    public List<Plant> findByUserName(String username)
    {
        List<Plant> list = new ArrayList<>();
        plantRepository.findAll().iterator().forEachRemaining(list::add);

        list.removeIf(q -> !q.getUser().getUsername().equalsIgnoreCase(username));
        return list;
    }
}
