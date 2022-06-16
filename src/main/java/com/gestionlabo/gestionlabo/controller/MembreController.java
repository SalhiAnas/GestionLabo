package com.gestionlabo.gestionlabo.controller;

import com.gestionlabo.gestionlabo.model.Membre;
import com.gestionlabo.gestionlabo.model.Responsable;
import com.gestionlabo.gestionlabo.service.MembreService;
import com.gestionlabo.gestionlabo.service.ResponsableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("user")
public class MembreController {

    @Autowired
    MembreService membreService;



    @GetMapping("/getAllMembre")
    public List<Membre> getAllUsers()
    {
        return membreService.getAllMembre();
    }

    @GetMapping("/findMembre")
    public Membre findUser(@RequestParam Long idUser)
    {
        return membreService.getMembreById(idUser);

    }

    @PostMapping("/saveMembre")
    public Membre saveUser(@RequestBody Membre user,@RequestParam Long idLabo)
    {
        return  membreService.saveMembre(user,idLabo);
    }

    @DeleteMapping("/deleteMembre")
    public void deleteUser(@RequestBody Long idUser)
    {
        membreService.deleteMembre(idUser);
    }


    @PutMapping("/updateMembre")
    public Membre updateUser(@RequestBody Membre user)
    {
        return membreService.updateMembre(user);
    }

}
