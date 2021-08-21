package com.rentcar.adapter;

import com.rentcar.model.Car;
import com.rentcar.repository.CarRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface SQLCarRepository extends CarRepository, JpaRepository<Car, Long> {

}

