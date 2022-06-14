package com.gestionlabo.gestionlabo.repositories;

import com.gestionlabo.gestionlabo.model.Budget;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BudgetRepository extends JpaRepository<Budget,Long> {

}
