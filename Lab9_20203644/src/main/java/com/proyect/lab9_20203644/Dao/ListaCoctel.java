package com.proyect.lab9_20203644.Dao;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.proyect.lab9_20203644.Entity.Coctel;
import com.proyect.lab9_20203644.Entity.Coctelesresults;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
public class ListaCoctel {
    private static final String url = "https://www.thecocktaildb.com/api/json/v1/1/filter.php?c=Cocktail";

    public List<Coctel> listarCoctel(){
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Coctelesresults> response = restTemplate.getForEntity(
                url, Coctelesresults.class);
        List<Coctel> cocteles = new ArrayList<>();
        ObjectMapper mapeo = new ObjectMapper();
        return response.getBody().getDrinks();
    }
}
