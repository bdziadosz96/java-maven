package com.rentcar.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.time.LocalDate;
import java.util.Set;

@Entity
@Table(name = "leasings")
public class Leasing {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @NotBlank
    private Long id;

    @NotBlank(message = "date cannot be empty")
    private LocalDate dateFrom;

    @NotBlank(message = "date cannot be empty")
    private LocalDate dateTo;

    @OneToMany(mappedBy = "leasing")
    private Set<Car> cars;

    @OneToOne()
    @JoinColumn(name = "users_id")
    private User user;

    public Leasing() {
    }

    public Leasing(final LocalDate dateFrom, final LocalDate dateTo, final Set<Car> cars, final User user) {
        this.dateFrom = dateFrom;
        this.dateTo = dateTo;
        this.cars = cars;
        this.user = user;
    }

    public LocalDate getDateFrom() {
        return dateFrom;
    }

    public void setDateFrom(final LocalDate dateFrom) {
        this.dateFrom = dateFrom;
    }

    public User getUser() {
        return user;
    }

    void setUser(final User user) {
        this.user = user;
    }

    public LocalDate getDateTo() {
        return dateTo;
    }

    public void setDateTo(final LocalDate dateTo) {
        this.dateTo = dateTo;
    }

    public Set<Car> getCars() {
        return cars;
    }

    public void setCars(final Set<Car> cars) {
        this.cars = cars;
    }
}
