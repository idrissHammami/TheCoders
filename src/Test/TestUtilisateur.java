/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Test;

import DaoClasse.ClientDao;
import DaoClasse.PrestataireDao;
import DaoInterface.IClientDao;
import DaoInterface.IPrestataireDao;
import Entites.Client;
import Entites.Prestataire;
import java.util.List;

/**
 *
 * @author Seif
 */
public class TestUtilisateur {
    public static void main(String[] args) {
        IPrestataireDao ip = new PrestataireDao();
        IClientDao ic = new ClientDao();
        Client c1 = new Client("seif eddine", 29, 12121111, 1, 21451992, 1, "ben abda", "10 rue  tripoli", "seifeddine@esprit.tn", "12345");
         Client c2 = new Client("majed", 31, 00115544, 1, 55123456, 1, "aiaida ", "5 rue  de la liberte", "majedaiaida@esprit.tn", "55555");
         Prestataire p1 =new Prestataire("#2214574", "club de loisir , booling et salon de thé ", 1, 22555666, 0, "firstclub", "avenue habib borguiba ", "firstclub@gmail.Com", "123456");
          Prestataire p2    =new Prestataire("#1111555", " salon de thé ", 6, 23221155, 0, "Rizzocafé", "route de hammamet, mrezgua ", "rizzo@gmail.Com", "224455");
        //ic.insertClient(c2);
        //ic.updateClient(c1);
    //ic.deleteClient(4);
     
         List<Client> cl = ic.retrieveAllClient();  
      for(Client c :cl){
         System.out.println(c);
      }
      
      //    System.out.println(ic.retrieveClientById(4));
          //ip.insertPrestataire(p1);
         // ip.insertPrestataire(p2);
         //ip.updatePrestataire(p2);
          //ip.deletePrestataire(6);
       /*   List<Prestataire> pr = ip.retrieveAllPrestataire();
      for(Prestataire p :pr){
         System.out.println(p);
      }*/
    // System.out.println(ip.retrievePrestataireById(7));
}
}