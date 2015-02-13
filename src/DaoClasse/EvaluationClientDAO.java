/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAOclasse;
import Technique.MyConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import DAOinterface.Ievaluation;
import Entites.Evenement;
import Entites.Utilisateur;

/**
 *
 * @author user
 */
public class EvaluationClientDAO implements Ievaluation {
    
    Connection connexion = MyConnection.getInstance();
    @Override
    public void evaluerevenement(int note ,Evenement e,Utilisateur u){
        
        String requete = "INSERT INTO evaluationevent (id_user,id_event,note) VALUES(?,?,?)";
        try {
            PreparedStatement pst = connexion.prepareStatement(requete);
            pst.setInt(1, u.getId());
            pst.setInt(2, e.getId_event());
            pst.setInt(3, note);
            pst.executeUpdate();
        }
        catch (SQLException ex) {
            Logger.getLogger(EvaluationClientDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }
    
}
