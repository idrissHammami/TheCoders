/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DaoClasse;

import DaoInterface.IClientDao;
import DaoInterface.IEvenementDAO;
import DaoInterface.IParticipation;
import Entites.Client;
import Entites.Evenement;
import Entites.Invitation;
import Technique.MyConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author IDRISS
 */
public class ParticipationDao  implements IParticipation{
            Connection connexion= MyConnection.getInstance();
            IClientDao iCl = new ClientDao();
            IEvenementDAO iVent = new EvenementDAO();

    
    @Override
    public boolean participerEvenement(Client client, Evenement e) {
        String requete="INSERT INTO invitation (evenement,participant,etat) VALUES (?,?,?)";

        try{
        PreparedStatement pst = connexion.prepareStatement(requete);
        
        pst.setInt(2, client.getId());
        pst.setInt(1, e.getId_event());
        pst.setString(3,"accepté");
       
       
        pst.executeUpdate();
        }
        catch (SQLException ex){
            Logger.getLogger(ClientDao.class.getName()).log(Level.SEVERE,null,ex);
        }
        System.out.println("participation acceptée");
        return true;}
    
    


    @Override
    public boolean accepterInvitation(Client c, Evenement e, String ch) {

String requete="UPDATE invitation set etat=? where evenement=? and participant=?";
        try{
        PreparedStatement pst = connexion.prepareStatement(requete);
        pst.setString(1, ch);
        pst.setInt(2,e.getId_event());
                pst.setInt(3,c.getId());

        pst.executeUpdate();
            System.out.println("Mise a jour effectuee avec succes");
        }
        catch (SQLException ex){
            //Logger.getLogger(ReclamationDao.class.getName()).log(Level.SEVERE,null,ex);
        System.out.println("erreur lors de la mise a jour"+ex.getMessage());
        }     
                return true;    }

    public Vector<Invitation> retrieveAllInvitation() {
        Vector<Invitation> listRec =new Vector<Invitation>();
        String requete ="select * from invitation i, evenement e,utilisateur u where i.evenement=e.id and i.participant=u.id";
        try{
            Statement statement= connexion.createStatement();
            ResultSet resultat = statement.executeQuery(requete);
            while (resultat.next())
            {
                Invitation invitation = new Invitation();
                
                Client cl = new Client();
                cl.setId(resultat.getInt("participant"));
                cl  =  iCl.retrieveClientById(cl.getId());
                
                
                Evenement event = new Evenement();
                event.setId_event(resultat.getInt("evenement"));
                event = iVent.retrievEvenementById(event.getId_event());
                
                invitation.setClient(cl);
                invitation.setEvent(event);
                
                      
          invitation.setEtat( resultat.getString("etat"));
          invitation.setDateInvitation(resultat.getDate("date_invitation"));

                
                listRec.add(invitation);
            }
            return listRec;
            
        }catch (SQLException ex){
            System.out.println("erreur lors du chargement des reclamations"+ex.getMessage());
            return null;
        }
    
    }

    
}
