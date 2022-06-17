package com.gestionlabo.gestionlabo.controller;

import com.gestionlabo.gestionlabo.model.Responsable;
import com.gestionlabo.gestionlabo.model.User;
import com.gestionlabo.gestionlabo.service.ResponsableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("user")
public class ResponsableController {

    @Autowired
    ResponsableService responsableService;



    @GetMapping("/getAllRespo")
    public List<Responsable> getAllUsers()
    {
        return responsableService.getAllResponsable();
    }

    @GetMapping("/findResponsable/{idUser}")
    public Responsable findUser(@PathVariable Long idUser)
    {
        return responsableService.getResponsableById(idUser);

    }

    @PostMapping("/saveRespo/{idLabo}")
    public Responsable saveUser(@RequestBody Responsable user,@PathVariable Long idLabo)
    {
        return  responsableService.saveResponsable(user,idLabo);
    }

    @DeleteMapping("/deleteRespo/{idUser}")
    public void deleteUser(@PathVariable Long idUser)
    {
        responsableService.deleteResponsable(idUser);
    }


    @PutMapping("/updateRespo")
    public Responsable updateUser(@RequestBody Responsable user)
    {
        return responsableService.updateResponsable(user);
    }

}
