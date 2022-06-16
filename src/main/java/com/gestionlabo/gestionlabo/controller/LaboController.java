package com.gestionlabo.gestionlabo.controller;

import com.gestionlabo.gestionlabo.model.BudgetLabo;
import com.gestionlabo.gestionlabo.model.Laboratoire;
import com.gestionlabo.gestionlabo.model.User;
import com.gestionlabo.gestionlabo.service.LaboService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("laboratoire")
public class LaboController {
    @Autowired
    LaboService laboService;



    @GetMapping("/getAllLabo")
    public List<Laboratoire> getAllLabo()
    {

        return laboService.getAllLabo();
    }

    @GetMapping("/findLabo")
    public Laboratoire findLabo(@RequestParam Long idLabo)
    {
        return laboService.geLaboratoireById(idLabo);
    }

    @PostMapping("/saveLabo")
    Laboratoire saveLabo(@RequestBody Laboratoire laboratoire)
    {
        System.out.println(laboratoire);
        return  laboService.saveLabo(laboratoire);
    }

    @DeleteMapping("/deleteLabo")
    void deleteLabo(@RequestBody Long idLabo)
    {
          laboService.deleteLabo(idLabo);
    }


    @PutMapping("/updateLabo")
    Laboratoire updateLabo(@RequestBody Laboratoire laboratoire)
    {
        return laboService.updateLabo(laboratoire);
    }





}
