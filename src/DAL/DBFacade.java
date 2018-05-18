/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

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
    private final EntityManager em;
    
    public DBFacade() {
        emf = Persistence.createEntityManagerFactory("StageplaatsenAdminPU");
        em = emf.createEntityManager();
    }
    
    
    
    
    public List<Stageplaats> getAllStageplaatsen(){
        Query AllStageplaatsenQuery = em.createNamedQuery("Stageplaats.findAll");
        List<Stageplaats> resultList = AllStageplaatsenQuery.getResultList();
        return resultList;
    }
    
    // Specialisatie.findAll
    public List<Specialisatie> getAllSpecialisaties(){
        Query AllSpecialisatieQuery = em.createNamedQuery("Specialisatie.findAll");
        List<Specialisatie> resultList = AllSpecialisatieQuery.getResultList();
        return resultList;    

    }
    
    public Specialisatie getSpecialisatieByID(int id){
        Query SpecialisatieByIDQuery = em.createNamedQuery("Specialisatie.findById");
        SpecialisatieByIDQuery.setParameter("id", id);
        Specialisatie s = (Specialisatie)SpecialisatieByIDQuery.getSingleResult();
        return s;
        
    }
    
    public List<Situeert> getAllSitueert(){
        Query AllSitueertQuery = em.createNamedQuery("Situeert.findAll");
        List<Situeert> resultList = AllSitueertQuery.getResultList();
        return resultList;    

    }
    
    
    
    
    
    
}
