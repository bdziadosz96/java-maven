package com.rentcar.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;


@Entity
@Table(name = "cars")
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank(message = "name cannot be null")
    private String name;
    private String model;


    public Car(String name, String model) {
        this.name = name;
        this.model = model;
    }

    public Car() {
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    void setName(String name) {
        this.name = name;
    }

    public String getModel() {
        return model;
    }

    void setModel(String model) {
        this.model = model;
    }

    @Override
    public String toString() {
        return "Car{" +
                ", name='" + name + '\'' +
                ", model='" + model + '\'' +
                '}';
    }
}
