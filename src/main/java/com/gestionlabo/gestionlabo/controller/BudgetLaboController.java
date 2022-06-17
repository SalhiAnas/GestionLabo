package com.gestionlabo.gestionlabo.controller;

import com.gestionlabo.gestionlabo.model.Budget;
import com.gestionlabo.gestionlabo.model.BudgetLabo;
import com.gestionlabo.gestionlabo.model.User;
import com.gestionlabo.gestionlabo.service.BudgetLaboService;
import com.gestionlabo.gestionlabo.service.BudgetMembreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("budgetlabo")
public class BudgetLaboController {


    @Autowired
    BudgetLaboService budgetLaboService;

    @GetMapping("/getAllBudget")
    public List<BudgetLabo> getAllBudget()
    {
        return budgetLaboService.getAllLaboBuget();
    }

    @GetMapping("/findBudget/{idBudget}")
    public BudgetLabo findBudget(@RequestParam Long idBudget)
    {
        return budgetLaboService.getBudgetLaboById(idBudget);
    }

    @PostMapping("/saveBudget/{idLabo}")
    public BudgetLabo saveBudget(@RequestBody BudgetLabo budgetLabo,@PathVariable Long idLabo)
    {
        return  budgetLaboService.saveBudgetLabo(budgetLabo,idLabo);
    }

    @DeleteMapping("/deleteBudget/{idBudget}")
    public void deleteBudget(@PathVariable Long idBudget)
    {
        budgetLaboService.deleteBudgetLabo(idBudget);
    }


    @PutMapping("/updateBudget")
    public BudgetLabo updateBudget(@RequestBody BudgetLabo budgetLabo)
    {
        return budgetLaboService.updateBudgetLabo(budgetLabo);
    }






}
