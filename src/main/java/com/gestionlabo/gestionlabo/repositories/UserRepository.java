package com.gestionlabo.gestionlabo.repositories;

import com.gestionlabo.gestionlabo.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestParam;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {

        @Query("select u From User u where u.Login=: Login and u.password=: password")
        public User authentificate(@RequestParam String Login, @RequestParam String password);
}
