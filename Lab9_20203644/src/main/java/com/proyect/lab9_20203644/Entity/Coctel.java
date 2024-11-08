package com.proyect.lab9_20203644.Entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class Coctel {
    /*cocteldao*/
    private String strDrink;
    private String strDrinkThumb;
    private String idDrink;
    //a partir de aui es para detalle de cocteles(drinks)
    private String strCategory;
    private String strAlcoholic;
    private String strGlass;
    private String strInstructions;
    private String strIngredient1;
    private String strIngredient2;
    private String strIngredient3;
    private String strIngredient4;
    private String strIngredient5;
    private String strIngredient6;

    private String strMeasure1;
    private String strMeasure2;
    private String strMeasure3;
    private String strMeasure4;
    private String strMeasure5;
    private String strMeasure6;

    public List<String> getIngredientesConMedidas() {
        List<String> ingredientesConMedidas = new ArrayList<>();
        String[] ingredientes = {strIngredient1, strIngredient2, strIngredient3, strIngredient4, strIngredient5, strIngredient6};
        String[] medidas = {strMeasure1, strMeasure2, strMeasure3, strMeasure4, strMeasure5, strMeasure6};

        for (int i = 0; i < ingredientes.length; i++) {
            if (ingredientes[i] != null && !ingredientes[i].isEmpty()) {
                String medida = medidas[i] != null ? medidas[i] : "";
                ingredientesConMedidas.add(ingredientes[i] + (medida.isEmpty() ? "" : " - " + medida));
            }
        }
        return ingredientesConMedidas;
    }

}
