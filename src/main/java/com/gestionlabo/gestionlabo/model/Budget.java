package com.gestionlabo.gestionlabo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@AllArgsConstructor @NoArgsConstructor @Data
@Inheritance(strategy = InheritanceType.JOINED)
public class Budget {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idBudget;
    private int AnneeCivile;







}
