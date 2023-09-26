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
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
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
@Table(name = "KhoaHoc")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "KhoaHoc.findAll", query = "SELECT k FROM KhoaHoc k"),
    @NamedQuery(name = "KhoaHoc.findByMaKH", query = "SELECT k FROM KhoaHoc k WHERE k.maKH = :maKH"),
    @NamedQuery(name = "KhoaHoc.findByHocPhi", query = "SELECT k FROM KhoaHoc k WHERE k.hocPhi = :hocPhi"),
    @NamedQuery(name = "KhoaHoc.findByThoiLuong", query = "SELECT k FROM KhoaHoc k WHERE k.thoiLuong = :thoiLuong"),
    @NamedQuery(name = "KhoaHoc.findByNgayKG", query = "SELECT k FROM KhoaHoc k WHERE k.ngayKG = :ngayKG"),
    @NamedQuery(name = "KhoaHoc.findByGhiChu", query = "SELECT k FROM KhoaHoc k WHERE k.ghiChu = :ghiChu"),
    @NamedQuery(name = "KhoaHoc.findByNgayTao", query = "SELECT k FROM KhoaHoc k WHERE k.ngayTao = :ngayTao")})
public class KhoaHoc implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "MaKH")
    private Integer maKH;
    @Basic(optional = false)
    @Column(name = "HocPhi")
    private double hocPhi;
    @Basic(optional = false)
    @Column(name = "ThoiLuong")
    private int thoiLuong;
    @Basic(optional = false)
    @Column(name = "NgayKG")
    @Temporal(TemporalType.DATE)
    private Date ngayKG;
    @Column(name = "GhiChu")
    private String ghiChu;
    @CreationTimestamp
    @Column(name = "NgayTao")
    @Temporal(TemporalType.DATE)
    private Date ngayTao;
    @JoinColumn(name = "MaCD", referencedColumnName = "MaCD")
    @ManyToOne(optional = false) 
    private ChuyenDe maCD;
    @JoinColumn(name = "MaNV", referencedColumnName = "MaNV")
    @ManyToOne
    private NhanVien maNV;
    @OneToMany(mappedBy = "maKH",fetch = FetchType.EAGER)
    private Collection<HocVien> hocVienCollection;

    public KhoaHoc() {
    }

    public KhoaHoc(Integer maKH) {
        this.maKH = maKH;
    }

    public KhoaHoc(Integer maKH, double hocPhi, int thoiLuong, Date ngayKG) {
        this.maKH = maKH;
        this.hocPhi = hocPhi;
        this.thoiLuong = thoiLuong;
        this.ngayKG = ngayKG;
    }

    public Integer getMaKH() {
        return maKH;
    }

    public void setMaKH(Integer maKH) {
        this.maKH = maKH;
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

    public Date getNgayKG() {
        return ngayKG;
    }

    public void setNgayKG(Date ngayKG) {
        this.ngayKG = ngayKG;
    }

    public String getGhiChu() {
        return ghiChu;
    }

    public void setGhiChu(String ghiChu) {
        this.ghiChu = ghiChu;
    }

    public Date getNgayTao() {
        return ngayTao;
    }

    public void setNgayTao(Date ngayTao) {
        this.ngayTao = ngayTao;
    }

    public ChuyenDe getMaCD() {
        return maCD;
    }

    public void setMaCD(ChuyenDe maCD) {
        this.maCD = maCD;
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
        hash += (maKH != null ? maKH.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof KhoaHoc)) {
            return false;
        }
        KhoaHoc other = (KhoaHoc) object;
        if ((this.maKH == null && other.maKH != null) || (this.maKH != null && !this.maKH.equals(other.maKH))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return  maCD.getTenCD()+" ("+ngayKG.toString()+")";
    }
    
}
