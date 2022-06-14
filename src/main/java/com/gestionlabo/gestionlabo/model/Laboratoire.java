package com.gestionlabo.gestionlabo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@NoArgsConstructor @AllArgsConstructor @Data
public class Laboratoire {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;
    public String nomLabo;
    public String depatement;

    @OneToMany(mappedBy = "laboratoire")
    private List<BudgetLabo>  budgetsLabo;

    @OneToMany(mappedBy = "laboratoire")
    private List<Membre>  membres;

    @OneToOne ( mappedBy = "laboratoire")
    private Responsable repsonsable;



}
