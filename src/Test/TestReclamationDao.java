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

/**
 *
 * @author IDRISS
 */
public class TestReclamationDao {
    public static void main(String[] args)
    {
    Reclamation rec = new Reclamation();
            rec.setIdReclamation("rec1");
    IReclamationDao iRec = new ReclamationDao();
    iRec.insertReclamation(rec);
    
    Offre of = new Offre();
    
of.setId(8);

IOffreDao iOf = new OffreDao();
iOf.insertOffre(of);

    }
    
    
}
