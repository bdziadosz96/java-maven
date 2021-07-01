package com.rentcar.controller;

import com.rentcar.CarConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class InformationController {
    private CarConfiguration carConfiguration;

    @Autowired
    public InformationController(CarConfiguration carConfiguration) {
        this.carConfiguration = carConfiguration;
    }

    @GetMapping("/info")
    boolean getCarConfiguration() {
        return carConfiguration.isRentMultipleCars();
    }

    @GetMapping("/password")
    String getSecurityPassword() {
        return carConfiguration.getSecurity().getPassword();
    }

    @GetMapping("/username")
    String getSecurityUsername() {
        return carConfiguration.getSecurity().getUsername();
    }

    @GetMapping("/admin")
    boolean getAdminStatus() {
        return carConfiguration.getAdmin().isOnline();
    }
}
