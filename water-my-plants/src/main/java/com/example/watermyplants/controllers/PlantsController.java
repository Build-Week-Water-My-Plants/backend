package com.example.watermyplants.controllers;

import com.example.watermyplants.models.Plant;
import com.example.watermyplants.services.PlantService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@RestController
@RequestMapping("/plants")
public class PlantsController
{
    private static final Logger logger = LoggerFactory.getLogger(RolesController.class);

    @Autowired
    PlantService plantService;

    @GetMapping(value = "/plants",
            produces = {"application/json"})
    public ResponseEntity<?> listAllPlants(HttpServletRequest request)
    {
        logger.trace(request.getMethod().toUpperCase() + " " + request.getRequestURI() + " accessed");

        List<Plant> allPlants = plantService.findAll();
        return new ResponseEntity<>(allPlants, HttpStatus.OK);
    }


    @GetMapping(value = "/plant/{plantId}",
            produces = {"application/json"})
    public ResponseEntity<?> getPlant(HttpServletRequest request,
                                      @PathVariable
                                              Long plantId)
    {
        logger.trace(request.getMethod().toUpperCase() + " " + request.getRequestURI() + " accessed");

        Plant p = plantService.findPlantById(plantId);
        return new ResponseEntity<>(p, HttpStatus.OK);
    }


    @GetMapping(value = "/userName/{userName}",
            produces = {"application/json"})
    public ResponseEntity<?> findPlantByUserName(HttpServletRequest request,
                                                 @PathVariable
                                                         String userName)
    {
        logger.trace(request.getMethod().toUpperCase() + " " + request.getRequestURI() + " accessed");

        List<Plant> thePlants = plantService.findByUserName(userName);
        return new ResponseEntity<>(thePlants, HttpStatus.OK);
    }


    @PostMapping(value = "/plant")
    public ResponseEntity<?> addNewPlant(HttpServletRequest request, @Valid
    @RequestBody
            Plant newPlant) throws URISyntaxException
    {
        logger.trace(request.getMethod().toUpperCase() + " " + request.getRequestURI() + " accessed");

        newPlant = plantService.save(newPlant);

        // set the location header for the newly created resource
        HttpHeaders responseHeaders = new HttpHeaders();
        URI newPlantURI = ServletUriComponentsBuilder.fromCurrentRequest().path("/{plantid}").buildAndExpand(newPlant.getPlantid()).toUri();
        responseHeaders.setLocation(newPlantURI);

        return new ResponseEntity<>(null, responseHeaders, HttpStatus.CREATED);
    }


    @DeleteMapping("/plant/{id}")
    public ResponseEntity<?> deletePlantById(HttpServletRequest request,
                                             @PathVariable
                                                     long id)
    {
        logger.trace(request.getMethod().toUpperCase() + " " + request.getRequestURI() + " accessed");

        plantService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}