package com.proyect.lab9_20203644;


import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

public class ListaCoctel {
    private static final String url = "(www.thecocktaildb.com/api/json/v1/1/filter.php?c=Cocktail)";

    public List<Coctel> listarCoctel(){
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Coctel[]> response = restTemplate.getForEntity(
                url, Coctel[].class);
        return Arrays.asList(response.getBody());
    }
}
