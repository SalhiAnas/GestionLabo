package com.gestionlabo.gestionlabo.service;

import com.gestionlabo.gestionlabo.model.BudgetLabo;
import com.gestionlabo.gestionlabo.model.BudgetMembre;
import com.gestionlabo.gestionlabo.model.Laboratoire;
import com.gestionlabo.gestionlabo.repositories.BudgetLaboRepository;
import com.gestionlabo.gestionlabo.repositories.BudgetMembreRepository;
import com.gestionlabo.gestionlabo.repositories.BudgetRepository;
import com.gestionlabo.gestionlabo.repositories.LaboRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BudgetLaboService {

    @Autowired
    BudgetRepository budgetRepository;

    @Autowired
    BudgetLaboRepository budgetLaboRepository;

    @Autowired
    LaboRepository laboRepository;




    public List<BudgetLabo> getAllLaboBuget()
    {
        return budgetLaboRepository.findAll();
    }

    public BudgetLabo saveBudgetLabo(BudgetLabo budgetLabo,Long idLabo)
    {
        Laboratoire laboratoire=laboRepository.findById(idLabo).orElse(null);
        if (laboratoire == null) return null;
        budgetLabo.setLaboratoire(laboratoire);
        return  budgetLaboRepository.save(budgetLabo);
    }


    public BudgetLabo getBudgetLaboById(Long idBudget)
    {
        return budgetLaboRepository.findById(idBudget).orElse(null);
    }


    public void deleteBudgetLabo(Long idBudget)
    {
        budgetLaboRepository.deleteById(idBudget);
    }

    public BudgetLabo updateBudgetLabo( BudgetLabo budgetLabo)
    {
        return budgetLaboRepository.save(budgetLabo);
    }














}
