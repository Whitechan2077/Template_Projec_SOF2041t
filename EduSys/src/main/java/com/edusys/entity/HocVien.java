/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.edusys.entity;

import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.Table;
import java.io.Serializable;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author buidu
 */
@Entity
@Table(name = "HocVien")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "HocVien.findAll", query = "SELECT h FROM HocVien h"),
    @NamedQuery(name = "HocVien.findByMaHV", query = "SELECT h FROM HocVien h WHERE h.maHV = :maHV"),
    @NamedQuery(name = "HocVien.findByDiem", query = "SELECT h FROM HocVien h WHERE h.diem = :diem")})
public class HocVien implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "MaHV")
    private Integer maHV;
    @Basic(optional = false)
    @Column(name = "Diem")
    private double diem;
    @JoinColumn(name = "MaKH", referencedColumnName = "MaKH")
    @ManyToOne(optional = false)
    private KhoaHoc maKH;
    @JoinColumn(name = "MaNH", referencedColumnName = "MaNH")
    @ManyToOne(optional = false)
    private NguoiHoc maNH;

    public HocVien() {
    }

    public HocVien(Integer maHV) {
        this.maHV = maHV;
    }

    public HocVien(Integer maHV, double diem) {
        this.maHV = maHV;
        this.diem = diem;
    }

    public Integer getMaHV() {
        return maHV;
    }

    public void setMaHV(Integer maHV) {
        this.maHV = maHV;
    }
    
    public double getDiem() {
        return diem;
    }

    public void setDiem(double diem) {
        this.diem = diem;
    }

    public KhoaHoc getMaKH() {
        return maKH;
    }

    public void setMaKH(KhoaHoc maKH) {
        this.maKH = maKH;
    }

    public NguoiHoc getMaNH() {
        return maNH;
    }

    public void setMaNH(NguoiHoc maNH) {
        this.maNH = maNH;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (maHV != null ? maHV.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof HocVien)) {
            return false;
        }
        HocVien other = (HocVien) object;
        if ((this.maHV == null && other.maHV != null) || (this.maHV != null && !this.maHV.equals(other.maHV))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.edusys.entity.HocVien[ maHV=" + maHV + " ]";
    }
    
}
