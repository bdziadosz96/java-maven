package com.rentcar.repository;

import com.rentcar.model.Leasing;

import java.util.List;
import java.util.Optional;

public interface LeasingRepository {
    boolean existsLeasingByCarsNotNullAndAndId(Long id);

    List<Leasing> findAll();

    Optional<Leasing> findById(Long id);

    Leasing save(Leasing entity);

    void deleteLeasingsById(Long id);
}
