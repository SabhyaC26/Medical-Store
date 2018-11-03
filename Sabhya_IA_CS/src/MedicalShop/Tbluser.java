/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MedicalShop;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 *
 * @author Sabhya
 */
@Entity
@Table(name = "tbluser", catalog = "DBnetbeans", schema = "")
@NamedQueries({
    @NamedQuery(name = "Tbluser.findAll", query = "SELECT t FROM Tbluser t")
    , @NamedQuery(name = "Tbluser.findByFusername", query = "SELECT t FROM Tbluser t WHERE t.fusername = :fusername")
    , @NamedQuery(name = "Tbluser.findByFpassword", query = "SELECT t FROM Tbluser t WHERE t.fpassword = :fpassword")})
public class Tbluser implements Serializable {

    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "fusername")
    private String fusername;
    @Basic(optional = false)
    @Column(name = "fpassword")
    private String fpassword;

    public Tbluser() {
    }

    public Tbluser(String fusername) {
        this.fusername = fusername;
    }

    public Tbluser(String fusername, String fpassword) {
        this.fusername = fusername;
        this.fpassword = fpassword;
    }

    public String getFusername() {
        return fusername;
    }

    public void setFusername(String fusername) {
        String oldFusername = this.fusername;
        this.fusername = fusername;
        changeSupport.firePropertyChange("fusername", oldFusername, fusername);
    }

    public String getFpassword() {
        return fpassword;
    }

    public void setFpassword(String fpassword) {
        String oldFpassword = this.fpassword;
        this.fpassword = fpassword;
        changeSupport.firePropertyChange("fpassword", oldFpassword, fpassword);
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (fusername != null ? fusername.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tbluser)) {
            return false;
        }
        Tbluser other = (Tbluser) object;
        if ((this.fusername == null && other.fusername != null) || (this.fusername != null && !this.fusername.equals(other.fusername))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "connectiontestone.Tbluser[ fusername=" + fusername + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
