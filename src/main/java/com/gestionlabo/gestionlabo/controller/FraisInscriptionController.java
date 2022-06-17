package com.gestionlabo.gestionlabo.controller;

import com.gestionlabo.gestionlabo.model.AchatMateriel;
import com.gestionlabo.gestionlabo.model.FraisInscription;
import com.gestionlabo.gestionlabo.service.AchatMaterielService;
import com.gestionlabo.gestionlabo.service.FraisInscriptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("besoin")
public class FraisInscriptionController {
    @Autowired
    FraisInscriptionService fraisInscriptionService;

    @GetMapping("/getAllInscription")
    public List<FraisInscription> getAllInscription()
    {
        return fraisInscriptionService.getAllFraisInscription();
    }

    @GetMapping("/findInscription/{idInscription}")
    public FraisInscription findInscription(@PathVariable Long idInscription)
    {
        return fraisInscriptionService.getFraisInscription(idInscription);
    }

    @PostMapping("/saveInscription/{idMembre}")
    public FraisInscription saveMateriel(@RequestBody FraisInscription fraisInscription,@PathVariable Long idMembre)
    {
        return  fraisInscriptionService.saveFraisInscription(fraisInscription,idMembre);
    }

    @DeleteMapping("/deleteInscription/{idInscription}")
    public void deleteInscription(@PathVariable Long idInscription)
    {
        fraisInscriptionService.deleteFraisInscription(idInscription);
    }


    @PutMapping("/updateInscription")
    public FraisInscription updateInscription(@RequestBody FraisInscription fraisInscription)
    {
        return fraisInscriptionService.updateFraisInscription(fraisInscription);
    }

}
