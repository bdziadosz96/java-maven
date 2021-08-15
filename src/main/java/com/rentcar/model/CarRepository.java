package com.rentcar.model;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface CarRepository {
    List<Car> findAll();

    Page<Car> findAll(Pageable page);

    boolean existsById(Long id);

    Optional<Car> findCarByName(String carName);

    Optional<Car> findCarById(Long id);

    Optional<Car> findCarByModel(String modelName);

    Car save(Car carToSave);

}
