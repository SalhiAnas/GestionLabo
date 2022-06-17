package com.gestionlabo.gestionlabo.controller;

import com.gestionlabo.gestionlabo.model.BudgetLabo;
import com.gestionlabo.gestionlabo.model.BudgetMembre;
import com.gestionlabo.gestionlabo.service.BudgetMembreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("budgetmembre")

public class BudgetMembreController {

    @Autowired
    BudgetMembreService budgetMembreService;


    @GetMapping("/getAllBudget")
    public List<BudgetMembre> getAllBudget()
    {
        return budgetMembreService.getAllMembreBuget();
    }

    @GetMapping("/findBudget/{idBudget}")
    public BudgetMembre findBudget(@PathVariable Long idBudget)
    {
        return budgetMembreService.getBudgetMembreById(idBudget);
    }

    @PostMapping("/saveBudget")
    public BudgetMembre saveBudget(@RequestBody BudgetMembre budgetMembre,@PathVariable Long idMembre)
    {
        return  budgetMembreService.saveBudgetMembre(budgetMembre,idMembre);
    }

    @DeleteMapping("/deleteBudget/{idBudget}")
    public void deleteBudget(@PathVariable Long idBudget)
    {
        budgetMembreService.deleteBudgetMembre(idBudget);
    }


    @PutMapping("/updateBudget")
    public BudgetMembre updateBudget(@RequestBody BudgetMembre budgetMembre)
    {
        return budgetMembreService.updateBudgetMembre(budgetMembre);
    }
}
