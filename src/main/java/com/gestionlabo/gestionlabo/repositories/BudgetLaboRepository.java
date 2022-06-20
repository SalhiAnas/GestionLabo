package com.gestionlabo.gestionlabo.repositories;

import com.gestionlabo.gestionlabo.model.BudgetLabo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BudgetLaboRepository extends JpaRepository<BudgetLabo,Long> {

}
