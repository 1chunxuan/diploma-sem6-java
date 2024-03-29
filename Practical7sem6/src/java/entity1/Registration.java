/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity1;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
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
 * @author Tang Chun Xuan
 */
@Entity
@Table(name = "REGISTRATION")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Registration.findAll", query = "SELECT r FROM Registration r"),
    @NamedQuery(name = "Registration.findByRegId", query = "SELECT r FROM Registration r WHERE r.regId = :regId")})
public class Registration implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "REG_ID")
    private Integer regId;
    @JoinColumn(name = "ID", referencedColumnName = "ID")
    @ManyToOne
    private Student id;
    @OneToMany(cascade=CascadeType.PERSIST,mappedBy = "regId")
    private List<RegisteredSubject> registeredSubjectList;

    public Registration() {
    }

    public Registration(Integer regId) {
        this.regId = regId;
    }

    public Registration(Student id, List<RegisteredSubject> registeredSubjectList) {
        this.id = id;
        this.registeredSubjectList = registeredSubjectList;
    }
    
    public int getRegistrationTotal(){
        int tuitionFeeSum=0;
        for(int i=0;i<registeredSubjectList.size();i++){
         tuitionFeeSum+=registeredSubjectList.get(i).getSubjectCode().getFee();
        }
            return tuitionFeeSum;
    }

    public Integer getRegId() {
        return regId;
    }

    public void setRegId(Integer regId) {
        this.regId = regId;
    }

    public Student getId() {
        return id;
    }

    public void setId(Student id) {
        this.id = id;
    }

    @XmlTransient
    public List<RegisteredSubject> getRegisteredSubjectList() {
        return registeredSubjectList;
    }

    public void setRegisteredSubjectList(List<RegisteredSubject> registeredSubjectList) {
        this.registeredSubjectList = registeredSubjectList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (regId != null ? regId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Registration)) {
            return false;
        }
        Registration other = (Registration) object;
        if ((this.regId == null && other.regId != null) || (this.regId != null && !this.regId.equals(other.regId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity1.Registration[ regId=" + regId + " ]";
    }
    
}
