package com.gestionlabo.gestionlabo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
@Data @AllArgsConstructor @NoArgsConstructor
public class BudgetMembre extends Budget{
    private double budgetPersonel;
    @ManyToOne
    Membre membre;


}
