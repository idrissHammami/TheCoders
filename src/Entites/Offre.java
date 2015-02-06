/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entites;

import java.util.Date;
import java.util.Objects;

/**
 *
 * @author IDRISS
 */
public class Offre {
    public int idoffre;
    public String nom;
    public int tarif;
    public Date datedebut;
    public Date datefin;
    public String description;

    public Offre(int id, String nom, int tarif, Date datedebut, Date datefin,String description) {
        this.idoffre = id;
        this.nom = nom;
        this.tarif = tarif;
        this.datedebut = datedebut;
        this.datefin = datefin;
        this.description=description;
    }

    public Offre() {
    }
    

    public int getIdoffre() {
        return idoffre;
    }

    public void setIdoffre(int idoffre) {
        this.idoffre = idoffre;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

  
    public int getId() {
        return idoffre;
    }

    public void setId(int id) {
        this.idoffre = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getTarif() {
        return tarif;
    }

    public void setTarif(int tarif) {
        this.tarif = tarif;
    }

    public Date getDatedebut() {
        return datedebut;
    }

    public void setDatedebut(Date datedebut) {
        this.datedebut = datedebut;
    }

    public Date getDatefin() {
        return datefin;
    }

    public void setDatefin(Date datefin) {
        this.datefin = datefin;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 79 * hash + this.idoffre;
        hash = 79 * hash + Objects.hashCode(this.nom);
        hash = 79 * hash + this.tarif;
        hash = 79 * hash + Objects.hashCode(this.datedebut);
        hash = 79 * hash + Objects.hashCode(this.datefin);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Offre other = (Offre) obj;
        if (this.idoffre != other.idoffre) {
            return false;
        }
        if (!Objects.equals(this.nom, other.nom)) {
            return false;
        }
        if (this.tarif != other.tarif) {
            return false;
        }
        if (!Objects.equals(this.datedebut, other.datedebut)) {
            return false;
        }
        return Objects.equals(this.datefin, other.datefin);
    }

    @Override
    public String toString() {
        return "Offre{" + "id=" + idoffre + ", nom=" + nom + ", tarif=" + tarif + ", datedebut=" + datedebut + ", datefin=" + datefin + '}';
    }

    
    
    
    
}


