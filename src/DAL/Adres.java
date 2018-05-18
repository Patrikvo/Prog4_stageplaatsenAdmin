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
@Table(name = "adres")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Adres.findAll", query = "SELECT a FROM Adres a")
    , @NamedQuery(name = "Adres.findById", query = "SELECT a FROM Adres a WHERE a.id = :id")
    , @NamedQuery(name = "Adres.findByStraat", query = "SELECT a FROM Adres a WHERE a.straat = :straat")
    , @NamedQuery(name = "Adres.findByNummer", query = "SELECT a FROM Adres a WHERE a.nummer = :nummer")
    , @NamedQuery(name = "Adres.findByStad", query = "SELECT a FROM Adres a WHERE a.stad = :stad")
    , @NamedQuery(name = "Adres.findByPostcode", query = "SELECT a FROM Adres a WHERE a.postcode = :postcode")
    , @NamedQuery(name = "Adres.findByLand", query = "SELECT a FROM Adres a WHERE a.land = :land")
    , @NamedQuery(name = "Adres.findByAanmaakDatum", query = "SELECT a FROM Adres a WHERE a.aanmaakDatum = :aanmaakDatum")
    , @NamedQuery(name = "Adres.findByLaatsteWijziging", query = "SELECT a FROM Adres a WHERE a.laatsteWijziging = :laatsteWijziging")})
public class Adres implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
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
    @Basic(optional = false)
    @Column(name = "AanmaakDatum")
    @Temporal(TemporalType.DATE)
    private Date aanmaakDatum;
    @Basic(optional = false)
    @Column(name = "LaatsteWijziging")
    @Temporal(TemporalType.DATE)
    private Date laatsteWijziging;
    @OneToMany(mappedBy = "adresID", fetch = FetchType.EAGER)
    private List<Student> studentList;
    @OneToMany(mappedBy = "adresID", fetch = FetchType.EAGER)
    private List<Bedrijf> bedrijfList;

    public Adres() {
    }

    public Adres(Integer id) {
        this.id = id;
    }

    public Adres(Integer id, Date aanmaakDatum, Date laatsteWijziging) {
        this.id = id;
        this.aanmaakDatum = aanmaakDatum;
        this.laatsteWijziging = laatsteWijziging;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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
    public List<Student> getStudentList() {
        return studentList;
    }

    public void setStudentList(List<Student> studentList) {
        this.studentList = studentList;
    }

    @XmlTransient
    public List<Bedrijf> getBedrijfList() {
        return bedrijfList;
    }

    public void setBedrijfList(List<Bedrijf> bedrijfList) {
        this.bedrijfList = bedrijfList;
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
        if (!(object instanceof Adres)) {
            return false;
        }
        Adres other = (Adres) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "stageplaatsenadmin.DAL.Adres[ id=" + id + " ]";
    }
    
}
