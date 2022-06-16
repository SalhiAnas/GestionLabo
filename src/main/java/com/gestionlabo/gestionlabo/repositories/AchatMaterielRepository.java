package com.gestionlabo.gestionlabo.repositories;

import com.gestionlabo.gestionlabo.model.AchatMateriel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AchatMaterielRepository extends JpaRepository<AchatMateriel,Long> {
}
