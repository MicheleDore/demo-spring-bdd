package fr.epsi.poec24.demospring.domain;

import java.io.Serializable;
import java.util.Objects;

public class Article implements Serializable {

    private int id;
    private String ref;
    private String libelle;
    private double prix;
    private Fournisseur fournisseur;

    public Article() {
        this(0, "", "", 0.0, null);
    }

    public Article(String ref, String libelle, double prix) {
        this(0, ref, libelle, prix, null);
    }

    public Article(String ref, String libelle, double prix, Fournisseur fournisseur) {
        this(0, ref, libelle, prix, fournisseur);
    }

    public Article(int id, String ref, String libelle, double prix, Fournisseur fournisseur) {
        this.id = id;
        this.ref = ref;
        this.libelle = libelle;
        this.prix = prix;
        this.fournisseur = fournisseur;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRef() {
        return ref;
    }

    public void setRef(String ref) {
        this.ref = ref;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public double getPrix() {
        return prix;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }

    public Fournisseur getFournisseur() {
        return fournisseur;
    }

    public void setFournisseur(Fournisseur fournisseur) {
        this.fournisseur = fournisseur;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Article{");
        sb.append("id=").append(id);
        sb.append(", ref='").append(ref).append('\'');
        sb.append(", libelle='").append(libelle).append('\'');
        sb.append(", prix=").append(prix);
        sb.append(", fournisseur=").append(fournisseur);
        sb.append('}');
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Article article)) return false;
        return id == article.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
