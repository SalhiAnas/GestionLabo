package com.gestionlabo.gestionlabo.repositories;

import com.gestionlabo.gestionlabo.model.BudgetMembre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BudgetMembreRepository extends JpaRepository<BudgetMembre,Long> {


}
