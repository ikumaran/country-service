package com.ik.springcloud.countryservice.rest;

import com.ik.springcloud.countryservice.model.Country;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/countries")
public class CountryRest {

    @Autowired
    private RestTemplate restTemplate;

    @Value("${client.default.version}")
    private String version;

    @GetMapping
    public ResponseEntity getCountries() {
        return restTemplate.getForEntity("https://restcountries.eu/rest/"+ version + "/all", Country[].class);
    }
}
