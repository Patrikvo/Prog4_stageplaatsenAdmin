/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author patrik
 */
@Embeddable
public class StudentStageplaatsPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "StudentID")
    private int studentID;
    @Basic(optional = false)
    @Column(name = "StageplaatsID")
    private int stageplaatsID;

    public StudentStageplaatsPK() {
    }

    public StudentStageplaatsPK(int studentID, int stageplaatsID) {
        this.studentID = studentID;
        this.stageplaatsID = stageplaatsID;
    }

    public int getStudentID() {
        return studentID;
    }

    public void setStudentID(int studentID) {
        this.studentID = studentID;
    }

    public int getStageplaatsID() {
        return stageplaatsID;
    }

    public void setStageplaatsID(int stageplaatsID) {
        this.stageplaatsID = stageplaatsID;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) studentID;
        hash += (int) stageplaatsID;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof StudentStageplaatsPK)) {
            return false;
        }
        StudentStageplaatsPK other = (StudentStageplaatsPK) object;
        if (this.studentID != other.studentID) {
            return false;
        }
        if (this.stageplaatsID != other.stageplaatsID) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "stageplaatsenadmin.DAL.StudentStageplaatsPK[ studentID=" + studentID + ", stageplaatsID=" + stageplaatsID + " ]";
    }
    
}
