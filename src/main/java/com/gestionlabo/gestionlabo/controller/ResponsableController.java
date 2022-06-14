package com.gestionlabo.gestionlabo.controller;

import com.gestionlabo.gestionlabo.model.Responsable;
import com.gestionlabo.gestionlabo.model.User;
import com.gestionlabo.gestionlabo.service.ResponsableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("user")
public class ResponsableController {

    @Autowired
    ResponsableService responsableService;



    @GetMapping("/getAllRespo")
    public List<Responsable> getAllUsers()
    {
        return responsableService.getAllResponsable();
    }

    @GetMapping("/findResponsable")
    public Responsable findUser(@RequestParam Long idUser)
    {
        return responsableService.getResponsableById(idUser);

    }

    @PostMapping("/saveRespo")
    public Responsable saveUser(@RequestBody Responsable user)
    {
        return  responsableService.saveResponsable(user);
    }

    @DeleteMapping("/deleteRespo")
    public void deleteUser(@RequestBody Long idUser)
    {
        responsableService.deleteResponsable(idUser);
    }


    @PutMapping("/updateRespo")
    public Responsable updateUser(@RequestBody Responsable user)
    {
        return responsableService.updateResponsable(user);
    }

}
