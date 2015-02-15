/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entites;

import java.util.Objects;

/**
 *
 * @author GaiaDev
 */
public class Evenement {
    
        private int id_event;
        private String nom_event;
        private String lieu_event;
        private String date_debut_event;
        private String date_fin_event;
        private float prix_event;
        private String description_event;
        //createur : user or client
        private int confidentialite_event;  // Type Byte ça sera 

    public Evenement(int id_event, String nom_event, String lieu_event, 
            String date_debut_event, String date_fin_event, float prix_event, 
            String description_event, int confidentialite_event) {
        
        this.id_event = id_event;
        this.nom_event = nom_event;
        this.lieu_event = lieu_event;
        this.date_debut_event = date_debut_event;
        this.date_fin_event = date_fin_event;
        this.prix_event = prix_event;
        this.description_event = description_event;
        this.confidentialite_event = confidentialite_event;
    }

    public Evenement(String nom_event, String lieu_event, String date_debut_event, String date_fin_event, float prix_event, String description_event, int confidentialite_event) {
        this.nom_event = nom_event;
        this.lieu_event = lieu_event;
        this.date_debut_event = date_debut_event;
        this.date_fin_event = date_fin_event;
        this.prix_event = prix_event;
        this.description_event = description_event;
        this.confidentialite_event = confidentialite_event;
    }
    
    
     public Evenement() {
    }

    public int getId_event() {
        return id_event;
    }

    public void setId_event(int id_event) {
        this.id_event = id_event;
    }

    public String getNom_event() {
        return nom_event;
    }

    public void setNom_event(String nom_event) {
        this.nom_event = nom_event;
    }

    public String getLieu_event() {
        return lieu_event;
    }

    public void setLieu_event(String lieu_event) {
        this.lieu_event = lieu_event;
    }

    public String getDate_debut_event() {
        return date_debut_event;
    }

    public void setDate_debut_event(String date_debut_event) {
        this.date_debut_event = date_debut_event;
    }

    public String getDate_fin_event() {
        return date_fin_event;
    }

    public void setDate_fin_event(String date_fin_event) {
        this.date_fin_event = date_fin_event;
    }
    
    public float getPrix_event() {
        return prix_event;
    }

    public void setPrix_event(float prix_event) {
        this.prix_event = prix_event;
    }

    public String getDescription_event() {
        return description_event;
    }

    public void setDescription_event(String description_event) {
        this.description_event = description_event;
    }

    public int getConfidentialite_event() {
        return confidentialite_event;
    }

    public void setConfidentialite_event(int confidentialite_event) {
        this.confidentialite_event = confidentialite_event;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 17 * hash + this.id_event;
        hash = 17 * hash + Objects.hashCode(this.nom_event);
        hash = 17 * hash + Objects.hashCode(this.lieu_event);
        hash = 17 * hash + Objects.hashCode(this.date_debut_event);
        hash = 17 * hash + Objects.hashCode(this.date_fin_event);
        hash = 17 * hash + Float.floatToIntBits(this.prix_event);
        hash = 17 * hash + Objects.hashCode(this.description_event);
        hash = 17 * hash + this.confidentialite_event;
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
        final Evenement other = (Evenement) obj;
        if (this.id_event != other.id_event) {
            return false;
        }
        if (!Objects.equals(this.nom_event, other.nom_event)) {
            return false;
        }
        if (!Objects.equals(this.lieu_event, other.lieu_event)) {
            return false;
        }
        if (!Objects.equals(this.date_debut_event, other.date_debut_event)) {
            return false;
        }
        if (!Objects.equals(this.date_fin_event, other.date_fin_event)) {
            return false;
        }
        if (Float.floatToIntBits(this.prix_event) != Float.floatToIntBits(other.prix_event)) {
            return false;
        }
        if (!Objects.equals(this.description_event, other.description_event)) {
            return false;
        }
        if (this.confidentialite_event != other.confidentialite_event) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Evenement{" + "id_event=" + id_event + ", nom_event=" + nom_event + ", lieu_event=" + lieu_event + ", date_debut_event=" + date_debut_event + ", date_fin_event=" + date_fin_event + ", prix_event=" + prix_event + ", description_event=" + description_event + ", confidentialite_event=" + confidentialite_event + '}';
    }

   
     
    
}
