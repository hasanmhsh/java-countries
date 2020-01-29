package com.lambdaschool.countries;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;

@SpringBootApplication
public class CountriesApplication {

    public static final CountryList ourCountryList = new CountryList();;
    public static void main(String[] args) {
        SpringApplication.run(CountriesApplication.class, args);
    }

}
