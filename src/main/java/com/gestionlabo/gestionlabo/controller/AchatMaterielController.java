package com.gestionlabo.gestionlabo.controller;


import com.gestionlabo.gestionlabo.model.AchatMateriel;
import com.gestionlabo.gestionlabo.model.BudgetLabo;
import com.gestionlabo.gestionlabo.service.AchatMaterielService;
import com.gestionlabo.gestionlabo.service.BudgetLaboService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("besoin")
public class AchatMaterielController {

    @Autowired
    AchatMaterielService achatMaterielService;

    @GetMapping("/getAllMateriel")
    public List<AchatMateriel> getAllMateriel()
    {
        return achatMaterielService.getAllAchatMateriel();
    }

    @GetMapping("/findMateriel/{idMateriel}")
    public AchatMateriel findMateriel(@PathVariable Long idMateriel)
    {
        return achatMaterielService.getAchatMaterielById(idMateriel);
    }

    @PostMapping("/saveMateriel/{idMembre}")
    public AchatMateriel saveMateriel(@RequestBody AchatMateriel achatMateriel,@PathVariable Long idMembre)
    {
        return  achatMaterielService.saveAchatMateriel(achatMateriel,idMembre);
    }

    @DeleteMapping("/deleteMateriel/{idMateriel}")
    public void deleteMateriel(@PathVariable Long idMateriel)
    {
        achatMaterielService.deleteAchatMateriel(idMateriel);
    }


    @PutMapping("/updateMateriel")
    public AchatMateriel updateMateriel(@RequestBody AchatMateriel achatMateriel)
    {
        return achatMaterielService.updateAchatMatriel(achatMateriel);
    }

}
