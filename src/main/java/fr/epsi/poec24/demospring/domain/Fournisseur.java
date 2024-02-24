package fr.epsi.poec24.demospring.domain;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "fournisseur")
public class Fournisseur implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Integer id;
    @Column(name = "NOM")
    private String raisonSociale;

    public Fournisseur() {
        this(0, "");
    }

    public Fournisseur(String raisonSociale) {
        this(0, raisonSociale);
    }

    public Fournisseur(int id, String raisonSociale) {
        this.id = id;
        this.raisonSociale = raisonSociale;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRaisonSociale() {
        return raisonSociale;
    }

    public void setRaisonSociale(String raisonSociale) {
        this.raisonSociale = raisonSociale;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Fournisseur{");
        sb.append("id=").append(id);
        sb.append(", nom='").append(raisonSociale).append('\'');
        sb.append('}');
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Fournisseur that)) return false;
        return id == that.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
