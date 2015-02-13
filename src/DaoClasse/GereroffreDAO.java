/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAOclasse;

import Entites.Evenement;
import Entites.Offre;
import Technique.MyConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author user
 */
public class GereroffreDAO {
    Connection connexion = MyConnection.getInstance();
    public void ajouteroffre(Offre o){
         String requete = "INSERT INTO offre (titre,prix,description,date_debut,date_fin,id_prestataire) VALUES(?,?,?,?,?,?)";
        try {
            PreparedStatement pst = connexion.prepareStatement(requete);
            pst.setString(1,o.getTitre() );
            pst.setFloat(2,o.getPrix() );
            pst.setString(3,o.getDescription() );
            java.sql.Date d1=new java.sql.Date(o.getDate_debut().getTime());
            java.sql.Date d2=new java.sql.Date(o.getDate_fin().getTime());
            pst.setDate(4,d1);
            pst.setDate(5,d2);
            pst.setInt(6,o.getPrestataire().getId());
            pst.executeUpdate();
        }
        catch (SQLException ex) {
            Logger.getLogger(EvaluationClientDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
    }
}
