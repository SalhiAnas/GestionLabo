package com.gestionlabo.gestionlabo.controller;

import com.gestionlabo.gestionlabo.model.AchatMateriel;
import com.gestionlabo.gestionlabo.model.Besoin;
import com.gestionlabo.gestionlabo.model.BudgetLabo;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("besoin")
public class BesoinController {

    @PostMapping("/saveBesoin")
    public void saveBesoin(@RequestBody Besoin besoin)
    {
        AchatMateriel achatMateriel=(AchatMateriel) besoin;
        System.out.println(achatMateriel);
        System.out.println(besoin instanceof AchatMateriel);
    }
}
