/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Test;

import DaoClasse.OffreDao;
import DaoClasse.ReclamationDao;
import DaoInterface.IOffreDao;
import DaoInterface.IReclamationDao;
import Entites.Offre;
import Entites.Reclamation;
import static com.sun.org.apache.xalan.internal.lib.ExsltDatetime.date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Locale;

/**
 *
 * @author IDRISS
 */
public class TestReclamationDao {
    public static void main(String[] args) throws ParseException
            
    {
        
      
  DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
Date date = new Date();
System.out.println(dateFormat.format(date));
    
       
    Reclamation rec = new Reclamation();
    IReclamationDao iRec = new ReclamationDao();
    rec.setContenuReclamation("contenu1");
    rec.setDateReclamation(date);
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

IOffreDao iOf = new OffreDao();
 // iOf.insertOffre(of);

    }
    
    
}
