/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import com.edusys.entity.HocVien;
import com.edusys.entity.KhoaHoc;
import com.edusys.entity.NguoiHoc;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

/**
 *
 * @author buidu
 */
public class NguoiHocDao implements DAO<NguoiHoc, String>{
    private SessionFactory factory;

    
    public NguoiHocDao(SessionFactory factory) {
        this.factory = factory;
    }

    @Override
    public void insert(NguoiHoc e) {
        Transaction transaction = null;
        try (Session session = factory.openSession()) {
            transaction = session.getTransaction();
            transaction.begin();
            session.persist(e);
            transaction.commit();
        }
    }

    @Override
    public void delete(NguoiHoc e) {
   Transaction transaction = null;
        try (Session session = factory.openSession()) {
            transaction = session.getTransaction();
            transaction.begin();
            session.remove(e);
            transaction.commit();
        }   }

    @Override
    public void update(NguoiHoc e) {
 Transaction transaction = null;
        try (Session session = factory.openSession()) {
            transaction = session.getTransaction();
            transaction.begin();
            session.merge(e);
            transaction.commit();
        };    }

    @Override
    public List<NguoiHoc> getAll() {
        try (Session session = factory.openSession()) {
            Query<NguoiHoc> q = session.getNamedQuery("NguoiHoc.findAll");
            return  q.getResultList();
        }
    }

    @Override
    public NguoiHoc getByID(String id) {
        try (Session session = factory.openSession()) {
            Query<NguoiHoc> q = session.getNamedQuery("NguoiHoc.findByMaNH");
            q.setParameter("maNH", id);
            return q.getSingleResult();
        }
    }
    public List<NguoiHoc>getNguoiHoc(){
        try (Session session = factory.openSession()) {
            return session.createQuery("SELECT nh FROM NguoiHoc nh WHERE nh NOT IN (SELECT hv.maNH FROM HocVien hv)").getResultList();
        }
    }
}
