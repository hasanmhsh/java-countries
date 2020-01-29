package com.lambdaschool.countries;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Collections;

@RestController
public class CountryController {

    //    /names/all
    //    return the names of all the countries alphabetically
    @RequestMapping(value = "/name/all", produces = {"application/json"})
    ResponseEntity<?> getAllCountries(){
        return new ResponseEntity<>(CountriesApplication.ourCountryList.getAll(), HttpStatus.OK);
    }

    //    /names/start/{letter}
    //    return the countries alphabetically that begin with the given letter
    @RequestMapping(value = "names/start/{letter}", produces = {"application/json"})
    ResponseEntity<?> getAllCountries(@PathVariable char letter){
        return new ResponseEntity<>(CountriesApplication.ourCountryList.getFilteredCountryList(c->Character.toLowerCase(letter)==Character.toLowerCase(c.getName().charAt(0))), HttpStatus.OK);
    }

    //    /names/size/{number}
    //    return the countries alphabetically that have a name equal to or longer than the given length
    @RequestMapping(value = "/names/size/{number}", produces = {"application/json"})
    ResponseEntity<?> getCountriesByNameLength(@PathVariable int number){
        return new ResponseEntity<>(CountriesApplication.ourCountryList.getFilteredCountryList(c->c.getName().length()>=number), HttpStatus.OK);
    }

    //    /population/size/{people}
    //    return the countries that have a population equal to or greater than the given population
    @RequestMapping(value = "/population/size/{people}", produces = {"application/json"})
    ResponseEntity<?> getCountriesByPopulation(@PathVariable long people){
        return new ResponseEntity<>(CountriesApplication.ourCountryList.getFilteredCountryList(c->c.getPopulation()>=people), HttpStatus.OK);
    }

    //    /population/min
    //    return the country with the smallest population
    @RequestMapping(value = "/population/min", produces = {"application/json"})
    ResponseEntity<?> getMinPopulationCountry(){
        Collections.sort(CountriesApplication.ourCountryList.getAll(),(c1, c2)->(int)(c1.getPopulation()-c2.getPopulation()));
        return new ResponseEntity<>(CountriesApplication.ourCountryList.getAll().get(0), HttpStatus.OK);
    }

    //    /population/max
    //    return the country with the largest population
    @RequestMapping(value = "/population/max", produces = {"application/json"})
    ResponseEntity<?> getMaxPopulationCountry(){
        Collections.sort(CountriesApplication.ourCountryList.getAll(),(c1, c2)->(int)(c2.getPopulation()-c1.getPopulation()));
        return new ResponseEntity<>(CountriesApplication.ourCountryList.getAll().get(0), HttpStatus.OK);
    }
    //        Stretch Goal

    //    /population/median
    //    return the country with the median population
    @RequestMapping(value = "/population/median", produces = {"application/json"})
    ResponseEntity<?> getMedianPopulationCountry(){
        ArrayList<Country> countryList = CountriesApplication.ourCountryList.getAll();
        Collections.sort(countryList,(c1, c2)->(int)(c2.getPopulation()-c1.getPopulation()));
        return new ResponseEntity<>(countryList.size()%2!=0?countryList.get(countryList.size()/2):new Country[]{countryList.get(countryList.size()/2-1),countryList.get(countryList.size()/2)}, HttpStatus.OK);
    }

    //    /age/age/{age}
    //    return the countries that have a median age equal to or greater than the given age
    @RequestMapping(value = "/age/age/{age}", produces = {"application/json"})
    ResponseEntity<?> getCountriesByMedianAge(@PathVariable int age){
        return new ResponseEntity<>(CountriesApplication.ourCountryList.getFilteredCountryList(c->c.getMedianAge()>=age), HttpStatus.OK);
    }

    //    /age/min
    //    return the country with the smallest median age
    @RequestMapping(value = "/age/min", produces = {"application/json"})
    ResponseEntity<?> getMinMAgeCountry(){
        Collections.sort(CountriesApplication.ourCountryList.getAll(),(c1, c2)->(int)(c1.getMedianAge()-c2.getMedianAge()));
        return new ResponseEntity<>(CountriesApplication.ourCountryList.getAll().get(0), HttpStatus.OK);
    }

    //    /age/max
    //    return the country the the greatest median age
    @RequestMapping(value = "/age/max", produces = {"application/json"})
    ResponseEntity<?> getMaxMAgeCountry(){
        Collections.sort(CountriesApplication.ourCountryList.getAll(),(c1, c2)->(int)(c2.getMedianAge()-c1.getMedianAge()));
        return new ResponseEntity<>(CountriesApplication.ourCountryList.getAll().get(0), HttpStatus.OK);
    }


    //        Stretch Goal

    //    /age/median
    //    return the country with the median median age
    @RequestMapping(value = "/age/median", produces = {"application/json"})
    ResponseEntity<?> getMedianMageCountry(){
        ArrayList<Country> countryList = CountriesApplication.ourCountryList.getAll();
        Collections.sort(countryList,(c1, c2)->(int)(c2.getMedianAge()-c1.getMedianAge()));
        return new ResponseEntity<>(countryList.size()%2!=0?countryList.get(countryList.size()/2):new Country[]{countryList.get(countryList.size()/2-1),countryList.get(countryList.size()/2)}, HttpStatus.OK);
    }
}
