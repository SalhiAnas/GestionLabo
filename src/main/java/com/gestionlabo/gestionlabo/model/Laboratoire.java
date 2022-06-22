package com.gestionlabo.gestionlabo.model;

import com.fasterxml.jackson.annotation.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@NoArgsConstructor @AllArgsConstructor @Data
@JsonIdentityInfo(generator= ObjectIdGenerators.PropertyGenerator.class, property="id")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})

public class Laboratoire {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;
    public String nomLabo;
    public String depatement;

    @OneToMany(mappedBy = "laboratoire",fetch = FetchType.LAZY)
    private List<BudgetLabo>  budgetsLabo;

    @OneToMany(mappedBy = "laboratoire",fetch = FetchType.LAZY)
    private List<Membre>  membres;

    @OneToOne(mappedBy = "laboratoire",fetch = FetchType.LAZY)
    private Responsable responsable;



}
