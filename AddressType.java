/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.cruduser.model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author fiw00
 */
@Entity
@Table(name = "ADDRESS_TYPE", catalog = "TEST", schema = "PUBLIC")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AddressType.findAll", query = "SELECT a FROM AddressType a")
    , @NamedQuery(name = "AddressType.findById", query = "SELECT a FROM AddressType a WHERE a.id = :id")
    , @NamedQuery(name = "AddressType.findByType", query = "SELECT a FROM AddressType a WHERE a.type = :type")})
public class AddressType implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ID", nullable = false)
    private Short id;
    @Basic(optional = false)
    @Column(name = "TYPE", nullable = false)
    private short type;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "addressType", fetch = FetchType.LAZY)
    private List<Address> addressList;

    public AddressType() {
    }

    public AddressType(Short id) {
        this.id = id;
    }

    public AddressType(Short id, short type) {
        this.id = id;
        this.type = type;
    }

    public Short getId() {
        return id;
    }

    public void setId(Short id) {
        this.id = id;
    }

    public short getType() {
        return type;
    }

    public void setType(short type) {
        this.type = type;
    }

    @XmlTransient
    public List<Address> getAddressList() {
        return addressList;
    }

    public void setAddressList(List<Address> addressList) {
        this.addressList = addressList;
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
        if (!(object instanceof AddressType)) {
            return false;
        }
        AddressType other = (AddressType) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "newpackage.AddressType[ id=" + id + " ]";
    }
    
}
