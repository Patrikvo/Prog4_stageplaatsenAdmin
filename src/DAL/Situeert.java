/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
 *
 * @author patrik
 */
@Entity
@Table(name = "situeert")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Situeert.findAll", query = "SELECT s FROM Situeert s")
    , @NamedQuery(name = "Situeert.findById", query = "SELECT s FROM Situeert s WHERE s.id = :id")
    , @NamedQuery(name = "Situeert.findByBeschrijving", query = "SELECT s FROM Situeert s WHERE s.beschrijving = :beschrijving")})
public class Situeert implements Serializable {

    private static final long serialVersionUID = 1L;
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

    public Situeert() {
    }

    public Situeert(Integer id) {
        this.id = id;
    }

    public Situeert(Integer id, String beschrijving) {
        this.id = id;
        this.beschrijving = beschrijving;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBeschrijving() {
        return beschrijving;
    }

    public void setBeschrijving(String beschrijving) {
        this.beschrijving = beschrijving;
    }

    @XmlTransient
    public List<Stageplaats> getStageplaatsList() {
        return stageplaatsList;
    }

    public void setStageplaatsList(List<Stageplaats> stageplaatsList) {
        this.stageplaatsList = stageplaatsList;
    }

    public Specialisatie getSpecialisatieID() {
        return specialisatieID;
    }

    public void setSpecialisatieID(Specialisatie specialisatieID) {
        this.specialisatieID = specialisatieID;
    }

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
