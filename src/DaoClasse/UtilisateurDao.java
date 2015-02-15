/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package DaoClasse;

import DaoInterface.IUtilisateurDao;
import Entites.Utilisateur;
import Technique.MyConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Seif
 */
public class UtilisateurDao implements IUtilisateurDao{
  Connection connexion = MyConnection.getInstance();
  
    @Override
    public boolean deleteUtilisateur(int id) {
String requete="DELETE FROM utilisateur where id=? ";
        try{
        PreparedStatement pst = connexion.prepareStatement(requete);
        pst.setInt(1,id);
       
        pst.executeUpdate();
          //  System.out.println("Suppression effectuee avec succes");
        }
        catch (SQLException ex){
            //Logger.getLogger(ReclamationDao.class.getName()).log(Level.SEVERE,null,ex);
        System.out.println("erreur lors de la Suppression"+ex.getMessage());
        }     
        
        
   return true;
    
    }
    @Override
    public Utilisateur retrieveUtilisateurById(int id) {
Utilisateur u = new Utilisateur();

        String requete ="select * from utilisateur where id="+id;
        try{
            Statement statement= connexion.createStatement();
            ResultSet resultat = statement.executeQuery(requete);
            if (resultat.next())
            {
                 
                u.setId(resultat.getInt(1));
               u.setNom(resultat.getString(2));
               u.setAdresse(resultat.getString(3));
               u.setMail(resultat.getString(4));
               u.setTel(resultat.getInt(5));
               u.setPassword(resultat.getString(7));
               u.setNature(resultat.getByte(13));
            
            }
            return u;
            
        }catch (SQLException ex){
            System.out.println("erreur lors du chargement des utilisateurs "+ex.getMessage());
            return null;
        }
        }    

    @Override
    public List<Utilisateur> retrieveAllUtilisateur() {

     List<Utilisateur> listuser =new ArrayList<>();
        String requete ="select * from utilisateur";
        try{
            Statement statement= connexion.createStatement();
            ResultSet resultat = statement.executeQuery(requete);
            while (resultat.next())
            {
                Utilisateur u = new Utilisateur();
                u.setId(resultat.getInt(1));
               u.setNom(resultat.getString(2));
               u.setAdresse(resultat.getString(3));
               u.setMail(resultat.getString(4));
               u.setTel(resultat.getInt(5));
               u.setPassword(resultat.getString(7));
              
               u.setNature(resultat.getByte(13));

                
                listuser.add(u);
            }
            System.out.println("succées select");
            return listuser;
            
            
        }catch (SQLException ex){
            System.out.println("erreur lors du chargement des utilisateurs"+ex.getMessage());
            return null;
        }
    
    }
    
}