/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author patrik
 */
@Entity
@Table(name = "student_stageplaats")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "StudentStageplaats.findAll", query = "SELECT s FROM StudentStageplaats s")
    , @NamedQuery(name = "StudentStageplaats.findByStudentID", query = "SELECT s FROM StudentStageplaats s WHERE s.studentStageplaatsPK.studentID = :studentID")
    , @NamedQuery(name = "StudentStageplaats.findByStageplaatsID", query = "SELECT s FROM StudentStageplaats s WHERE s.studentStageplaatsPK.stageplaatsID = :stageplaatsID")
    , @NamedQuery(name = "StudentStageplaats.findByAanmaakDatum", query = "SELECT s FROM StudentStageplaats s WHERE s.aanmaakDatum = :aanmaakDatum")
    , @NamedQuery(name = "StudentStageplaats.findByLaatsteWijziging", query = "SELECT s FROM StudentStageplaats s WHERE s.laatsteWijziging = :laatsteWijziging")})
public class StudentStageplaats implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected StudentStageplaatsPK studentStageplaatsPK;
    @Basic(optional = false)
    @Column(name = "AanmaakDatum")
    @Temporal(TemporalType.DATE)
    private Date aanmaakDatum;
    @Basic(optional = false)
    @Column(name = "LaatsteWijziging")
    @Temporal(TemporalType.DATE)
    private Date laatsteWijziging;
    @JoinColumn(name = "StudentID", referencedColumnName = "ID", insertable = false, updatable = false)
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Student student;
    @JoinColumn(name = "StageplaatsID", referencedColumnName = "ID", insertable = false, updatable = false)
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Stageplaats stageplaats;

    public StudentStageplaats() {
    }

    public StudentStageplaats(StudentStageplaatsPK studentStageplaatsPK) {
        this.studentStageplaatsPK = studentStageplaatsPK;
    }

    public StudentStageplaats(StudentStageplaatsPK studentStageplaatsPK, Date aanmaakDatum, Date laatsteWijziging) {
        this.studentStageplaatsPK = studentStageplaatsPK;
        this.aanmaakDatum = aanmaakDatum;
        this.laatsteWijziging = laatsteWijziging;
    }

    public StudentStageplaats(int studentID, int stageplaatsID) {
        this.studentStageplaatsPK = new StudentStageplaatsPK(studentID, stageplaatsID);
    }

    public StudentStageplaatsPK getStudentStageplaatsPK() {
        return studentStageplaatsPK;
    }

    public void setStudentStageplaatsPK(StudentStageplaatsPK studentStageplaatsPK) {
        this.studentStageplaatsPK = studentStageplaatsPK;
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

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Stageplaats getStageplaats() {
        return stageplaats;
    }

    public void setStageplaats(Stageplaats stageplaats) {
        this.stageplaats = stageplaats;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (studentStageplaatsPK != null ? studentStageplaatsPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof StudentStageplaats)) {
            return false;
        }
        StudentStageplaats other = (StudentStageplaats) object;
        if ((this.studentStageplaatsPK == null && other.studentStageplaatsPK != null) || (this.studentStageplaatsPK != null && !this.studentStageplaatsPK.equals(other.studentStageplaatsPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "stageplaatsenadmin.DAL.StudentStageplaats[ studentStageplaatsPK=" + studentStageplaatsPK + " ]";
    }
    
}
