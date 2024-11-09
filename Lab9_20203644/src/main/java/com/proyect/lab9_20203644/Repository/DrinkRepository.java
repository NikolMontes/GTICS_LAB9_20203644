package com.proyect.lab9_20203644.Repository;

import com.proyect.lab9_20203644.Entity.Drink;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

@Repository
public interface DrinkRepository extends JpaRepository<Drink, Integer> {

}
