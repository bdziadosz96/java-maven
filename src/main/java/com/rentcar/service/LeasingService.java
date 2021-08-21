package com.rentcar.service;

import com.rentcar.model.Leasing;
import com.rentcar.model.projection.LeasingWriteModel;
import com.rentcar.repository.LeasingRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.RequestScope;

import java.util.List;

@Service
@RequestScope
public class LeasingService {
    private LeasingRepository repository;

    LeasingService(final LeasingRepository repository) {
        this.repository = repository;
    }

    public Leasing createLeasing(LeasingWriteModel source) {
        if (source.getUser() == null) {
            throw new IllegalStateException("User is null");
        }
        else if (source.getDateFrom().isAfter(source.getDateTo())) {
            throw new IllegalArgumentException("Date's are incorrect");
        }
        return repository.save(source.toLeasing());
    }

    public List<Leasing> readAll() {
        return repository.findAll();
    }

    public void deleteLeasing(Long id) {
        repository.findById(id)
                        .orElseThrow(() -> new IllegalArgumentException("Id not found"));
        repository.deleteLeasingsById(id);
    }
}
