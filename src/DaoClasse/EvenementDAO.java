/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DaoClasse;

import Technique.MyConnection;
import DaoInterface.IEvenementDAO;
import Entites.Evenement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author GaiaDev
 */
public class EvenementDAO implements IEvenementDAO{
    Connection connexion = MyConnection.getInstance();

    @Override
    public void insertEvenement(Evenement evenement) {
        String requete = "INSERT INTO evenement (id,titre,lieu,date_debut,date_fin,confidentialite,description,prix)"
                + " VALUES(?,?,?,?,?,?,?,?)";
        try {
            PreparedStatement pst = connexion.prepareStatement(requete);
            
            pst.setInt(1,evenement.getId_event() );
            pst.setString(2, evenement.getNom_event());
            pst.setString(3, evenement.getLieu_event());
            pst.setString(4, evenement.getDate_debut_event());
            pst.setString(5, evenement.getDate_fin_event());
            pst.setInt(6,evenement.getConfidentialite_event());
            pst.setString(7,evenement.getDescription_event());
            pst.setFloat(8,evenement.getPrix_event());
            pst.executeUpdate();
              }
        catch (SQLException ex) {
            Logger.getLogger(EvenementDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
         }

    @Override
    public void updateEvenement(Evenement evenement) {
           String requete = "UPDATE evenement SET titre=?,"
                   + "lieu=?,"
                   + "date_debut=?,"
                   + "date_fin=?,"
                   + "confidentialite=?,"
                   + "description=?,"
                   + "prix=?"
                   + "WHERE id="+evenement.getId_event() ;
        try {
            PreparedStatement pst = connexion.prepareStatement(requete);
            
            pst.setString(1, evenement.getNom_event());
            pst.setString(2, evenement.getLieu_event());
            pst.setString(3, evenement.getDate_debut_event());
            pst.setString(4, evenement.getDate_fin_event());
            pst.setInt(5, evenement.getConfidentialite_event());
            pst.setString(6, evenement.getDescription_event());
            pst.setFloat(7, evenement.getPrix_event());
            pst.executeUpdate();
            System.out.println("Mise à jour effectuer avec succes");
            }
        catch (SQLException ex) {
            Logger.getLogger(EvenementDAO.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Erreur lors de la mise à jour");   
        }
         
    }

    @Override
    public void deleteEvenement(int id) {
        
        String requete = "DELETE FROM evenement WHERE id =" + id;
        try {
            PreparedStatement pst = connexion.prepareStatement(requete);
             pst.executeUpdate();
            System.out.println("Supression effectuer avec succes");
            
        } catch (SQLException ex) {
            Logger.getLogger(EvenementDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
    }

    @Override
    public Evenement retrievEvenementById(int id) {
        Evenement event = new Evenement();
        try {
        ResultSet result = this.connexion.createStatement(
        ResultSet.TYPE_SCROLL_INSENSITIVE,
        ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT * FROM evenement WHERE id = " + id);
        if(result.first())
        event = new Evenement(id, result.getString(2), result.getString(3), result.getString(4), result.getString(5),
                result.getFloat(6), result.getString(7), result.getByte(8));
        } catch (SQLException e) {
        System.out.println("erreur"+ e.getMessage());
        }
        return event;
    }

 
    @Override
    public List<Evenement> DisplayAllEvent() {
         List<Evenement> listeEvenements = new ArrayList<>();
        String requete = "SELECT * FROM evenement";
        
        try {
            Statement statement = connexion.createStatement();
            ResultSet resultat = statement.executeQuery(requete);
            while (resultat.next()) {   
                
                Evenement event = new Evenement();
                event.setId_event(resultat.getInt(1));
                event.setNom_event(resultat.getString(2));
                event.setLieu_event(resultat.getString(3));
                event.setDate_debut_event(resultat.getString(4));
                event.setDate_fin_event(resultat.getString(5) );
                event.setConfidentialite_event(resultat.getInt(6));
                event.setDescription_event(resultat.getString(7));
                event.setPrix_event(resultat.getFloat(8));
                
               
                listeEvenements.add(event);
                System.out.println("Affichage en cours");
            }
            return  listeEvenements;
        } catch (SQLException ex) {
            Logger.getLogger(EvenementDAO.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Erreur lors du chargement des Evenements");
            return null;
        }
        
    }

  

    @Override
    public List<Evenement> retrievEvenementByName(String titre) {
       List<Evenement> listeEvenements = new ArrayList<>();
        String requete = "SELECT * FROM evenement where titre like '%"+titre+"%'";
        
        try {
            Statement statement = connexion.createStatement();
            ResultSet resultat = statement.executeQuery(requete);
            while (resultat.next()) {   
                
                Evenement event = new Evenement();
                event.setId_event(resultat.getInt(1));
                event.setNom_event(resultat.getString(2));
                event.setLieu_event(resultat.getString(3));
                event.setDate_debut_event(resultat.getString(4));
                event.setDate_fin_event(resultat.getString(5) );
                event.setConfidentialite_event(resultat.getInt(6));
                event.setDescription_event(resultat.getString(7));
                event.setPrix_event(resultat.getFloat(8));
                
               
                listeEvenements.add(event);
                System.out.println("Affichage en cours tt");
            }
            return  listeEvenements;
        } catch (SQLException ex) {
            Logger.getLogger(EvenementDAO.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Erreur lors du chargement des Evenements");
            return null;
        }
        }
    
    
}
