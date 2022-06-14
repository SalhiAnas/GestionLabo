package com.gestionlabo.gestionlabo.service;

import com.gestionlabo.gestionlabo.model.Membre;
import com.gestionlabo.gestionlabo.model.Responsable;
import com.gestionlabo.gestionlabo.repositories.MembreRepository;
import com.gestionlabo.gestionlabo.repositories.ResponsableRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MembreService {
    @Autowired
    MembreRepository membreRepository;

    public List<Membre> getAllMembre()
    {
        return membreRepository.findAll();
    }

    public Membre saveMembre(Membre user) {return  membreRepository.save(user);}

    public Membre getMembreById(Long iduser)
    {
        return membreRepository.findById(iduser).orElse(null);
    }

    public void deleteMembre(Long iduser)
    {
        membreRepository.deleteById(iduser);
    }

    public Membre updateMembre( Membre user) {return membreRepository.save(user);}
}
