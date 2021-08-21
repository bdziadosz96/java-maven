package com.rentcar.controller;

import com.rentcar.model.Car;
import com.rentcar.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.net.URI;
import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

@RestController
public class CarController {
    private static final Logger logger = Logger.getLogger(CarController.class.getName());
    private final CarRepository repository;


    @Autowired
    public CarController(final CarRepository repository) {
        this.repository = repository;
    }

    @GetMapping(value = "/cars", params = {"!sort", "!page", "!size"})
    ResponseEntity<List<Car>> readAllCars() {
        logger.warning("Exposing all the cars");
        return ResponseEntity.ok(repository.findAll());
    }

    @GetMapping("/cars")
    Page<Car> readAllCars(Pageable page) {
        logger.info("Finding all cars by pageable");
        return repository.findAll(page);
    }

    @GetMapping("/cars/{id}")
    ResponseEntity<?> readCarById(@PathVariable Long id) {
        logger.warning("Reading car by " + id);
        Optional<Car> carByID = repository.findCarById(id);
        return carByID
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @Transactional
    @PutMapping("/cars/{id}")
    ResponseEntity<?> updateCar(@PathVariable Long id, @RequestBody @Valid Car toUpdate) {
        logger.info("PUT : Update car " + id + " with " + toUpdate.toString());
        return findCarById(id, toUpdate);
    }

    @PatchMapping("/cars/{id}")
    ResponseEntity<?> updateCarByPatch(@PathVariable Long id, @RequestBody @Valid Car toUpdate) {
        logger.info("PATCH : Update car " + id + " with " + toUpdate.toString());
        return findCarById(id, toUpdate);
    }

    private ResponseEntity<?> findCarById(@PathVariable final Long id, @RequestBody final @Valid Car toUpdate) {
        if (!repository.existsById(id)) {
            return new ResponseEntity<>("ID not found", HttpStatus.NOT_FOUND);
        }
        repository.findCarById(id)
                .ifPresent(car -> {
                    car.updateFrom(toUpdate);
                    repository.save(car);
                });
        return ResponseEntity.ok().build();
    }

    @Transactional
    @PostMapping("/cars")
    ResponseEntity<Car> addCar(@RequestBody @Valid Car toAdd) {
        logger.warning("Add new car to database");
        Car save = repository.save(toAdd);
        return ResponseEntity.created(URI.create("/" + save.getId())).body(save);
    }

}

