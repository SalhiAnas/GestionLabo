package com.gestionlabo.gestionlabo.controller;

import com.gestionlabo.gestionlabo.model.Laboratoire;
import com.gestionlabo.gestionlabo.service.LaboService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class GestionLaboController {
    @Autowired
    LaboService laboService;

    @GetMapping("/getAllLabo/{idUser}")
    public List<Laboratoire> getAllLabo(@PathVariable Long idUser)
    {
        return laboService.getAllLabo(idUser);
    }

    @PostMapping("/saveLabo/{idUser}")
    Laboratoire saveLabo(@RequestBody Laboratoire laboratoire,@PathVariable Long idUser)
    {
        return  laboService.saveLabo(laboratoire,idUser);
    }

    @DeleteMapping("/deleteLabo/{idUser}")
    void deleteLabo(@RequestBody Laboratoire laboratoire,@PathVariable Long idUser)
    {
          laboService.deleteLabo(laboratoire.getId(),idUser);
    }

    @PutMapping("/updateLabo/{idUser}")
    Laboratoire updateLabo(@RequestBody Laboratoire laboratoire,@PathVariable Long idUser)
    {
        return laboService.updateLabo(laboratoire,idUser);
    }


}
