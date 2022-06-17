package com.gestionlabo.gestionlabo.service;

import com.gestionlabo.gestionlabo.model.AchatMateriel;
import com.gestionlabo.gestionlabo.model.BudgetLabo;
import com.gestionlabo.gestionlabo.model.Laboratoire;
import com.gestionlabo.gestionlabo.model.Membre;
import com.gestionlabo.gestionlabo.repositories.AchatMaterielRepository;
import com.gestionlabo.gestionlabo.repositories.MembreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AchatMaterielService {
    @Autowired
    AchatMaterielRepository achatMaterielRepository;

    @Autowired
    MembreRepository membreRepository;

    public List<AchatMateriel> getAllAchatMateriel()
    {
        return achatMaterielRepository.findAll();
    }

    public AchatMateriel saveAchatMateriel(AchatMateriel achatMateriel,Long idMembre)
    {
        Membre membre=membreRepository.findById(idMembre).orElse(null);
        if (membre == null) return null;
        achatMateriel.setMembre(membre);
        return  achatMaterielRepository.save(achatMateriel);
    }


    public AchatMateriel getAchatMaterielById(Long idAchatMateriel)
    {
        return achatMaterielRepository.findById(idAchatMateriel).orElse(null);
    }


    public void deleteAchatMateriel(Long idAchatMateriel)
    {
        achatMaterielRepository.deleteById(idAchatMateriel);
    }

    public AchatMateriel updateAchatMatriel( AchatMateriel achatMateriel)
    {
        return achatMaterielRepository.save(achatMateriel);
    }





}
