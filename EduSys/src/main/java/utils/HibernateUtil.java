/*
 * Click nbfs://nbhos
t/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Hibernate/HibernateUtil.java to edit this template
 */
package utils;

import com.edusys.entity.ChuyenDe;
import com.edusys.entity.HocVien;
import com.edusys.entity.KhoaHoc;
import com.edusys.entity.NguoiHoc;
import com.edusys.entity.NhanVien;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
/**
 * Hibernate Utility class with a convenient method to get Session Factory
 * object.
 *
 * @author buidu
 */
public class HibernateUtil {

    private static final SessionFactory sessionFactory;
        
    static{
        Configuration configuration = new Configuration();
        configuration.configure("hibernate.cfg.xml");
        configuration.addAnnotatedClass(NhanVien.class);
        configuration.addAnnotatedClass(HocVien.class);
        configuration.addAnnotatedClass(ChuyenDe.class);
        configuration.addAnnotatedClass(KhoaHoc.class);
        configuration.addAnnotatedClass(NguoiHoc.class);
        sessionFactory = configuration.buildSessionFactory();
    }
    public static SessionFactory getFactory(){
        return sessionFactory;
    }
    public static void main(String[] args) {
        getFactory();
    }
}
