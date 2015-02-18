/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DaoInterface;

import Entites.Offre;
import java.util.List;

/**
 *
 * @author walid
 */
public interface IOffreDao {
    public void insertOffre(Offre offre);
    public void updateOffre(Offre offre);
    public void deleteOffre(int d);
    public Offre retrievOffreById(int id);
    public List<Offre> DisplayAllOffre();
    public List<Offre> Recherchebyprix(int x , int y);
    public Float getmax();
    public Float getmin();
    public List<String> DisplayAllCategorie();
    public List<Offre> DisplaybyprixandCategorie(int x , int y, String cat);
    public List<Offre> Recherchebycategorie(String cat); 
}
