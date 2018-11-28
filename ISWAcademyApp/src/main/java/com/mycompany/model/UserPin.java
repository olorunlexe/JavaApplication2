/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Thomas.Matthew
 */
@Entity
@Table(name = "user_pin")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "UserPin.findAll", query = "SELECT u FROM UserPin u")
    , @NamedQuery(name = "UserPin.findById", query = "SELECT u FROM UserPin u WHERE u.id = :id")
    , @NamedQuery(name = "UserPin.findByUserpinStatus", query = "SELECT u FROM UserPin u WHERE u.userpinStatus = :userpinStatus")})
public class UserPin implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id")
    private Integer id;
    @Size(max = 45)
    @Column(name = "user_pin_Status")
    private String userpinStatus;
    @JoinColumn(name = "pin_id", referencedColumnName = "id")
    @ManyToOne
    private PinTbl pinId;
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    @ManyToOne
    private User userId;

    public UserPin() {
    }

    public UserPin(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserpinStatus() {
        return userpinStatus;
    }

    public void setUserpinStatus(String userpinStatus) {
        this.userpinStatus = userpinStatus;
    }

    public PinTbl getPinId() {
        return pinId;
    }

    public void setPinId(PinTbl pinId) {
        this.pinId = pinId;
    }

    public User getUserId() {
        return userId;
    }

    public void setUserId(User userId) {
        this.userId = userId;
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
        if (!(object instanceof UserPin)) {
            return false;
        }
        UserPin other = (UserPin) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.interswitch.model.UserPin[ id=" + id + " ]";
    }
    
}
