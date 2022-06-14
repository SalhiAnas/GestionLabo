package com.gestionlabo.gestionlabo.controller;

import com.gestionlabo.gestionlabo.model.BudgetLabo;
import com.gestionlabo.gestionlabo.model.BudgetMembre;
import com.gestionlabo.gestionlabo.service.BudgetMembreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("budgetmembre")

public class BudgetMembreController {

    @Autowired
    BudgetMembreService budgetMembreService;


    @GetMapping("/getAllBudget")
    public List<BudgetMembre> getAllBudget()
    {
        return budgetMembreService.getAllMembreBuget();
    }

    @GetMapping("/findBudget")
    public BudgetMembre findBudget(@RequestParam Long idBudget)
    {
        return budgetMembreService.getBudgetMembreById(idBudget);
    }

    @PostMapping("/saveBudget")
    public BudgetMembre saveBudget(@RequestBody BudgetMembre budgetMembre)
    {
        return  budgetMembreService.saveBudgetMembre(budgetMembre);
    }

    @DeleteMapping("/deleteBudget")
    public void deleteBudget(@RequestBody Long idBudget)
    {
        budgetMembreService.deleteBudgetMembre(idBudget);
    }


    @PutMapping("/updateBudget")
    public BudgetMembre updateBudget(@RequestBody BudgetMembre budgetMembre)
    {
        return budgetMembreService.updateBudgetMembre(budgetMembre);
    }
}
