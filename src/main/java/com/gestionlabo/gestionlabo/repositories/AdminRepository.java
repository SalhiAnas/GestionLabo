package com.gestionlabo.gestionlabo.repositories;

import com.gestionlabo.gestionlabo.model.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminRepository extends JpaRepository<Admin,Long> {

}
