package com.rentcar.controller;

import com.rentcar.model.Car;
import com.rentcar.model.CarRepository;
import com.rentcar.model.SQLCarRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.logging.Logger;

@RestController
public class CarController {
    private static final Logger logger = Logger.getLogger(CarController.class.getName());
    private final CarRepository repository;

    public CarController(final CarRepository repository) {
        this.repository = repository;
    }

    @GetMapping(value = "/cars", params = {"!sort", "!page", "!size"})
    ResponseEntity<List<Car>> readAllCars() {
        logger.warning("Finding all cars");
        return ResponseEntity.ok(repository.findAll());
    }

    @GetMapping("/cars")
    Page<Car> readAllCars(Pageable page) {
        logger.info("Finding all cars by pageable");
        return repository.findAll(page);
    }


}
