package com.gestionlabo.gestionlabo.service;

import com.gestionlabo.gestionlabo.model.AchatMateriel;
import com.gestionlabo.gestionlabo.model.BudgetMembre;
import com.gestionlabo.gestionlabo.model.FraisInscription;
import com.gestionlabo.gestionlabo.model.Membre;
import com.gestionlabo.gestionlabo.repositories.AchatMaterielRepository;
import com.gestionlabo.gestionlabo.repositories.BudgetMembreRepository;
import com.gestionlabo.gestionlabo.repositories.FraisInscriptionRepository;
import com.gestionlabo.gestionlabo.repositories.MembreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.List;

@Service
public class FraisInscriptionService {
    @Autowired
    FraisInscriptionRepository fraisInscriptionRepository;

    @Autowired
    MembreRepository membreRepository;

    @Autowired
    BudgetMembreRepository budgetMembreRepository;

    public List<FraisInscription> getAllFraisInscription()
    {
        return fraisInscriptionRepository.findAll();
    }

    public FraisInscription saveFraisInscription(FraisInscription fraisInscription,Long idMembre)
    {
        Membre membre=membreRepository.findById(idMembre).orElse(null);
        if (membre == null) return null;
        fraisInscription.setMembre(membre);
        return  fraisInscriptionRepository.save(fraisInscription);
    }


    public FraisInscription getFraisInscription(Long idFraisInscription)
    {
        return fraisInscriptionRepository.findById(idFraisInscription).orElse(null);
    }


    public void deleteFraisInscription(Long idFraisInscription)
    {
        fraisInscriptionRepository.deleteById(idFraisInscription);
    }

    public FraisInscription updateFraisInscription( FraisInscription fraisInscription)
    {
        if (fraisInscription.getEtatBesoin().equals("Accepted"))
        {
            int annee = fraisInscription.getDateBesoin().getYear();
            Membre membre = membreRepository.findById(fraisInscription.getMembre().getUserId()).orElse(null);
            if (membre == null) return null;
            for (BudgetMembre budgetMembre: membre.getBudgetMembres())
            {
                if (annee == budgetMembre.getAnneeCivile())
                {
                    budgetMembre.setSommeRestante(budgetMembre.getSommeRestante()-fraisInscription.getFraisInscription());
                    budgetMembreRepository.save(budgetMembre);
                }
            }
        }
        return fraisInscriptionRepository.save(fraisInscription);
    }
}
