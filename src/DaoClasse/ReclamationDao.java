/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DaoClasse;

import DaoInterface.IReclamationDao;
import Entites.Reclamation;
import Technique.MyConnection;
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
 * @author IDRISS
 */
public class ReclamationDao implements IReclamationDao{

        Connection connexion= MyConnection.getInstance();

    @Override
    public boolean insertReclamation(Reclamation depot) {
String requete="INSERT INTO depot (adresse_depot) VALUES (?)";
        try{
        PreparedStatement pst = connexion.prepareStatement(requete);
        pst.setString(1,depot.getIdReclamation());
        pst.executeUpdate();
        }
        catch (SQLException ex){
            Logger.getLogger(ReclamationDao.class.getName()).log(Level.SEVERE,null,ex);
        }
        return true;
        }    

    @Override
    public boolean updateReclamation(Reclamation rec) {
String requete="UPDATE reclamation set id_reclamation=? where id_reclamation=?";
        try{
        PreparedStatement pst = connexion.prepareStatement(requete);
        pst.setString(1,rec.getIdReclamation());
        pst.executeUpdate();
            System.out.println("Mise a jour effectuee avec succes");
        }
        catch (SQLException ex){
            //Logger.getLogger(ReclamationDao.class.getName()).log(Level.SEVERE,null,ex);
        System.out.println("erreur lors de la mise a jour"+ex.getMessage());
        }     
                return true;

    }

    @Override
    public boolean deleteReclamation(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Reclamation retrieveReclamationById(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Reclamation> retrieveAllReclamation() {
        List<Reclamation> listRec =new ArrayList<Reclamation>();
        String requete ="select * from reclamation";
        try{
            Statement statement= connexion.createStatement();
            ResultSet resultat = statement.executeQuery(requete);
            while (resultat.next())
            {
                Reclamation rec = new Reclamation();
                rec.setIdReclamation(resultat.getString(2));
                listRec.add(rec);
            }
            return listRec;
            
        }catch (SQLException ex){
            System.out.println("erreur lors du chargement des reclamations"+ex.getMessage());
            return null;
        }
    
    }
    
}
