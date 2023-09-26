/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.edusys.entity;

import jakarta.persistence.Basic;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.io.Serializable;
import java.util.Collection;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author buidu
 */
@Entity
@Table(name = "ChuyenDe")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ChuyenDe.findAll", query = "SELECT c FROM ChuyenDe c"),
    @NamedQuery(name = "ChuyenDe.findByMaCD", query = "SELECT c FROM ChuyenDe c WHERE c.maCD = :maCD"),
    @NamedQuery(name = "ChuyenDe.findByTenCD", query = "SELECT c FROM ChuyenDe c WHERE c.tenCD = :tenCD"),
    @NamedQuery(name = "ChuyenDe.findByHocPhi", query = "SELECT c FROM ChuyenDe c WHERE c.hocPhi = :hocPhi"),
    @NamedQuery(name = "ChuyenDe.findByThoiLuong", query = "SELECT c FROM ChuyenDe c WHERE c.thoiLuong = :thoiLuong"),
    @NamedQuery(name = "ChuyenDe.findByMota", query = "SELECT c FROM ChuyenDe c WHERE c.mota = :mota")})
public class ChuyenDe implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "MaCD")
    private String maCD;
    @Basic(optional = false)
    @Column(name = "TenCD")
    private String tenCD;
    @Basic(optional = false)
    @Column(name = "HocPhi")
    private double hocPhi;
    @Basic(optional = false)
    @Column(name = "ThoiLuong")
    private int thoiLuong;
    @Lob
    @Column(name = "Hinh")
    private byte[] hinh;
    @Column(name = "Mota")
    private String mota;
    @OneToMany(mappedBy = "maCD", fetch =FetchType.EAGER)
    private Collection<KhoaHoc> khoaHocCollection;

    public ChuyenDe() {
    }

    public ChuyenDe(String maCD) {
        this.maCD = maCD;
    }

    public ChuyenDe(String maCD, String tenCD, double hocPhi, int thoiLuong) {
        this.maCD = maCD;
        this.tenCD = tenCD;
        this.hocPhi = hocPhi;
        this.thoiLuong = thoiLuong;
    }

    public String getMaCD() {
        return maCD;
    }

    public void setMaCD(String maCD) {
        this.maCD = maCD;
    }

    public String getTenCD() {
        return tenCD;
    }

    public void setTenCD(String tenCD) {
        this.tenCD = tenCD;
    }

    public double getHocPhi() {
        return hocPhi;
    }

    public void setHocPhi(double hocPhi) {
        this.hocPhi = hocPhi;
    }

    public int getThoiLuong() {
        return thoiLuong;
    }

    public void setThoiLuong(int thoiLuong) {
        this.thoiLuong = thoiLuong;
    }

    public byte[] getHinh() {
        return hinh;
    }

    public void setHinh(byte[] hinh) {
        this.hinh = hinh;
    }

    public String getMota() {
        return mota;
    }

    public void setMota(String mota) {
        this.mota = mota;
    }

    @XmlTransient
    public Collection<KhoaHoc> getKhoaHocCollection() {
        return khoaHocCollection;
    }

    public void setKhoaHocCollection(Collection<KhoaHoc> khoaHocCollection) {
        this.khoaHocCollection = khoaHocCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (maCD != null ? maCD.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ChuyenDe)) {
            return false;
        }
        ChuyenDe other = (ChuyenDe) object;
        if ((this.maCD == null && other.maCD != null) || (this.maCD != null && !this.maCD.equals(other.maCD))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return tenCD;
    }
    
}
