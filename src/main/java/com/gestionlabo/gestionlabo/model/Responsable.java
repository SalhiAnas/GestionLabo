package com.gestionlabo.gestionlabo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.OneToOne;

@Entity
@Data @AllArgsConstructor @NoArgsConstructor
@DiscriminatorValue("R")
public class Responsable extends User{
    private String grade;
    @OneToOne
    private Laboratoire laboratoire;

}
