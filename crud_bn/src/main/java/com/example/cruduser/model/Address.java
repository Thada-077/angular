/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.cruduser.model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author fiw00
 */
@Entity
@Table(name = "ADDRESS", catalog = "TEST", schema = "PUBLIC")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Address.findAll", query = "SELECT a FROM Address a")
    , @NamedQuery(name = "Address.findById", query = "SELECT a FROM Address a WHERE a.id = :id")
    , @NamedQuery(name = "Address.findByProvinceId", query = "SELECT a FROM Address a WHERE a.provinceId = :provinceId")
    , @NamedQuery(name = "Address.findByAddressNo", query = "SELECT a FROM Address a WHERE a.addressNo = :addressNo")})
public class Address implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ID", nullable = false)
    private Short id;
    @Basic(optional = false)
    @Column(name = "PROVINCE_ID", nullable = false)
    private short provinceId;
    @Basic(optional = false)
    @Column(name = "ADDRESS_NO", nullable = false, length = 512)
    private String addressNo;
    @JoinColumn(name = "ADDRESS_TYPE", referencedColumnName = "ID", nullable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private AddressType addressType;
    @JoinColumn(name = "DISTRICT_ID", referencedColumnName = "ID", nullable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private ThDistrict districtId;
    @JoinColumn(name = "SUB_DISTRICT_ID", referencedColumnName = "ID", nullable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private ThSubdistrict subDistrictId;

    public Address() {
    }

    public Address(Short id) {
        this.id = id;
    }

    public Address(Short id, short provinceId, String addressNo) {
        this.id = id;
        this.provinceId = provinceId;
        this.addressNo = addressNo;
    }

    public Short getId() {
        return id;
    }

    public void setId(Short id) {
        this.id = id;
    }

    public short getProvinceId() {
        return provinceId;
    }

    public void setProvinceId(short provinceId) {
        this.provinceId = provinceId;
    }

    public String getAddressNo() {
        return addressNo;
    }

    public void setAddressNo(String addressNo) {
        this.addressNo = addressNo;
    }

    public AddressType getAddressType() {
        return addressType;
    }

    public void setAddressType(AddressType addressType) {
        this.addressType = addressType;
    }

    public ThDistrict getDistrictId() {
        return districtId;
    }

    public void setDistrictId(ThDistrict districtId) {
        this.districtId = districtId;
    }

    public ThSubdistrict getSubDistrictId() {
        return subDistrictId;
    }

    public void setSubDistrictId(ThSubdistrict subDistrictId) {
        this.subDistrictId = subDistrictId;
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
        if (!(object instanceof Address)) {
            return false;
        }
        Address other = (Address) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "newpackage.Address[ id=" + id + " ]";
    }
    
}
