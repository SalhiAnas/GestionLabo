package com.gestionlabo.gestionlabo.service;

import com.gestionlabo.gestionlabo.model.BudgetMembre;
import com.gestionlabo.gestionlabo.model.FraisInscription;
import com.gestionlabo.gestionlabo.model.Membre;
import com.gestionlabo.gestionlabo.model.Mobilite;
import com.gestionlabo.gestionlabo.repositories.BudgetMembreRepository;
import com.gestionlabo.gestionlabo.repositories.FraisInscriptionRepository;
import com.gestionlabo.gestionlabo.repositories.MembreRepository;
import com.gestionlabo.gestionlabo.repositories.MobiliteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.List;

@Service
public class MobiliteService {
    @Autowired
    MobiliteRepository mobiliteRepository;

    @Autowired
    MembreRepository membreRepository;

    @Autowired
    BudgetMembreRepository budgetMembreRepository;

    public List<Mobilite> getAllMobilite()
    {
        return mobiliteRepository.findAll();
    }

    public Mobilite saveMobilite(Mobilite mobilite,Long idMembre)
    {
        Membre membre=membreRepository.findById(idMembre).orElse(null);
        if (membre == null) return null;
        mobilite.setMembre(membre);
        return  mobiliteRepository.save(mobilite);
    }


    public Mobilite getMobiliteById(Long idMobilite)
    {
        return mobiliteRepository.findById(idMobilite).orElse(null);
    }


    public void deleteMobilite(Long idMobilite)
    {
        mobiliteRepository.deleteById(idMobilite);
    }

    public Mobilite updateMobilite( Mobilite mobilite)
    {
//        if (mobilite.getEtatBesoin().equals("Accepted")) {
//            int annee = mobilite.getDateBesoin().getYear();
//            Membre membre = membreRepository.findById(mobilite.getMembre().getUserId()).orElse(null);
//            if (membre == null) return null;
//            for (BudgetMembre budgetMembre : membre.getBudgetMembres()) {
//                if (annee == budgetMembre.getAnneeCivile()) {
//                    budgetMembre.setSommeRestante(budgetMembre.getSommeRestante() - mobilite.getFraisMobilite());
//                    budgetMembreRepository.save(budgetMembre);
//                }
//            }
//        }
        return mobiliteRepository.save(mobilite);
    }

}
