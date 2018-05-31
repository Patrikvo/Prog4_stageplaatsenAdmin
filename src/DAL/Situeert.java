package DAL;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 * JPA Enity class Situeert
 * @author patrik
 */
@Entity
@Table(name = "situeert")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Situeert.findAll", query = "SELECT s FROM Situeert s")
    , @NamedQuery(name = "Situeert.findById", query = "SELECT s FROM Situeert s WHERE s.id = :id")
    , @NamedQuery(name = "Situeert.findByBeschrijving", query = "SELECT s FROM Situeert s WHERE s.beschrijving = :beschrijving")
    ,@NamedQuery(name = "Situeert.findBySpecialisatieID", query = "SELECT s FROM Situeert s WHERE s.specialisatieID.id = :id")
})
public class Situeert implements Serializable {

    private static final long serialVersionUID = 1L;
    
    /*
        JPA: Columns
    */
    
    @Id
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    
    @Basic(optional = false)
    @Column(name = "Beschrijving")
    private String beschrijving;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "situeertID", fetch = FetchType.EAGER)
    private List<Stageplaats> stageplaatsList;
    
    @JoinColumn(name = "SpecialisatieID", referencedColumnName = "ID")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Specialisatie specialisatieID;

    /**
     * Constructor
     */
    public Situeert() {
    }



    /**
     * JPA Column Getter for the field ID
     * @return The field ID
     */
    public Integer getId() {
        return id;
    }

    /**
     * JPA Column Setter for the field ID
     * @param id new value for the field ID
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * JPA Column Getter for the field beschrijving
     * @return The string beschrijving
     */
    public String getBeschrijving() {
        return beschrijving;
    }

    /**
     * JPA Column Setter for the field beschrijving
     * @param beschrijving new string for the field beschrijving
     */
    public void setBeschrijving(String beschrijving) {
        this.beschrijving = beschrijving;
    }

    /**
     * JPA Column Getter for the field stageplaatsList.
     * These are all stageplaatsen from this Situeert.
     * @return The List stageplaatsList
     */
    @XmlTransient
    public List<Stageplaats> getStageplaatsList() {
        return stageplaatsList;
    }

    /**
     * JPA Column Setter for the field stageplaatsList
     * These are all stageplaatsen from this Situeert.
     * @param stageplaatsList new List stageplaatsList
     */
    public void setStageplaatsList(List<Stageplaats> stageplaatsList) {
        this.stageplaatsList = stageplaatsList;
    }

    /**
     * JPA Column Getter for the field specialisatieID.
     * This is the Specialisatie relevant to this Situeert.
     * @return The Specialisatie specialisatieID
     */
    public Specialisatie getSpecialisatieID() {
        return specialisatieID;
    }

    /**
     * JPA Column Setter for the field specialisatieID
     * This is the Specialisatie relevant to this Situeert.
     * @param specialisatieID new Specialisatie
     */
    public void setSpecialisatieID(Specialisatie specialisatieID) {
        this.specialisatieID = specialisatieID;
    }

    
    /*
        Supporting methodes
    */
    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Situeert)) {
            return false;
        }
        Situeert other = (Situeert) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return getBeschrijving();
    }
    
}
