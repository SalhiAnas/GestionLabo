package com.gestionlabo.gestionlabo.service;

import com.gestionlabo.gestionlabo.model.BudgetMembre;
import com.gestionlabo.gestionlabo.model.Membre;
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

    public List<BudgetMembre> getAllMembreBuget()
    {
        return budgetMembreRepository.findAll();
    }

    public BudgetMembre saveBudgetMembre(BudgetMembre budgetMembre, Long idMembre)
    {
        Membre membre=membreRepository.findById(idMembre).orElse(null);
        if (membre == null) return null;
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
        return budgetMembreRepository.save(budgetMembre);
    }
}
