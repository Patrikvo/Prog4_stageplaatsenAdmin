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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
 * JPA Enity class Stageplaats
 * @author patrik
 */
@Entity
@Table(name = "stageplaats")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Stageplaats.findAll", query = "SELECT s FROM Stageplaats s")
    , @NamedQuery(name = "Stageplaats.findById", query = "SELECT s FROM Stageplaats s WHERE s.id = :id")
    , @NamedQuery(name = "Stageplaats.findByTitel", query = "SELECT s FROM Stageplaats s WHERE s.titel = :titel")
    , @NamedQuery(name = "Stageplaats.findByOmschrijving", query = "SELECT s FROM Stageplaats s WHERE s.omschrijving = :omschrijving")
    , @NamedQuery(name = "Stageplaats.findByAantalPlaatsen", query = "SELECT s FROM Stageplaats s WHERE s.aantalPlaatsen = :aantalPlaatsen")
    , @NamedQuery(name = "Stageplaats.findByPeriode", query = "SELECT s FROM Stageplaats s WHERE s.periode = :periode")
    , @NamedQuery(name = "Stageplaats.findByBegeleiding", query = "SELECT s FROM Stageplaats s WHERE s.begeleiding = :begeleiding")
    , @NamedQuery(name = "Stageplaats.findByExtraKennisVereist", query = "SELECT s FROM Stageplaats s WHERE s.extraKennisVereist = :extraKennisVereist")
    , @NamedQuery(name = "Stageplaats.findByVoorzieningen", query = "SELECT s FROM Stageplaats s WHERE s.voorzieningen = :voorzieningen")
    , @NamedQuery(name = "Stageplaats.findByAanmaakDatum", query = "SELECT s FROM Stageplaats s WHERE s.aanmaakDatum = :aanmaakDatum")
    , @NamedQuery(name = "Stageplaats.findByLaatsteWijziging", query = "SELECT s FROM Stageplaats s WHERE s.laatsteWijziging = :laatsteWijziging")})
public class Stageplaats implements Serializable {

    private static final long serialVersionUID = 1L;
    
    /*
        JPA: Columns
    */
    
    @Id
    @SequenceGenerator(name = "myseq", sequenceName = "MySEQ", allocationSize = 1, initialValue = 2)
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator="myseq")
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    
    @Basic(optional = false)
    @Column(name = "Titel")
    private String titel;
    
    @Column(name = "Omschrijving")
    private String omschrijving;
    
    @Column(name = "AantalPlaatsen")
    private Integer aantalPlaatsen;
    
    @Column(name = "Periode")
    private String periode;
    
    @Column(name = "Begeleiding")
    private String begeleiding;
    
    @Column(name = "ExtraKennisVereist")
    private String extraKennisVereist;
    
    @Column(name = "Voorzieningen")
    private String voorzieningen;
    
    @Basic(optional = false)
    @Column(name = "AanmaakDatum")
    @Temporal(TemporalType.DATE)
    private Date aanmaakDatum;
    
    @Basic(optional = false)
    @Column(name = "LaatsteWijziging")
    @Temporal(TemporalType.DATE)
    private Date laatsteWijziging;
    
    @JoinColumn(name = "SitueertID", referencedColumnName = "ID")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Situeert situeertID;
    
    @JoinColumn(name = "BedrijfID", referencedColumnName = "ID")
    @ManyToOne(optional = true)
    //@ManyToOne(cascade = CascadeType.PERSIST, optional = true, fetch = FetchType.EAGER)
    
    private Bedrijf bedrijfID;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "stageplaats", fetch = FetchType.EAGER)
    private List<StudentStageplaats> studentStageplaatsList;

    /**
     * Constructor
     */
    public Stageplaats() {
      this.titel = "Naamloos";
      this.omschrijving = "Geen Omschrijving";
      this.aantalPlaatsen = 1;
      this.periode = "Onbekend";
      this.begeleiding = "Onbekend";
      this.extraKennisVereist = "Onbekend";
      this.voorzieningen = "Onbekend";
    }

    /**
     * Copies the fields of the specified Stageplaats to this Stageplaats, except for the field ID.
     * @param stageplaats The Stageplaats to copy.
     */
    public void update(Stageplaats stageplaats){
        this.setTitel(stageplaats.getTitel());
        this.setOmschrijving(stageplaats.getOmschrijving());
        this.setAantalPlaatsen(stageplaats.getAantalPlaatsen());
        this.setPeriode(stageplaats.getPeriode());
        this.setBegeleiding(stageplaats.getBegeleiding());   
        this.setExtraKennisVereist(stageplaats.getExtraKennisVereist());       
        this.setVoorzieningen(stageplaats.getVoorzieningen());       
        this.setAanmaakDatum(stageplaats.getAanmaakDatum());      
        this.setLaatsteWijziging(stageplaats.getLaatsteWijziging());    
        this.setSitueertID(stageplaats.getSitueertID());
        this.setBedrijfID(stageplaats.getBedrijfID());
    }
    
    /*
        JPA: Columns Getters and Setters
    */
    
    
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
     * JPA Column Getter for the string titel
     * @return The string titel
     */
    public String getTitel() {
        return titel;
    }

    /**
     * JPA Column Setter for the string titel
     * @param titel new string for the field titel
     */
    public void setTitel(String titel) {
        this.titel = titel;
    }

    /**
     * JPA Column Getter for the string omschrijving
     * @return The string omschrijving
     */
    public String getOmschrijving() {
        return omschrijving;
    }

    /**
     * JPA Column Setter for the string omschrijving
     * @param omschrijving new string for the field omschrijving
     */
    public void setOmschrijving(String omschrijving) {
        this.omschrijving = omschrijving;
    }

    /**
     * JPA Column Getter for the field aantalPlaatsen
     * @return The integer aantalPlaatsen
     */
    public Integer getAantalPlaatsen() {
        return aantalPlaatsen;
    }

    /**
     * JPA Column Setter for the integer aantalPlaatsen
     * @param aantalPlaatsen new integer for the field aantalPlaatsen
     */
    public void setAantalPlaatsen(Integer aantalPlaatsen) {
        this.aantalPlaatsen = aantalPlaatsen;
    }

    /**
     * JPA Column Getter for the string periode
     * @return The string periode
     */
    public String getPeriode() {
        return periode;
    }

    /**
     * JPA Column Setter for the string periode
     * @param periode new string for the field periode
     */
    public void setPeriode(String periode) {
        this.periode = periode;
    }

    /**
     * JPA Column Getter for the string begeleiding
     * @return The string begeleiding
     */
    public String getBegeleiding() {
        return begeleiding;
    }

    /**
     * JPA Column Setter for the string begeleiding
     * @param begeleiding new string for the field begeleiding
     */
    public void setBegeleiding(String begeleiding) {
        this.begeleiding = begeleiding;
    }

    /**
     * JPA Column Getter for the string extraKennisVereist
     * @return The string extraKennisVereist
     */
    public String getExtraKennisVereist() {
        return extraKennisVereist;
    }

    /**
     * JPA Column Setter for the string extraKennisVereist
     * @param extraKennisVereist new string for the field extraKennisVereist
     */
    public void setExtraKennisVereist(String extraKennisVereist) {
        this.extraKennisVereist = extraKennisVereist;
    }

    /**
     * JPA Column Getter for the string voorzieningen
     * @return The string voorzieningen
     */
    public String getVoorzieningen() {
        return voorzieningen;
    }

    /**
     * JPA Column Setter for the string voorzieningen
     * @param voorzieningen new string for the field voorzieningen
     */
    public void setVoorzieningen(String voorzieningen) {
        this.voorzieningen = voorzieningen;
    }

    /**
     * JPA Column Getter for the field aanmaakDatum.
     * This is the date when this entity was created.
     * @return The Date aanmaakDatum.
     */
    public Date getAanmaakDatum() {
        return aanmaakDatum;
    }

    /**
     * JPA Column Setter for the field aanmaakDatum
     * This is the date when this entity was created.
     * @param aanmaakDatum new Date for the field aanmaakDatum
     */
    public void setAanmaakDatum(Date aanmaakDatum) {
        this.aanmaakDatum = aanmaakDatum;
    }

    /**
     * JPA Column Getter for the field laatsteWijziging.
     * This is the date when this entity was last changed.
     * @return The Date laatsteWijziging.
     */
    public Date getLaatsteWijziging() {
        return laatsteWijziging;
    }

    /**
     * JPA Column Setter for the field laatsteWijziging
     * This is the date when this entity last modified.
     * @param laatsteWijziging new Date for the field laatsteWijziging
     */
    public void setLaatsteWijziging(Date laatsteWijziging) {
        this.laatsteWijziging = laatsteWijziging;
    }

    /**
     * JPA Column Getter for the Situeert situeertID
     * Situeert classifies the stageplaats along the Specialisatie's.
     * @return The Situeert situeertID
     */
    public Situeert getSitueertID() {
        return situeertID;
    }

    /**
     * JPA Column Setter for the Situeert situeertID
     * Situeert classifies the stageplaats along the Specialisatie's.
     * @param situeertID new Situeert for the field situeertID
     */
    public void setSitueertID(Situeert situeertID) {
        this.situeertID = situeertID;
    }

    /**
     * JPA Column Getter for the Bedrijf bedrijfID
     * Specifies which Bedrijf is providing the Stageplaats.
     * @return The Bedrijf bedrijfID
     */
    public Bedrijf getBedrijfID() {
        return bedrijfID;
    }

    /**
     * JPA Column Setter for the Bedrijf bedrijfID
     * Specifies which Bedrijf is providing the Stageplaats.
     * @param bedrijfID new Bedrijf for the field bedrijfID
     */
    public void setBedrijfID(Bedrijf bedrijfID) {
        this.bedrijfID = bedrijfID;
    }

    /**
     * JPA Column Getter for the field stageplaatsList.
     * These are all the stageplaatsen.
     * @return The List stageplaatsList
     */
    @XmlTransient
    public List<StudentStageplaats> getStudentStageplaatsList() {
        return studentStageplaatsList;
    }

    /**
     * JPA Column Setter for the field stageplaatsList
     * These are all the stageplaatsen.
     * @param studentStageplaatsList new List stageplaatsList
     */
    public void setStudentStageplaatsList(List<StudentStageplaats> studentStageplaatsList) {
        this.studentStageplaatsList = studentStageplaatsList;
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
        if (!(object instanceof Stageplaats)) {
            return false;
        }
        Stageplaats other = (Stageplaats) object;
        return !((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id)));
    }

    @Override
    public String toString() {
        return this.getTitel();
    }
    
}
