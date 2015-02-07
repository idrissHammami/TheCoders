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
public class Reclamation {
    
  private int idReclamation;
  private Date dateReclamation;
  private String contenuReclamation;

    public Reclamation(Date dateReclamation, String contenuReclamation) {
        this.dateReclamation = dateReclamation;
        this.contenuReclamation = contenuReclamation;
    }
  
  

    public Reclamation(int idReclamation, Date dateReclamation, String contenuReclamation) {
        this.idReclamation = idReclamation;
        this.dateReclamation = dateReclamation;
        this.contenuReclamation = contenuReclamation;
    }

    public Reclamation() {
    }

    public int getIdReclamation() {
        return idReclamation;
    }

    public void setIdReclamation(int idReclamation) {
        this.idReclamation = idReclamation;
    }

    public Date getDateReclamation() {
        return dateReclamation;
    }

    public void setDateReclamation(Date dateReclamation) {
        this.dateReclamation = dateReclamation;
    }

    public String getContenuReclamation() {
        return contenuReclamation;
    }

    public void setContenuReclamation(String contenuReclamation) {
        this.contenuReclamation = contenuReclamation;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 79 * hash + Objects.hashCode(this.idReclamation);
        hash = 79 * hash + Objects.hashCode(this.dateReclamation);
        hash = 79 * hash + Objects.hashCode(this.contenuReclamation);
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
        final Reclamation other = (Reclamation) obj;
        if (!Objects.equals(this.idReclamation, other.idReclamation)) {
            return false;
        }
        if (!Objects.equals(this.dateReclamation, other.dateReclamation)) {
            return false;
        }
        if (!Objects.equals(this.contenuReclamation, other.contenuReclamation)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Reclamation{" + "idReclamation=" + idReclamation + ", dateReclamation=" + dateReclamation + ", contenuReclamation=" + contenuReclamation + '}';
    }
  
  
  
  
}
