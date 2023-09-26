/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.edusys.entity;

import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
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
@Table(name = "NhanVien")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "NhanVien.findAll", query = "SELECT n FROM NhanVien n"),
    @NamedQuery(name = "NhanVien.findByMaNV", query = "SELECT n FROM NhanVien n WHERE n.maNV = :maNV"),
    @NamedQuery(name = "NhanVien.findByMatKhau", query = "SELECT n FROM NhanVien n WHERE n.matKhau = :matKhau"),
    @NamedQuery(name = "NhanVien.findByHoTen", query = "SELECT n FROM NhanVien n WHERE n.hoTen = :hoTen"),
    @NamedQuery(name = "NhanVien.findByVaiTro", query = "SELECT n FROM NhanVien n WHERE n.vaiTro = :vaiTro")})
public class NhanVien implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "MaNV")
    private String maNV;
    @Column(name = "MatKhau")
    private String matKhau;
    @Column(name = "HoTen")
    private String hoTen;
    @Column(name = "VaiTro")
    private Boolean vaiTro;
    @OneToMany(mappedBy = "maNV")
    private Collection<NguoiHoc> nguoiHocCollection;
    @OneToMany(mappedBy = "maNV")
    private Collection<KhoaHoc> khoaHocCollection;

    public NhanVien() {
    }

    public NhanVien(String maNV) {
        this.maNV = maNV;
    }

    public String getMaNV() {
        return maNV;
    }

    public void setMaNV(String maNV) {
        this.maNV = maNV;
    }

    public String getMatKhau() {
        return matKhau;
    }

    public void setMatKhau(String matKhau) {
        this.matKhau = matKhau;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public Boolean getVaiTro() {
        return vaiTro;
    }

    public void setVaiTro(Boolean vaiTro) {
        this.vaiTro = vaiTro;
    }

    @XmlTransient
    public Collection<NguoiHoc> getNguoiHocCollection() {
        return nguoiHocCollection;
    }

    public void setNguoiHocCollection(Collection<NguoiHoc> nguoiHocCollection) {
        this.nguoiHocCollection = nguoiHocCollection;
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
        hash += (maNV != null ? maNV.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof NhanVien)) {
            return false;
        }
        NhanVien other = (NhanVien) object;
        if ((this.maNV == null && other.maNV != null) || (this.maNV != null && !this.maNV.equals(other.maNV))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.edusys.entity.NhanVien[ maNV=" + maNV + " ]";
    }
    
}
