package com.gestionlabo.gestionlabo.repositories;

import com.gestionlabo.gestionlabo.model.Responsable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ResponsableRepository extends JpaRepository<Responsable,Long> {
}
