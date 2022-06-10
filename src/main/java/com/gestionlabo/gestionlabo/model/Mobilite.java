package com.gestionlabo.gestionlabo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;

@Entity
@Data @AllArgsConstructor @NoArgsConstructor
public class Mobilite extends Besoin{
    private String ReferenceBillet;
    private double prixBillet;
    private double FarisSejour;
}
