package com.rentcar.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;


@Entity

@Table(name = "cars")
public class Car extends AbstractEntity{

    @NotBlank(message = "model cannot be blank")
    private String model;

    @ManyToOne
    @JoinColumn(name = "leasing_id")
    private Leasing leasing;


    public Car() {
    }

    public Car(final String model) {
        super();
        this.model = model;
       }


    Leasing getLeasing() {
        return leasing;
    }

    void setLeasing(final Leasing leasing) {
        this.leasing = leasing;
    }

    public String getName() {
        return super.getName();
    }

    public Long getId() {
        return super.getId();
    }

    public String getModel() {
        return model;
    }

    void setModel(String model) {
        this.model = model;
    }


    public void updateFrom(final Car source) {
        model = source.model;
        super.setName(source.getName());
    }

    @Override
    public String toString() {
        return "Car{" +
                "model='" + model;
    }
}
