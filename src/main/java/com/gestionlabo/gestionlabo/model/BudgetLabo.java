package com.gestionlabo.gestionlabo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
@Data @AllArgsConstructor @NoArgsConstructor
public class BudgetLabo extends Budget{
    private double dotationBase;
    private double dotationRecherche;

    @ManyToOne
    private Laboratoire laboratoire;
}
