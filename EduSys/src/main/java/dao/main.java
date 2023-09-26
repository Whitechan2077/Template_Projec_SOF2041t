/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import com.edusys.entity.ChuyenDe;
import com.edusys.entity.KhoaHoc;
import com.edusys.entity.NhanVien;
import utils.HibernateUtil;

/**
 *
 * @author buidu
 */
public class main {
    public static void main(String[] args) {
        NhanVienDao dao = new NhanVienDao(HibernateUtil.getFactory());
        KhoaHocDao dao1 = new KhoaHocDao(HibernateUtil.getFactory());
//        ChuyenDeDao cdd = new ChuyenDeDao(HibernateUtil.getFactory());
//        NhanVien nhanVien = new NhanVien();
//        nhanVien.setHoTen("Hoang Dung Rat ngu");
//        nhanVien.setMaNV("white");
//        nhanVien.setMatKhau("123");
//        nhanVien.setVaiTro(true);
//        dao.update(nhanVien);
//          dao.getAll().forEach((t) -> {
//              System.out.println(t.getMaNV());
//          });
//          System.out.println(dao.getByID("vuthuylinh").getHoTen());
//            ChuyenDe cd = cdd.getByID("C#");
//          dao1.getByMaCD(cd).forEach((t) -> {
//              System.out.println(t.getMaKH());
//          });
//          System.out.println(dao1.getByID(1).getNgayTao());
          NguoiHocDao nguoiHocDao = new NguoiHocDao(HibernateUtil.getFactory());
//          nguoiHocDao.getNguoiHoc().forEach((t) -> {
//              System.out.println(t.getHoTen());
//          });
          KhoaHoc kh = new KhoaHoc();
          kh.setMaKH(37);
          HocVienDao hocVienDao = new HocVienDao(HibernateUtil.getFactory());
          hocVienDao.getHocVienByKhoaHoc(kh).forEach((t) -> {
              System.out.println(t.getMaNH().getHoTen());
          });
    }
}
