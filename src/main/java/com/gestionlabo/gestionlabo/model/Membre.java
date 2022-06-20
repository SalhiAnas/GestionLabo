package com.gestionlabo.gestionlabo.model;

import com.fasterxml.jackson.annotation.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data @AllArgsConstructor @NoArgsConstructor
@JsonIdentityInfo(generator= ObjectIdGenerators.PropertyGenerator.class, property="userId")
public class Membre extends  User {

    @OneToMany(mappedBy = "membre",fetch = FetchType.LAZY,cascade = CascadeType.ALL, orphanRemoval = true)
    List <BudgetMembre> budgetMembres;

    @ManyToOne(fetch = FetchType.LAZY)
    Laboratoire laboratoire;

    @OneToMany(mappedBy = "membre",cascade = CascadeType.ALL, orphanRemoval = true)
    List <Besoin> besoins;



}
