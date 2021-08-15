package com.rentcar.model;

import javax.persistence.Embeddable;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import java.time.LocalDateTime;

@Embeddable
public class Audit {
    private LocalDateTime updateOn;
    private LocalDateTime createdOn;
    @PrePersist
    public void getCreatedOn() {
        createdOn = LocalDateTime.now();
    }

    @PreUpdate
    public void update() {
        updateOn = LocalDateTime.now();
    }
}
