package com.gestionlabo.gestionlabo.service;

import com.gestionlabo.gestionlabo.model.Besoin;
import com.gestionlabo.gestionlabo.model.BudgetLabo;
import com.gestionlabo.gestionlabo.repositories.BesoinRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public  class BesoinService{

    @Autowired
    BesoinRepository besoinRepository;


}
