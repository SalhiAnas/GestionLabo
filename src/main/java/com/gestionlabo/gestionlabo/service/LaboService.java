package com.gestionlabo.gestionlabo.service;

import com.gestionlabo.gestionlabo.model.Admin;
import com.gestionlabo.gestionlabo.model.Laboratoire;
import com.gestionlabo.gestionlabo.repositories.AdminRepository;
import com.gestionlabo.gestionlabo.repositories.LaboRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LaboService {

    @Autowired
    LaboRepository laboRepository;

    @Autowired
    AdminRepository adminRepository;

    public Admin checkPrivilege(long idUser)
    {
        System.out.println(idUser);
        return adminRepository.findById(idUser).orElse(null);

    }


    public List<Laboratoire> getAllLabo(long idUser)
    {
        Admin admin=checkPrivilege(idUser);
        System.out.println(admin);
        if(admin == null)
            throw new RuntimeException("vous n'etes pas autorisé de realiser cette action.");
        return laboRepository.findAll();
    }

    public Laboratoire saveLabo(Laboratoire laboratoire,long idUser) throws RuntimeException
    {
        Admin admin=checkPrivilege(idUser);
        if(admin == null)
            throw new RuntimeException("vous n'etes pas autorisé de realiser cette action.");
        return  laboRepository.save(laboratoire);
    }

    public Laboratoire geLaboratoireById(Long idLabo,long idUser)
    {
        Admin admin=checkPrivilege(idUser);
        if(admin == null)
            throw new RuntimeException("vous n'etes pas autorisé de realiser cette action.");
        return laboRepository.findById(idLabo).orElse(null);
    }


    public void deleteLabo(Long idLabo, Long idUser)
    {
        Admin admin=checkPrivilege(idUser);
        if(admin == null)
            throw new RuntimeException("vous n'etes pas autorisé de realiser cette action.");
        laboRepository.deleteById(idLabo);
    }

    public Laboratoire updateLabo( Laboratoire labo,Long idUser)
    {
        Admin admin=checkPrivilege(idUser);
        if(admin == null)
            throw new RuntimeException("vous n'etes pas autorisé de realiser cette action.");
        return laboRepository.save(labo);

    }



}
