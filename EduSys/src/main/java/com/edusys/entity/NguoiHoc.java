/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.edusys.entity;

import jakarta.persistence.Basic;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import org.hibernate.annotations.CreationTimestamp;

/**
 *
 * @author buidu
 */
@Entity
@Table(name = "NguoiHoc")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "NguoiHoc.findAll", query = "SELECT n FROM NguoiHoc n"),
    @NamedQuery(name = "NguoiHoc.findByMaNH", query = "SELECT n FROM NguoiHoc n WHERE n.maNH = :maNH"),
    @NamedQuery(name = "NguoiHoc.findByHoTen", query = "SELECT n FROM NguoiHoc n WHERE n.hoTen = :hoTen"),
    @NamedQuery(name = "NguoiHoc.findByGioiTinh", query = "SELECT n FROM NguoiHoc n WHERE n.gioiTinh = :gioiTinh"),
    @NamedQuery(name = "NguoiHoc.findByNgaySinh", query = "SELECT n FROM NguoiHoc n WHERE n.ngaySinh = :ngaySinh"),
    @NamedQuery(name = "NguoiHoc.findByDienThoai", query = "SELECT n FROM NguoiHoc n WHERE n.dienThoai = :dienThoai"),
    @NamedQuery(name = "NguoiHoc.findByEmail", query = "SELECT n FROM NguoiHoc n WHERE n.email = :email"),
    @NamedQuery(name = "NguoiHoc.findByGhiChu", query = "SELECT n FROM NguoiHoc n WHERE n.ghiChu = :ghiChu"),
    @NamedQuery(name = "NguoiHoc.findByNgayDangKi", query = "SELECT n FROM NguoiHoc n WHERE n.ngayDangKi = :ngayDangKi")})
public class NguoiHoc implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "MaNH")
    private String maNH;
    @Basic(optional = false)
    @Column(name = "HoTen")
    private String hoTen;
    @Basic(optional = false)
    @Column(name = "GioiTinh")
    private boolean gioiTinh;
    @Basic(optional = false)
    @Column(name = "NgaySinh")
    @Temporal(TemporalType.DATE)
    private Date ngaySinh;
    @Basic(optional = false)
    @Column(name = "DienThoai")
    private String dienThoai;
    @Basic(optional = false)
    @Column(name = "Email")
    private String email;
    @Column(name = "GhiChu")
    private String ghiChu;
    @CreationTimestamp
    @Column(name = "NgayDangKi")
    @Temporal(TemporalType.DATE)
    private Date ngayDangKi;
    @JoinColumn(name = "MaNV", referencedColumnName = "MaNV")
    @ManyToOne
    private NhanVien maNV;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "maNH")
    private Collection<HocVien> hocVienCollection;

    public NguoiHoc() {
    }

    public NguoiHoc(String maNH) {
        this.maNH = maNH;
    }

    public NguoiHoc(String maNH, String hoTen, boolean gioiTinh, Date ngaySinh, String dienThoai, String email) {
        this.maNH = maNH;
        this.hoTen = hoTen;
        this.gioiTinh = gioiTinh;
        this.ngaySinh = ngaySinh;
        this.dienThoai = dienThoai;
        this.email = email;
    }
    
    public String getMaNH() {
        return maNH;
    }

    public void setMaNH(String maNH) {
        this.maNH = maNH;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public boolean getGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(boolean gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public Date getNgaySinh() {
        return ngaySinh;
    }

    public void setNgaySinh(Date ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    public String getDienThoai() {
        return dienThoai;
    }

    public void setDienThoai(String dienThoai) {
        this.dienThoai = dienThoai;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGhiChu() {
        return ghiChu;
    }

    public void setGhiChu(String ghiChu) {
        this.ghiChu = ghiChu;
    }

    public Date getNgayDangKi() {
        return ngayDangKi;
    }

    public void setNgayDangKi(Date ngayDangKi) {
        this.ngayDangKi = ngayDangKi;
    }

    public NhanVien getMaNV() {
        return maNV;
    }

    public void setMaNV(NhanVien maNV) {
        this.maNV = maNV;
    }

    @XmlTransient
    public Collection<HocVien> getHocVienCollection() {
        return hocVienCollection;
    }

    public void setHocVienCollection(Collection<HocVien> hocVienCollection) {
        this.hocVienCollection = hocVienCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (maNH != null ? maNH.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof NguoiHoc)) {
            return false;
        }
        NguoiHoc other = (NguoiHoc) object;
        if ((this.maNH == null && other.maNH != null) || (this.maNH != null && !this.maNH.equals(other.maNH))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return maNH;
    }
    
}
