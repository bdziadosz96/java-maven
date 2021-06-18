package com.rentcar.repository;

import com.rentcar.model.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.Description;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;


@RepositoryRestResource(path = "cars")
public interface CarRepository extends JpaRepository<Car, Long> {

    @Override
    @RestResource(exported = false)
    void deleteById(Long id);

    @Override
    @RestResource(exported = false)
    void delete(Car car);

    @RestResource(path = "find", rel = "find")
    List<Car> findCarById(@Param("id") Long id);
}

