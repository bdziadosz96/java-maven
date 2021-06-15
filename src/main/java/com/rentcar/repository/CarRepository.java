package com.rentcar.repository;

import com.rentcar.model.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;


@RepositoryRestResource
public interface CarRepository extends JpaRepository<Car, Long> {
}
