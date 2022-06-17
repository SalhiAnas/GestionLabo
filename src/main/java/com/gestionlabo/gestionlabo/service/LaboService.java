package com.gestionlabo.gestionlabo.service;

import com.gestionlabo.gestionlabo.model.Laboratoire;
import com.gestionlabo.gestionlabo.model.Membre;
import com.gestionlabo.gestionlabo.model.Responsable;
import com.gestionlabo.gestionlabo.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LaboService {

    @Autowired
    LaboRepository laboRepository;

    @Autowired
    ResponsableRepository respoRepository;

    @Autowired
    MembreRepository membreRepository;

    @Autowired
    BudgetLaboRepository budgetLaboRepository;




    public List<Laboratoire> getAllLabo()
    {
        return laboRepository.findAll();
    }

    public Laboratoire saveLabo(Laboratoire laboratoire)
    {

        return  laboRepository.save(laboratoire);
    }

    public Laboratoire geLaboratoireById(Long idLabo)
    {
        return laboRepository.findById(idLabo).orElse(null);
    }


    public void deleteLabo(Long idLabo)
    {
        laboRepository.deleteById(idLabo);
    }

    public Laboratoire updateLabo( Laboratoire labo)
    {
        return laboRepository.save(labo);
    }

    public boolean setRespoLabo( Long idLabo , Long idRespo)
    {
        Responsable responsable=respoRepository.findById(idRespo).orElse(null);
        Laboratoire laboratoire=laboRepository.findById(idLabo).orElse(null);

        if(responsable == null || laboratoire == null)
        {
            return false;
        }

        laboratoire.setResponsable(responsable);
        return true;
    }

    public boolean addMembreLabo( Long idLabo, Long idMembre)
    {
        Membre membre=membreRepository.findById(idMembre).orElse(null);
        Laboratoire laboratoire=laboRepository.findById(idLabo).orElse(null);
        if(membre == null || laboratoire == null)
        {
            return false;
        }
        laboratoire.getMembres().add(membre);
        return true;

    }

    // budget









}
