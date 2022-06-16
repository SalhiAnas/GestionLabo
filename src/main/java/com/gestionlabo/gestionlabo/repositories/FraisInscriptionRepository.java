package com.gestionlabo.gestionlabo.repositories;

import com.gestionlabo.gestionlabo.model.FraisInscription;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FraisInscriptionRepository extends JpaRepository<FraisInscription,Long> {
}
