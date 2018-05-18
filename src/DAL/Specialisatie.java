/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author patrik
 */
@Entity
@Table(name = "specialisatie")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Specialisatie.findAll", query = "SELECT s FROM Specialisatie s")
    , @NamedQuery(name = "Specialisatie.findById", query = "SELECT s FROM Specialisatie s WHERE s.id = :id")
    , @NamedQuery(name = "Specialisatie.findByBeschrijving", query = "SELECT s FROM Specialisatie s WHERE s.beschrijving = :beschrijving")})
public class Specialisatie implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "Beschrijving")
    private String beschrijving;
    
    // removed the folling as this causes an circular dependency and led to astackoverflowerror.
   // @OneToMany(cascade = CascadeType.ALL, mappedBy = "specialisatieID", fetch = FetchType.EAGER)
   // private List<Situeert> situeertList;

    public Specialisatie() {
    }

    public Specialisatie(Integer id) {
        this.id = id;
    }

    public Specialisatie(Integer id, String beschrijving) {
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

   // @XmlTransient
  //  public List<Situeert> getSitueertList() {
  //      return situeertList;
  //  }

  //  public void setSitueertList(List<Situeert> situeertList) {
  //      this.situeertList = situeertList;
  ///  }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Specialisatie)) {
            return false;
        }
        Specialisatie other = (Specialisatie) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return this.getBeschrijving();
    }
    
}
