package com.proyect.lab9_20203644;

import com.proyect.lab9_20203644.Dao.ListaCoctel;
import com.proyect.lab9_20203644.Entity.Coctel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/cocteles")
public class VistaController {
    @Autowired
    ListaCoctel coctelDao;

    @GetMapping({"/listando",""})
    public String listandoProductos(Model model){
        List<Coctel> cocteles = coctelDao.listarCoctel();
        List<Coctel> arreglococteles = new ArrayList<>();
        for (int i =0;i<=11;i++){
          arreglococteles.add(cocteles.get(i));
        }
        model.addAttribute("listaCocteles",arreglococteles);
        return "listar";
    }
}
