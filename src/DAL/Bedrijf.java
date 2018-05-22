/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author patrik
 */
@Entity
@Table(name = "bedrijf")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Bedrijf.findAll", query = "SELECT b FROM Bedrijf b")
    , @NamedQuery(name = "Bedrijf.findById", query = "SELECT b FROM Bedrijf b WHERE b.id = :id")
    , @NamedQuery(name = "Bedrijf.findByNaam", query = "SELECT b FROM Bedrijf b WHERE b.naam = :naam")
    , @NamedQuery(name = "Bedrijf.findByContactNaam", query = "SELECT b FROM Bedrijf b WHERE b.contactNaam = :contactNaam")
    , @NamedQuery(name = "Bedrijf.findByContactEmail", query = "SELECT b FROM Bedrijf b WHERE b.contactEmail = :contactEmail")
    , @NamedQuery(name = "Bedrijf.findByActiviteiten", query = "SELECT b FROM Bedrijf b WHERE b.activiteiten = :activiteiten")
    , @NamedQuery(name = "Bedrijf.findByAanwervend", query = "SELECT b FROM Bedrijf b WHERE b.aanwervend = :aanwervend")
    , @NamedQuery(name = "Bedrijf.findByAanmaakDatum", query = "SELECT b FROM Bedrijf b WHERE b.aanmaakDatum = :aanmaakDatum")
    , @NamedQuery(name = "Bedrijf.findByLaatsteWijziging", query = "SELECT b FROM Bedrijf b WHERE b.laatsteWijziging = :laatsteWijziging")})
public class Bedrijf implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "Naam")
    private String naam;
    @Column(name = "ContactNaam")
    private String contactNaam;
    @Column(name = "ContactEmail")
    private String contactEmail;
    @Column(name = "Activiteiten")
    private String activiteiten;
    @Column(name = "Aanwervend")
    private String aanwervend;
    @Basic(optional = false)
    @Column(name = "AanmaakDatum")
    @Temporal(TemporalType.DATE)
    private Date aanmaakDatum;
    @Basic(optional = false)
    @Column(name = "LaatsteWijziging")
    @Temporal(TemporalType.DATE)
    private Date laatsteWijziging;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "bedrijfID", fetch = FetchType.EAGER)
    private List<Stageplaats> stageplaatsList;

    
    @Column(name = "Straat")
    private String straat;
    @Column(name = "Nummer")
    private String nummer;
    @Column(name = "Stad")
    private String stad;
    @Column(name = "Postcode")
    private String postcode;
    @Column(name = "Land")
    private String land;
    
    
    
    public Bedrijf() {
    }

    public Bedrijf(Integer id) {
        this.id = id;
    }

    public Bedrijf(Integer id, String naam, Date aanmaakDatum, Date laatsteWijziging) {
        this.id = id;
        this.naam = naam;
        this.aanmaakDatum = aanmaakDatum;
        this.laatsteWijziging = laatsteWijziging;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNaam() {
        return naam;
    }

    public void setNaam(String naam) {
        this.naam = naam;
    }

    public String getContactNaam() {
        return contactNaam;
    }

    public void setContactNaam(String contactNaam) {
        this.contactNaam = contactNaam;
    }

    public String getContactEmail() {
        return contactEmail;
    }

    public void setContactEmail(String contactEmail) {
        this.contactEmail = contactEmail;
    }

    public String getActiviteiten() {
        return activiteiten;
    }

    public void setActiviteiten(String activiteiten) {
        this.activiteiten = activiteiten;
    }

    public String getAanwervend() {
        return aanwervend;
    }

    public void setAanwervend(String aanwervend) {
        this.aanwervend = aanwervend;
    }

    public Date getAanmaakDatum() {
        return aanmaakDatum;
    }

    public void setAanmaakDatum(Date aanmaakDatum) {
        this.aanmaakDatum = aanmaakDatum;
    }

    public Date getLaatsteWijziging() {
        return laatsteWijziging;
    }

    public void setLaatsteWijziging(Date laatsteWijziging) {
        this.laatsteWijziging = laatsteWijziging;
    }

    @XmlTransient
    public List<Stageplaats> getStageplaatsList() {
        return stageplaatsList;
    }

    public void setStageplaatsList(List<Stageplaats> stageplaatsList) {
        this.stageplaatsList = stageplaatsList;
    }

    public String getStraat() {
        return straat;
    }

    public void setStraat(String straat) {
        this.straat = straat;
    }

    public String getNummer() {
        return nummer;
    }

    public void setNummer(String nummer) {
        this.nummer = nummer;
    }

    public String getStad() {
        return stad;
    }

    public void setStad(String stad) {
        this.stad = stad;
    }

    public String getPostcode() {
        return postcode;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }

    public String getLand() {
        return land;
    }

    public void setLand(String land) {
        this.land = land;
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
        if (!(object instanceof Bedrijf)) {
            return false;
        }
        Bedrijf other = (Bedrijf) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return this.getNaam();
    }
    
}
