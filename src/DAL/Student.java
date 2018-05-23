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
import javax.persistence.SequenceGenerator;
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
@Table(name = "student")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Student.findAll", query = "SELECT s FROM Student s")
    , @NamedQuery(name = "Student.findById", query = "SELECT s FROM Student s WHERE s.id = :id")
    , @NamedQuery(name = "Student.findByNaam", query = "SELECT s FROM Student s WHERE s.naam = :naam")
    , @NamedQuery(name = "Student.findByTelefoon", query = "SELECT s FROM Student s WHERE s.telefoon = :telefoon")
    , @NamedQuery(name = "Student.findByEmail", query = "SELECT s FROM Student s WHERE s.email = :email")
    , @NamedQuery(name = "Student.findByAanmaakDatum", query = "SELECT s FROM Student s WHERE s.aanmaakDatum = :aanmaakDatum")
    , @NamedQuery(name = "Student.findByLaatsteWijziging", query = "SELECT s FROM Student s WHERE s.laatsteWijziging = :laatsteWijziging")})
public class Student implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @SequenceGenerator(name = "myseqStudent", sequenceName = "MySEQStudent", allocationSize = 1, initialValue = 10)
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator="myseqStudent")    
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "Naam")
    private String naam;
    @Column(name = "Telefoon")
    private String telefoon;
    @Column(name = "Email")
    private String email;
    @Basic(optional = false)
    @Column(name = "AanmaakDatum")
    @Temporal(TemporalType.DATE)
    private Date aanmaakDatum;
    @Basic(optional = false)
    @Column(name = "LaatsteWijziging")
    @Temporal(TemporalType.DATE)
    private Date laatsteWijziging;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "student", fetch = FetchType.EAGER)
    private List<StudentStageplaats> studentStageplaatsList;

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
    
    
    
    public Student() {
    }

    public Student(Integer id) {
        this.id = id;
    }

    public Student(Integer id, String naam, Date aanmaakDatum, Date laatsteWijziging) {
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

    public String getTelefoon() {
        return telefoon;
    }

    public void setTelefoon(String telefoon) {
        this.telefoon = telefoon;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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
    public List<StudentStageplaats> getStudentStageplaatsList() {
        return studentStageplaatsList;
    }

    public void setStudentStageplaatsList(List<StudentStageplaats> studentStageplaatsList) {
        this.studentStageplaatsList = studentStageplaatsList;
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
        if (!(object instanceof Student)) {
            return false;
        }
        Student other = (Student) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "stageplaatsenadmin.DAL.Student[ id=" + id + " ]";
    }
    
}
