package com.gestionlabo.gestionlabo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Data @AllArgsConstructor @NoArgsConstructor
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "type",length = 20)

public class Besoin {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idBesoin;
    private LocalDateTime dateBesoin;
    private String description;
    private String etatBesoin;


}
