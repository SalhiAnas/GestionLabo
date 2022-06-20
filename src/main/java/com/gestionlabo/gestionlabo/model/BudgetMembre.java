package com.gestionlabo.gestionlabo.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
@Data @AllArgsConstructor @NoArgsConstructor
@JsonIdentityInfo(generator=ObjectIdGenerators.PropertyGenerator.class, property="idBudget")
public class BudgetMembre extends Budget{
    private double budgetPersonel;
    private double sommeRestante;

    @ManyToOne
    Membre membre;


}
