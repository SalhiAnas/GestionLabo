package com.gestionlabo.gestionlabo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;

@Entity
@Data @AllArgsConstructor @NoArgsConstructor
public class AchatMateriel extends Besoin{
    private String libelle;
    private Double prixMateriel;
}
