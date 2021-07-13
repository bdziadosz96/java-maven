package com.rentcar.controller;

import com.rentcar.CarConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class InformationController {
    private DataSourceProperties dataSourceProperties;
    private CarConfiguration carConfiguration;

    @Autowired
    InformationController(final DataSourceProperties dataSourceProperties, final CarConfiguration carConfiguration) {
        this.dataSourceProperties = dataSourceProperties;
        this.carConfiguration = carConfiguration;
    }

    @GetMapping("/multiple-rent")
    boolean getCarConfiguration() {
        return carConfiguration.isRentMultipleCars();
    }

    @GetMapping("/security/password")
    String getSecurityPassword() {
        return carConfiguration.getSecurity().getPassword();
    }

    @GetMapping("/security/username")
    String getSecurityUsername() {
        return carConfiguration.getSecurity().getUsername();
    }

    @GetMapping("/admin")
    boolean getAdminStatus() {
        return carConfiguration.getAdmin().isOnline();
    }

    @GetMapping("/connection-type")
    String getConnectionType() {
        return dataSourceProperties.getUrl();
    }
}
