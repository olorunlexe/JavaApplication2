/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.model;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Thomas.Matthew
 */
@Entity
@Table(name = "pin_tbl")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PinTbl.findAll", query = "SELECT p FROM PinTbl p")
    , @NamedQuery(name = "PinTbl.findById", query = "SELECT p FROM PinTbl p WHERE p.id = :id")
    , @NamedQuery(name = "PinTbl.findByPin", query = "SELECT p FROM PinTbl p WHERE p.pin = :pin")
    , @NamedQuery(name = "PinTbl.findByPinStatus", query = "SELECT p FROM PinTbl p WHERE p.pinStatus = :pinStatus")
    , @NamedQuery(name = "PinTbl.findByPinExpiryDate", query = "SELECT p FROM PinTbl p WHERE p.pinExpiryDate = :pinExpiryDate")})
public class PinTbl implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 16)
    @Column(name = "pin")
    private String pin;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 15)
    @Column(name = "pin_status")
    private String pinStatus;
    @Column(name = "pin_expiry_date")
    @Temporal(TemporalType.DATE)
    private Date pinExpiryDate;
    @OneToMany(mappedBy = "pinId")
    private Collection<UserPin> userPinCollection;

    public PinTbl() {
    }

    public PinTbl(Integer id) {
        this.id = id;
    }

    public PinTbl(Integer id, String pin, String pinStatus) {
        this.id = id;
        this.pin = pin;
        this.pinStatus = pinStatus;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPin() {
        return pin;
    }

    public void setPin(String pin) {
        this.pin = pin;
    }

    public String getPinStatus() {
        return pinStatus;
    }

    public void setPinStatus(String pinStatus) {
        this.pinStatus = pinStatus;
    }

    public Date getPinExpiryDate() {
        return pinExpiryDate;
    }

    public void setPinExpiryDate(Date pinExpiryDate) {
        this.pinExpiryDate = pinExpiryDate;
    }

    @XmlTransient
    public Collection<UserPin> getUserPinCollection() {
        return userPinCollection;
    }

    public void setUserPinCollection(Collection<UserPin> userPinCollection) {
        this.userPinCollection = userPinCollection;
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
        if (!(object instanceof PinTbl)) {
            return false;
        }
        PinTbl other = (PinTbl) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.interswitch.model.PinTbl[ id=" + id + " ]";
    }
    
}
