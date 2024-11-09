package com.proyect.lab9_20203644.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "drink")
public class Drink {
    @Id
    @Column(name = "iddrink")
    private Integer idDrink;

    @Column(name = "strDrink", nullable = false)
    private String strDrink;
    @Column(name = "strDrinkThumb", nullable = false)
    private String strDrinkThumb;

    @Column(name = "strCategory")
    private String strCategory;

    @Column(name = "strAlcoholic")
    private String strAlcoholic;

    @Column(name = "strGlass")
    private String strGlass;

    @Column(name = "strIntructions")
    private String strInstructions;

    @Column(name = "strisFavorite")
    private Boolean strisFavorite;

    @Version
    private Integer version;


}
