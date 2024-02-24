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
        return dao.create(fournisseur);
    }

    public void deleteById(int id) {
        dao.deleteById(id);
    }

    public Object findById(int id) {
        return dao.findById(id);
    }

    public void update(Fournisseur fournisseur) {
        dao.update(fournisseur);
    }
}
