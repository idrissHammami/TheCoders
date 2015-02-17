/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Test;

import DaoClasse.ReclamationDao;
import DaoInterface.IReclamationDao;
import Entites.Offre;
import Entites.Reclamation;
import java.text.ParseException;

/**
 *
 * @author IDRISS
 */
public class TestReclamationDao {
    public static void main(String[] args) throws ParseException
            
    {
        
 
    
       
    Reclamation rec = new Reclamation();
    IReclamationDao iRec = new ReclamationDao();
    rec.setContenuReclamation("contenu1");
   // iRec.insertReclamation(rec);
   // iRec.updateReclamation(rec);
   // iRec.deleteReclamation(4);
    
    
    //   List<Reclamation> arr = iRec.retrieveAllReclamation();
        
         
     //   for(Reclamation e:arr){
      //     System.out.println(e);
     //  }
    
       System.out.println(iRec.retrieveReclamationById(10));
    
    Offre of = new Offre();
    
of.setId(8);

//IOffreDAO iOf = new IOffreDAO();
 // iOf.insertOffre(of);

    }
    
    
}
