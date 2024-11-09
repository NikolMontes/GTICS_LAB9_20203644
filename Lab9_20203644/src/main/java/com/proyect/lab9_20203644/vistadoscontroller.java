package com.proyect.lab9_20203644;

import com.proyect.lab9_20203644.Dao.ListaCoctel;
import com.proyect.lab9_20203644.Entity.Coctel;
import com.proyect.lab9_20203644.Entity.Drink;
import com.proyect.lab9_20203644.Repository.DrinkRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
@RequestMapping("/cocteles")
public class vistadoscontroller {
    @Autowired
    ListaCoctel coctelDao;

    final DrinkRepository drinkRepository;
    public vistadoscontroller(DrinkRepository drinkRepository) {this.drinkRepository = drinkRepository;}

    @PostMapping("/addtoFavorite/{id}")
    public ResponseEntity<String> agregarFavorito(@PathVariable String id){

        HashMap<String, Object> response = new HashMap<>();
        HashMap<String, Object> errors = new HashMap<>();
        try{
            Integer iddrinkenint = Integer.parseInt(id);
            Drink drink = drinkRepository.findById(iddrinkenint).orElse(null);

            if (drink == null) {
                    drink = new Drink();
                    drink.setIdDrink(iddrinkenint);

            }
            Coctel detalle = coctelDao.verDetalleCoctel(id);
            if (detalle != null) {
                    //drink.setIdDrink(iddrinkenint);
                    drink.setStrDrink(detalle.getStrDrink());
                    drink.setStrDrinkThumb(detalle.getStrDrinkThumb());
                    drink.setStrCategory(detalle.getStrCategory());
                    drink.setStrAlcoholic(detalle.getStrAlcoholic());
                    drink.setStrGlass(detalle.getStrGlass());
                    drink.setStrInstructions(detalle.getStrInstructions());
                    drink.setStrisFavorite(true);

                drinkRepository.save(drink);
                return ResponseEntity.ok("Favorito al coctel");
            }else {
                response.put("errors", errors);
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Hay error al agregar a favoritos");
            }
        }catch (Exception e) {
        e.printStackTrace();
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Hay error al agregar a favoritos");
        }
    }
}
