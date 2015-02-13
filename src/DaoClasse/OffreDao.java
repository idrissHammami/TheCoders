/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DaoClasse;

import DaoInterface.IOffreDao;
import Entites.Offre;
import Entites.Utilisateur;
import Technique.MyConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author GaiaDev
 */
public class OffreDao implements IOffreDao{
    Connection connexion = MyConnection.getInstance();
    private Object prepareStatement;

    @Override
    public void insertOffre(Offre offre) {
        String requete = "INSERT INTO offre(titre,prix,description,date_debut,date_fin) VALUES(?,?,?,?,?)";
        
        try {
            PreparedStatement pst = connexion.prepareStatement(requete);
            pst.setString(1, offre.getTitre());
            pst.setFloat(2, offre.getPrix());
            pst.setString(3, offre.getDescription());
            java.sql.Date d1=new java.sql.Date(offre.getDate_debut().getTime());
            java.sql.Date d2=new java.sql.Date(offre.getDate_fin().getTime());
            pst.setDate(4, d1);
            pst.setDate(5, d2);
            pst.executeUpdate();
            System.out.println("insertion effectuer avec succes");
        } catch (SQLException ex) {
            Logger.getLogger(OffreDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    
    }

    @Override
    public void updateOffre(Offre offre) {
        String requete = "UPDATE offre SET titre=?,"
                + "prix=?,"
                + "description=?,"
                + "date_debut=?,"
                + "date_fin=?"
                + "WHERE id="+offre.getId();
        try {
            PreparedStatement pst = connexion.prepareStatement(requete);
            pst.setString(1, offre.getTitre());
            pst.setFloat(2, offre.getPrix());
            pst.setString(3, offre.getDescription());
            java.sql.Date d1=new java.sql.Date(offre.getDate_debut().getTime());
            java.sql.Date d2=new java.sql.Date(offre.getDate_fin().getTime());
            pst.setDate(4, d1);
            pst.setDate(5, d2);
            pst.executeUpdate();
            System.out.println("Mise à jour effectuer avec succes");
            
        } catch (SQLException ex) {
            Logger.getLogger(OffreDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    @Override
    public void deleteOffre(int d) {
        String requete = "DELETE FROM offre WHERE id="+d;
        try {
            PreparedStatement pst = connexion.prepareStatement(requete);
            pst.executeUpdate();
             System.out.println("supression effectuer avec succes");
            
        } catch (SQLException ex) {
            Logger.getLogger(OffreDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }

    @Override
    public Offre retrievOffreById(int id) {
        Offre offre = new Offre();
        Utilisateur u=new Utilisateur();
        try {
            ResultSet result = this.connexion.createStatement(
            ResultSet.TYPE_SCROLL_INSENSITIVE,
            ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT * FROM offre WHERE id="+id);
            //if(result.first())
                
          //  offre = new Offre(id, result.getString(2), result.getFloat(3), result.getString(4), result.getDate(5), result.getDate(6),);
                       
        } catch (SQLException ex) {
            Logger.getLogger(OffreDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return offre;
            }
    @Override
    public List<Offre> DisplayAllOffre() {
        List<Offre> L = new ArrayList<>();
        String requete = "SELECT * FROM offre";
        PreparedStatement pst;
        try {
            pst = connexion.prepareStatement(requete);
            ResultSet resultat = pst.executeQuery(requete);
            while (resultat.next()) { 
                Offre offre = new Offre();
                offre.setId(resultat.getInt(1));
                offre.setTitre(resultat.getString(2));
                offre.setPrix(resultat.getFloat(3));
                offre.setDescription(resultat.getString(4));
                offre.setDate_debut(resultat.getDate(5));
                offre.setDate_fin(resultat.getDate(6));
                L.add(offre);
            
                System.out.println("Affichage en cours");
            }
                return L;
                
            
            
        } catch (SQLException ex) {
            Logger.getLogger(OffreDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    
    
}
