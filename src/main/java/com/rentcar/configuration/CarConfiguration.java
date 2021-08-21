package com.rentcar.configuration;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "car")
public class CarConfiguration {
    private boolean rentMultipleCars;
    private final Security security = new Security();
    private final Admin admin = new Admin();

    public static class Admin {
        private boolean online;

        public boolean isOnline() {
            return online;
        }

        public void setOnline(boolean online) {
            this.online = online;
        }
    }


    public static class Security {
        private String username;
        private String password;

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }
    }


    public Admin getAdmin() {
        return admin;
    }

    public Security getSecurity() {
        return security;
    }

    public boolean isRentMultipleCars() {
        return rentMultipleCars;
    }

    public void setRentMultipleCars(boolean rentMultipleCars) {
        this.rentMultipleCars = rentMultipleCars;
    }
}
