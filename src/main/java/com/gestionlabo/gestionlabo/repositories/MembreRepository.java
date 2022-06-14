package com.gestionlabo.gestionlabo.repositories;

import com.gestionlabo.gestionlabo.model.Membre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MembreRepository extends JpaRepository<Membre,Long> {
}
