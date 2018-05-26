package DAL;

import java.util.Date;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 * Database Access Facade
 * @author patrik
 */
public class DBFacade {

    private final EntityManagerFactory emf;
 
    
    /**
     * Constructor. 
     */
    public DBFacade() {
        emf = Persistence.createEntityManagerFactory("StageplaatsenAdminPU");
    }
    
    /**
     * Querries the database for all stageplaatsen.
     * @return List of all Stageplaatsen
     */
    public List<Stageplaats> getAllStageplaatsen(){
        EntityManager em = emf.createEntityManager();
        Query AllStageplaatsenQuery = em.createNamedQuery("Stageplaats.findAll");
        List<Stageplaats> resultList = AllStageplaatsenQuery.getResultList();
        em.close();
        return resultList;
    }
    
    

    /**
     * Querries the database for a stageplaats with the specified ID.
     * @param id key of the specific stageplaats.
     * @return the Stageplaats or null if not found.
     */
    public Stageplaats getStageplaatsByID(int id){
        Stageplaats s;
        EntityManager em = emf.createEntityManager();
        Query stageplaatsByIDQuery = em.createNamedQuery("Stageplaats.findById");
        stageplaatsByIDQuery.setParameter("id", id);
        try{
            s = (Stageplaats)stageplaatsByIDQuery.getSingleResult();
        }
        catch(NoResultException ex){
            s = null;
        }
        em.close();
        return s;
        
    }
    
    
    

    /**
     * Querries the database for all Specialisaties
     * @return List of all Specialisations
     */
    public List<Specialisatie> getAllSpecialisaties(){
        EntityManager em = emf.createEntityManager();
        Query AllSpecialisatieQuery = em.createNamedQuery("Specialisatie.findAll");
        List<Specialisatie> resultList = AllSpecialisatieQuery.getResultList();
        em.close();
        return resultList;    

    }
    
    /**
     * Querries the database for a Specialisatie with the specified ID.
     * @param id the ID of the specialisatie
     * @return the specific specialisatie or null if not found.
     */
    public Specialisatie getSpecialisatieByID(int id){
        Specialisatie s;
        EntityManager em = emf.createEntityManager();
        Query SpecialisatieByIDQuery = em.createNamedQuery("Specialisatie.findById");
        SpecialisatieByIDQuery.setParameter("id", id);
        try {
            s = (Specialisatie) SpecialisatieByIDQuery.getSingleResult();
        } catch (NoResultException ex) {
            s = null;
        }
        em.close();
        return s;
        
    }
    
    /**
     * Querries the database for all Situeert
     * @return List of all Situeert.
     */
    public List<Situeert> getAllSitueert(){
        EntityManager em = emf.createEntityManager();
        Query AllSitueertQuery = em.createNamedQuery("Situeert.findAll");
        List<Situeert> resultList = AllSitueertQuery.getResultList();
        em.close();
        return resultList;    

    }
    
    /**
     * Querries the database for all Situeert with the specified SpecialisatieID.
     * @param id ID of the Specialisatie
     * @return A list of Situeert with the specified SpecialisatieID.
     */
    public List<Situeert> getAllSitueertOfSpecialisatieID(int id){
        EntityManager em = emf.createEntityManager();
        Query situeertBySpecialisatieIDQuery = em.createNamedQuery("Situeert.findBySpecialisatieID");
        situeertBySpecialisatieIDQuery.setParameter("id", id);
        List<Situeert> resultList = situeertBySpecialisatieIDQuery.getResultList();
        em.close();
        return resultList;
    }
    
    /**
     * Stores a Stageplaats.
     * Creates new entry or updates the existing entry.
     * @param stageplaats The Stageplaats to store.
     * @return the stored Stageplaats. If it's a new entry, the ID-field has been filled.
     */
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
    
    /**
     * Stores a Bedrijf.
     * Creates new entry or updates the existing entry.
     * @param bedrijf The bedrijf to store
     * @return the stored Bedrijf. If it's a new entry, the ID-field has been filled.
     */
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
    
    /**
     * Querries the database for a Bedrijf with the specified ID.
     * @param id the ID of the Bedrijf
     * @return the specific Bedrijf or null if not found.
     */
    public Bedrijf getBedrijfByID(int id){
        Bedrijf b;
        EntityManager em = emf.createEntityManager();
        Query bedrijfByIDQuery = em.createNamedQuery("Bedrijf.findById");
        bedrijfByIDQuery.setParameter("id", id);
        try
        {
            b = (Bedrijf)bedrijfByIDQuery.getSingleResult();
        } catch (NoResultException ex) {
            b = null;
        }
        em.close();
        return b;
    }
    
    /**
     * Removes the specified Stageplaats.
     * @param stageplaats The Stageplaats to remove.
     */
    public void remove(Stageplaats stageplaats){
        EntityManager em = emf.createEntityManager();
        em.getTransaction( ).begin( );
        Stageplaats s = em.find(Stageplaats.class, stageplaats.getId());
        if ( s != null){
            em.remove(s);
        }
        em.getTransaction().commit();
        em.close();
    }
    
    /**
     * Removes the specified Bedrijf.
     * @param bedrijf The Bedrijf to remove.
     */
    public void remove(Bedrijf bedrijf){
        EntityManager em = emf.createEntityManager();
        em.getTransaction( ).begin( );
        Bedrijf b  = em.find(Bedrijf.class, bedrijf.getId());
        if (b != null){
            em.remove(b);
        }
        em.getTransaction().commit();
        em.close();
    }
    
    /**
     * Querries the database for all Bedrijven
     * @return the List of Bedrijven.
     */
    public List<Bedrijf> getAllBedrijven(){
        EntityManager em = emf.createEntityManager();
        Query AllBedrijvenQuery = em.createNamedQuery("Bedrijf.findAll");
        List<Bedrijf> resultList = AllBedrijvenQuery.getResultList();
        em.close();
        return resultList;
    }
    
    
}
