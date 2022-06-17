package com.gestionlabo.gestionlabo.controller;


import com.gestionlabo.gestionlabo.model.AchatMateriel;
import com.gestionlabo.gestionlabo.model.Mobilite;
import com.gestionlabo.gestionlabo.repositories.MobiliteRepository;
import com.gestionlabo.gestionlabo.service.AchatMaterielService;
import com.gestionlabo.gestionlabo.service.MobiliteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("besoin")
public class MobiliteController {


    @Autowired
    MobiliteService mobiliteService;

    @GetMapping("/getAllMobilite")
    public List<Mobilite> getAllMobilite()
    {
        return mobiliteService.getAllMobilite();
    }

    @GetMapping("/findMobilite/{idMobilite}")
    public Mobilite findMobilite(@PathVariable Long idMobilite)
    {
        return mobiliteService.getMobiliteById(idMobilite);
    }

    @PostMapping("/saveMobilite/{idMembre}")
    public Mobilite saveMobilite(@RequestBody Mobilite mobilite,@PathVariable Long idMembre)
    {
        return  mobiliteService.saveMobilite(mobilite,idMembre);
    }

    @DeleteMapping("/deleteMobilite/{idMobilite}")
    public void deleteMobilite(@PathVariable Long idMobilite)
    {
        mobiliteService.deleteMobilite(idMobilite);
    }


    @PutMapping("/updateMobilite")
    public Mobilite updateMobilite(@RequestBody Mobilite mobilite)
    {
        return mobiliteService.updateMobilite(mobilite);
    }
}
