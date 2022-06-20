package com.gestionlabo.gestionlabo.service;

import com.gestionlabo.gestionlabo.model.Laboratoire;
import com.gestionlabo.gestionlabo.model.Responsable;
import com.gestionlabo.gestionlabo.model.User;
import com.gestionlabo.gestionlabo.repositories.LaboRepository;
import com.gestionlabo.gestionlabo.repositories.ResponsableRepository;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ResponsableService {
    @Autowired
    ResponsableRepository responsableRepository;

    @Autowired
    LaboRepository laboRepository;

    @Autowired
    EmailService emailService;

    public List<Responsable> getAllResponsable()
    {
        return responsableRepository.findAll();
    }

    public Responsable saveResponsable(Responsable user,Long idLabo) {
        Laboratoire laboratoire=laboRepository.findById(idLabo).orElse(null);
        if (laboratoire == null) return null;
        user.setLaboratoire(laboratoire);

        //generating a random password
        String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!@#$%&*";
        String pwd = RandomStringUtils.random( 8, characters );
        user.setPassword(pwd);

        emailService.sendSimpleMessage(user.getLogin(), "no.reply@gmail.com", "Votre compte a été créé avec success.", user);

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
