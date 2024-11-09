package com.proyect.lab9_20203644;

import com.proyect.lab9_20203644.Dao.ListaCoctel;
import com.proyect.lab9_20203644.Entity.Coctel;
import com.proyect.lab9_20203644.Entity.Drink;
import com.proyect.lab9_20203644.Repository.DrinkRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/cocteles")
public class VistaController {
    @Autowired
    ListaCoctel coctelDao;

    final DrinkRepository drinkRepository;
    public VistaController(DrinkRepository drinkRepository) {this.drinkRepository = drinkRepository;}

    @GetMapping({"/listando",""})
    public String listandoProductos(Model model){
        List<Coctel> cocteles = coctelDao.listarCoctel();
        List<Coctel> arreglococteles = new ArrayList<>();
        for (int i =0;i<=11;i++){
          arreglococteles.add(cocteles.get(i));
        }
        model.addAttribute("listaCocteles",arreglococteles);
        model.addAttribute("titulo","TELEDRINK");
        return "listar";
    }

    @GetMapping("/listofFavorites")
    public String listandoFavoritos(Model model) {
        model.addAttribute("listaCocteles",drinkRepository.findAll());
        model.addAttribute("titulo","My Favorite Drinks");
        return "listar";
    }

    @GetMapping("/detalle/{id}")
    public String viendoDetalle(@PathVariable String id, Model model){
        Coctel detalle = coctelDao.verDetalleCoctel(id);
        if(detalle != null){
            List<String> ingredientesConMedidas = detalle.getIngredientesConMedidas();
            Integer iddrinkenint = Integer.parseInt(id);
            Drink drink = drinkRepository.findById(iddrinkenint).orElse(null);
            Boolean ifisFavorite = (drink!= null && drink.getStrisFavorite());
            model.addAttribute("isFavorite",ifisFavorite);
            model.addAttribute("detalleDrinks",detalle);
            model.addAttribute("ingredientesConMedidas", ingredientesConMedidas);
        }else{
            model.addAttribute("isFavorite",false);
            model.addAttribute("detalleDrinks", null);
        }
        return "detalle";
    }

}
