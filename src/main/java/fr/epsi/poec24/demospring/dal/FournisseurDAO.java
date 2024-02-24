package fr.epsi.poec24.demospring.dal;

import fr.epsi.poec24.demospring.domain.Fournisseur;
import net.sf.jsqlparser.statement.update.Update;

import java.util.List;

public interface FournisseurDAO {

    //C -> CRUD
    Fournisseur create(Fournisseur fournisseur);
    //R -> CRUD
    List<Fournisseur> findAll();
    //R -> CRUD
    Fournisseur findById(int id);

    //U -> CRUD
    Fournisseur update(Fournisseur fournisseur);

    //D -> Crud
    void deleteById(int id);
}
