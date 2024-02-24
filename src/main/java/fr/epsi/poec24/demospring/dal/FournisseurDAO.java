package fr.epsi.poec24.demospring.dal;

import fr.epsi.poec24.demospring.domain.Fournisseur;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FournisseurDAO extends JpaRepository<Fournisseur, Integer> {

}
