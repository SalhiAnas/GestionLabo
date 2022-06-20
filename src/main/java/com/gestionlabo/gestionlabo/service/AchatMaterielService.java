package com.gestionlabo.gestionlabo.service;

import com.gestionlabo.gestionlabo.model.*;
import com.gestionlabo.gestionlabo.repositories.AchatMaterielRepository;
import com.gestionlabo.gestionlabo.repositories.BudgetMembreRepository;
import com.gestionlabo.gestionlabo.repositories.MembreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.List;

@Service
public class AchatMaterielService {
    @Autowired
    AchatMaterielRepository achatMaterielRepository;

    @Autowired
    MembreRepository membreRepository;

    @Autowired
    BudgetMembreRepository budgetMembreRepository;

    public List<AchatMateriel> getAllAchatMateriel()
    {
        return achatMaterielRepository.findAll();
    }

    public AchatMateriel saveAchatMateriel(AchatMateriel achatMateriel,Long idMembre)
    {
        Membre membre=membreRepository.findById(idMembre).orElse(null);
        if (membre == null) return null;
        achatMateriel.setMembre(membre);
        return  achatMaterielRepository.save(achatMateriel);
    }


    public AchatMateriel getAchatMaterielById(Long idAchatMateriel)
    {
        return achatMaterielRepository.findById(idAchatMateriel).orElse(null);
    }


    public void deleteAchatMateriel(Long idAchatMateriel)
    {
        achatMaterielRepository.deleteById(idAchatMateriel);
    }

    public AchatMateriel updateAchatMatriel( AchatMateriel achatMateriel)
    {
        if (achatMateriel.getEtatBesoin().equals("Accepted")) {
            int annee = achatMateriel.getDateBesoin().getYear();
            Membre membre = membreRepository.findById(achatMateriel.getMembre().getUserId()).orElse(null);
            if (membre == null) return null;
            for (BudgetMembre budgetMembre : membre.getBudgetMembres()) {
                if (annee == budgetMembre.getAnneeCivile()) {
                    budgetMembre.setSommeRestante(budgetMembre.getSommeRestante() - achatMateriel.getPrixMateriel());
                    budgetMembreRepository.save(budgetMembre);
                }
            }
        }
        return achatMaterielRepository.save(achatMateriel);
    }





}
