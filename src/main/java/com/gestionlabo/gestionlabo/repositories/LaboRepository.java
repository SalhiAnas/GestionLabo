package com.gestionlabo.gestionlabo.repositories;

import com.gestionlabo.gestionlabo.model.Laboratoire;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LaboRepository extends JpaRepository<Laboratoire,Long> {

}
