package com.rentcar.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;


@Entity

@Table(name = "cars")
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "name cannot b  e null")
    private String name;
    @NotBlank(message = "model cannot be blank")
    private String model;
    @Embedded
    private final Audit audit = new Audit();


    public Car() {
    }

    public Car(String name, String model) {
        this.name = name;
        this.model = model;
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

    public void updateFrom(final Car source) {
        model = source.model;
        name = source.name;
    }


}
