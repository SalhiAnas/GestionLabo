package com.gestionlabo.gestionlabo.service;

import com.gestionlabo.gestionlabo.model.BudgetMembre;
import com.gestionlabo.gestionlabo.repositories.BudgetMembreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BudgetMembreService {

    @Autowired
    BudgetMembreRepository budgetMembreRepository;

    public List<BudgetMembre> getAllMembreBuget()
    {
        return budgetMembreRepository.findAll();
    }

    public BudgetMembre saveBudgetMembre(BudgetMembre budgetMembre)
    {

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
