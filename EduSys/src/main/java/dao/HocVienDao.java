/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import com.edusys.entity.HocVien;
import com.edusys.entity.KhoaHoc;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

/**
 *
 * @author buidu
 */
public class HocVienDao implements DAO<HocVien, Integer>{
    private final SessionFactory factory;


    public HocVienDao(SessionFactory factory) {
        this.factory = factory;
    }

    @Override
    public void insert(HocVien e) {
        Transaction transaction = null;
        try (Session s = factory.openSession()){
        transaction = s.getTransaction();
        transaction.begin();
        s.persist(e);
        transaction.commit();
        } catch (Exception ex) {
            transaction.rollback();
            ex.printStackTrace();
        }
    }

    @Override
    public void delete(HocVien e) {
        Transaction transaction = null;
        try (Session s = factory.openSession()){
        transaction = s.getTransaction();
        transaction.begin();
        s.remove(e);
        transaction.commit();
        } catch (Exception ex) {
            transaction.rollback();
                        ex.printStackTrace();

        }
    }

    @Override
    public void update(HocVien e) {
    Transaction transaction = null;
        try (Session s = factory.openSession()){
        transaction = s.getTransaction();
        transaction.begin();
        s.merge(e);
        transaction.commit();
        } catch (Exception ex) {
            transaction.rollback();
                        ex.printStackTrace();

        }
    }

    @Override
    public List<HocVien> getAll() {
        try(Session s = factory.openSession()) {
             Query<HocVien> q = s.getNamedQuery("HocVien.findAll");
        return q.getResultList();
        }   
    }

    @Override
    public HocVien getByID(Integer id) {
         try (Session session = factory.openSession()){
               Query<HocVien> q = session.getNamedQuery("HocVien.findAll");
                q.setParameter("maHV", id);
                return q.getSingleResult();
         }
    }
    public List<HocVien> getHocVienByKhoaHoc(KhoaHoc kh){
        List<HocVien> l;
        try (Session session = factory.openSession()) {
           l =  (List<HocVien>) session.get(KhoaHoc.class,kh.getMaKH()).getHocVienCollection();
        }
        return l;
    }
}
