package com.rentcar.controller;

import com.rentcar.model.Car;
import com.rentcar.model.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

@Controller
public class CarController {
    private static final Logger logger = Logger.getLogger(CarController.class.getName());
    private final CarRepository repository;

    @Autowired
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

    @GetMapping("/cars/{id}")
    ResponseEntity<?> readCarById(@PathVariable Long id) {
        Optional<Car> carByID = repository.findCarById(id);
        return carByID
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping("/cars/{id}")
    ResponseEntity <?> updateCar(@PathVariable Long id, @RequestBody @Valid Car toUpdate) {
        if (!repository.existsById(id)) {
            return new ResponseEntity<>("ID not found", HttpStatus.NOT_FOUND);
        }
        toUpdate.setId(id);
        Car save = repository.save(toUpdate);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/cars")
    ResponseEntity <Car> addCar(@RequestBody @Valid Car toAdd) {
        Car save = repository.save(toAdd);
        return ResponseEntity.created(URI.create("/" + save.getId())).body(save);
    }



}
