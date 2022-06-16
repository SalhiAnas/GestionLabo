package com.gestionlabo.gestionlabo.service;

import com.gestionlabo.gestionlabo.model.Laboratoire;
import com.gestionlabo.gestionlabo.model.Responsable;
import com.gestionlabo.gestionlabo.model.User;
import com.gestionlabo.gestionlabo.repositories.LaboRepository;
import com.gestionlabo.gestionlabo.repositories.ResponsableRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ResponsableService {
    @Autowired
    ResponsableRepository responsableRepository;
    @Autowired
    LaboRepository laboRepository;

    public List<Responsable> getAllResponsable()
    {
        return responsableRepository.findAll();
    }

    public Responsable saveResponsable(Responsable user,Long idLabo) {
        Laboratoire laboratoire=laboRepository.findById(idLabo).orElse(null);
        if (laboratoire == null) return null;
        return  responsableRepository.save(user);
    }

    public Responsable getResponsableById(Long iduser)
    {
        return responsableRepository.findById(iduser).orElse(null);
    }

    public void deleteResponsable(Long iduser)
    {
        responsableRepository.deleteById(iduser);
    }

    public Responsable updateResponsable( Responsable user) {return responsableRepository.save(user);}





}
