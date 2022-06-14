package com.gestionlabo.gestionlabo.repositories;

import com.gestionlabo.gestionlabo.model.Besoin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BesoinRepository extends JpaRepository<Besoin,Long> {
}
