package com.proyect.lab9_20203644;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
@RequestMapping("/cocteles")
public class VistaController {

    @GetMapping({"/listar",""})
    public String listandoProductos(Model model){

        return
    }
}
