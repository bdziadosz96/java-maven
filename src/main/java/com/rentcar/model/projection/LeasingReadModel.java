package com.rentcar.model.projection;

import com.rentcar.model.Car;
import com.rentcar.model.Leasing;
import com.rentcar.model.User;

import java.time.LocalDate;
import java.util.Set;

public class LeasingReadModel {
    private LocalDate dateFrom;
    private LocalDate dateTo;
    private Set<Car> cars;
    private User user;

    public LeasingReadModel(Leasing source) {
        dateFrom = source.getDateFrom();
        dateTo = source.getDateTo();
        cars = source.getCars();
        user = source.getUser();
    }

    public LocalDate getDateFrom() {
        return dateFrom;
    }

    public void setDateFrom(final LocalDate dateFrom) {
        this.dateFrom = dateFrom;
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

    public User getUser() {
        return user;
    }

    public void setUser(final User user) {
        this.user = user;
    }


}
