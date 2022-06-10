package com.gestionlabo.gestionlabo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data @AllArgsConstructor @NoArgsConstructor
@DiscriminatorValue("M")
public class Membre extends  User {

    @OneToMany(mappedBy = "membre")
    List <BudgetMembre> budgetMembres;

    @ManyToOne
    Laboratoire laboratoire;



}
