package com.gestionlabo.gestionlabo.service;

import com.gestionlabo.gestionlabo.model.BudgetLabo;
import com.gestionlabo.gestionlabo.model.BudgetMembre;
import com.gestionlabo.gestionlabo.model.Laboratoire;
import com.gestionlabo.gestionlabo.model.Membre;
import com.gestionlabo.gestionlabo.repositories.BudgetLaboRepository;
import com.gestionlabo.gestionlabo.repositories.BudgetMembreRepository;
import com.gestionlabo.gestionlabo.repositories.MembreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BudgetMembreService {

    @Autowired
    BudgetMembreRepository budgetMembreRepository;

    @Autowired
    MembreRepository membreRepository;

    @Autowired
    BudgetLaboRepository budgetLaboRepository;

    public List<BudgetMembre> getAllMembreBuget()
    {
        return budgetMembreRepository.findAll();
    }

    public BudgetMembre saveBudgetMembre(BudgetMembre budgetMembre, Long idMembre)
    {
        Membre membre=membreRepository.findById(idMembre).orElse(null);
        if (membre == null) return null;
        int annee=budgetMembre.getAnneeCivile();
        Laboratoire laboratoire=membre.getLaboratoire();
        for (BudgetLabo budgetLabo: laboratoire.getBudgetsLabo())
        {
            if (annee == budgetLabo.getAnneeCivile())
            {
                budgetLabo.setSommeRestante(budgetLabo.getSommeRestante()-budgetMembre.getBudgetPersonel());
                budgetLaboRepository.save(budgetLabo);
            }
        }
        budgetMembre.setSommeRestante(budgetMembre.getBudgetPersonel());
        budgetMembre.setMembre(membre);
        return  budgetMembreRepository.save(budgetMembre);
    }


    public BudgetMembre getBudgetMembreById(Long idBudget)
    {
        return budgetMembreRepository.findById(idBudget).orElse(null);
    }


    public void deleteBudgetMembre(Long idBudget)
    {
        budgetMembreRepository.deleteById(idBudget);
    }

    public BudgetMembre updateBudgetMembre( BudgetMembre budgetMembre)
    {
//        BudgetMembre budgetActuel =budgetMembreRepository.findById(budgetMembre.getIdBudget()).orElse(null);
//        System.out.println(budgetActuel);
//        if (budgetActuel != null) {
//        if (budgetActuel.getBudgetPersonel() != budgetMembre.getBudgetPersonel())
//        {
//            int annee=budgetMembre.getAnneeCivile();
//            Membre membre = membreRepository.findById(budgetActuel.getMembre().getUserId()).orElse(null);
//            Laboratoire laboratoire=membre.getLaboratoire();
//
//            if (budgetActuel.getBudgetPersonel() > budgetMembre.getBudgetPersonel())
//            {
//                for (BudgetLabo budgetLabo: laboratoire.getBudgetsLabo())
//                {
//                    if (annee == budgetLabo.getAnneeCivile())
//                    {
//                        System.out.println("m here 1");
//                        budgetLabo.setSommeRestante(budgetLabo.getSommeRestante()+(budgetActuel.getBudgetPersonel()-budgetMembre.getBudgetPersonel()));
//                        budgetLaboRepository.save(budgetLabo);
//                    }
//                }
//
//            }
//            else if (budgetActuel.getBudgetPersonel() < budgetMembre.getBudgetPersonel()){
//                for (BudgetLabo budgetLabo: laboratoire.getBudgetsLabo())
//                {
//                    if (annee == budgetLabo.getAnneeCivile())
//                    {
//                        System.out.println("m here 2");
//
//                        budgetLabo.setSommeRestante(budgetLabo.getSommeRestante()-(budgetMembre.getBudgetPersonel()-budgetActuel.getBudgetPersonel()));
//                        budgetLaboRepository.save(budgetLabo);
//                    }
//                }
//            }
//        }
//        }

        return budgetMembreRepository.save(budgetMembre);
    }
}
