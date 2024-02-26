package fr.epsi.poec24.demospring.service;

import fr.epsi.poec24.demospring.dal.FournisseurDAO;
import fr.epsi.poec24.demospring.domain.Fournisseur;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FournisseurService {

    private FournisseurDAO dao;

    @Autowired
    public FournisseurService(FournisseurDAO dao) {
        this.dao = dao;
    }

    public List<Fournisseur> findAll() {
        return dao.findAll();
    }

    public Fournisseur create(Fournisseur fournisseur) {
        return dao.save(fournisseur);
    }

    public void deleteById(int id) {
        dao.deleteById(id);
    }

    public Fournisseur findById(int id) {
        return dao.findById(id).orElse(null);
    }

    public void update(Fournisseur fournisseur) {
        dao.save(fournisseur);
    }
}
