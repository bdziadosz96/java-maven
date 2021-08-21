package com.rentcar.model;


import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "users")
@Setter
public class User extends AbstractEntity {

    @NotBlank
    private String surname;

    public User(String name,String surname) {
        super.setName(name);
        this.surname = surname;
    }
    @OneToOne(mappedBy = "user")
    private Leasing leasing;

    public User() {
    }

    public Long getId() {
        return super.getId();
    }

    public String getName() {
        return super.getName();
    }

    public String getSurname() {
        return surname;
    }

    void setSurname(final String surname) {
        this.surname = surname;
    }

    Leasing getLeasing() {
        return leasing;
    }

    void setLeasing(final Leasing leasing) {
        this.leasing = leasing;
    }

    @Override
    public String toString() {
        return "User{" +
                ", name='" + super.getName() + '\'' +
                ", surname='" + surname + '\'' +
                '}';


    }


    public void updateFrom(User source) {
        super.setName(source.getName());
        surname = source.getSurname();
    }
}
