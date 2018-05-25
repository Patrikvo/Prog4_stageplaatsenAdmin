/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import java.util.Date;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 *
 * @author patrik
 */
public class DBFacade {

    private final EntityManagerFactory emf;
  //  private final EntityManager em;
    
    public DBFacade() {
        emf = Persistence.createEntityManagerFactory("StageplaatsenAdminPU");
   //     em = emf.createEntityManager();
    }
    
    
    
    
    public List<Stageplaats> getAllStageplaatsen(){
        EntityManager em = emf.createEntityManager();
        Query AllStageplaatsenQuery = em.createNamedQuery("Stageplaats.findAll");
        List<Stageplaats> resultList = AllStageplaatsenQuery.getResultList();
        em.close();
        return resultList;
    }
    
    // Stageplaats.findById
    public Stageplaats getStageplaatsByID(int id){
        EntityManager em = emf.createEntityManager();
        Query stageplaatsByIDQuery = em.createNamedQuery("Stageplaats.findById");
        stageplaatsByIDQuery.setParameter("id", id);
        Stageplaats s = (Stageplaats)stageplaatsByIDQuery.getSingleResult();
        em.close();
        return s;
        
    }
    
    
    // Specialisatie.findAll
    public List<Specialisatie> getAllSpecialisaties(){
        EntityManager em = emf.createEntityManager();
        Query AllSpecialisatieQuery = em.createNamedQuery("Specialisatie.findAll");
        List<Specialisatie> resultList = AllSpecialisatieQuery.getResultList();
        em.close();
        return resultList;    

    }
    
    public Specialisatie getSpecialisatieByID(int id){
        EntityManager em = emf.createEntityManager();
        Query SpecialisatieByIDQuery = em.createNamedQuery("Specialisatie.findById");
        SpecialisatieByIDQuery.setParameter("id", id);
        Specialisatie s = (Specialisatie)SpecialisatieByIDQuery.getSingleResult();
        em.close();
        return s;
        
    }
    
    public List<Situeert> getAllSitueert(){
        EntityManager em = emf.createEntityManager();
        Query AllSitueertQuery = em.createNamedQuery("Situeert.findAll");
        List<Situeert> resultList = AllSitueertQuery.getResultList();
        em.close();
        return resultList;    

    }
    
    public List<Situeert> getAllSitueertOfSpecialisatieID(int id){
        EntityManager em = emf.createEntityManager();
        Query situeertBySpecialisatieIDQuery = em.createNamedQuery("Situeert.findBySpecialisatieID");
        situeertBySpecialisatieIDQuery.setParameter("id", id);
        List<Situeert> resultList = situeertBySpecialisatieIDQuery.getResultList();
        em.close();
        return resultList;
    }
    
    public Stageplaats persist(Stageplaats stageplaats){
        
        Date now = new Date();
        if (stageplaats.getAanmaakDatum() == null){
                stageplaats.setAanmaakDatum(now);
        }
        stageplaats.setLaatsteWijziging(now);
        
        
        
        EntityManager em = emf.createEntityManager();
        em.getTransaction( ).begin( );
        
        Stageplaats s = null;
        if (stageplaats.getId() != null)
        {
            s = em.find(Stageplaats.class, stageplaats.getId());
        }
        if (s != null){
            s.update(stageplaats);
        }
        else{
            em.persist(stageplaats);
            em.flush();
            s = stageplaats;
        }
        em.getTransaction().commit();
        em.close();
        return s;
    }
    
    public Bedrijf persist(Bedrijf bedrijf){
        
        Date now = new Date();
        if (bedrijf.getAanmaakDatum() == null){
                bedrijf.setAanmaakDatum(now);
        }
        bedrijf.setLaatsteWijziging(now);
        
        EntityManager em = emf.createEntityManager();
        em.getTransaction( ).begin( );
        
        Bedrijf b = null;        
        if (bedrijf.getId() != null) 
        {
            b = em.find(Bedrijf.class, bedrijf.getId());
        }
        if (b != null)
        {
            b.update(bedrijf);
        }
        else{
            em.persist(bedrijf);
            em.flush();
            b = bedrijf;

        }
        em.getTransaction().commit();
        em.close();
        return b;
    }
    
    
    
    
    
    public Bedrijf getBedrijfByID(int id){
        EntityManager em = emf.createEntityManager();
        Query bedrijfByIDQuery = em.createNamedQuery("Bedrijf.findById");
        bedrijfByIDQuery.setParameter("id", id);
        Bedrijf b = (Bedrijf)bedrijfByIDQuery.getSingleResult();
        em.close();
        return b;
        
    }
    
    public void remove(Stageplaats stageplaats){
        EntityManager em = emf.createEntityManager();
        em.getTransaction( ).begin( );
        em.remove(em.find(Stageplaats.class, stageplaats.getId()));
        em.getTransaction().commit();
        em.close();
    }
    
    public void remove(Bedrijf bedrijf){
        EntityManager em = emf.createEntityManager();
        em.getTransaction( ).begin( );
        em.remove(em.find(Bedrijf.class, bedrijf.getId()));
        em.getTransaction().commit();
        em.close();
    }
    
    
    public List<Bedrijf> getAllBedrijven(){
        EntityManager em = emf.createEntityManager();
        Query AllBedrijvenQuery = em.createNamedQuery("Bedrijf.findAll");
        List<Bedrijf> resultList = AllBedrijvenQuery.getResultList();
        em.close();
        return resultList;
    }
    
    
}
