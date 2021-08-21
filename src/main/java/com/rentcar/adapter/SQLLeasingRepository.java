package com.rentcar.adapter;

import com.rentcar.model.Leasing;
import com.rentcar.repository.LeasingRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SQLLeasingRepository extends LeasingRepository, JpaRepository<Leasing,Long> {
    @Override
    void deleteLeasingsById(Long id);
}
