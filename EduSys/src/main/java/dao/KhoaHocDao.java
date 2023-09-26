/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import com.edusys.entity.ChuyenDe;
import com.edusys.entity.KhoaHoc;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
/**
 *
 * @author buidu
 */
public class KhoaHocDao implements DAO<KhoaHoc, Integer>{
    private SessionFactory factory;
    private ChuyenDe cd;
    public KhoaHocDao(SessionFactory factory) {
        this.factory = factory;
    }

    @Override
    public void insert(KhoaHoc e) {
        Transaction transaction = null;
        try (Session session = factory.openSession()) {
             transaction = session.getTransaction();
            transaction.begin();
            session.persist(e);
            transaction.commit();
        }
        catch(Exception ex){
            transaction.rollback();
        }
    }

    @Override
    public void delete(KhoaHoc e) {
         Transaction transaction = null;
        try (Session session = factory.openSession()) {
            transaction = session.getTransaction();
            transaction.begin();
            transaction.commit();
        }catch(Exception ex){
            transaction.rollback();
        }
    }

    @Override
    public void update(KhoaHoc e) {
        Transaction transaction = null;
        try (Session session = factory.openSession()) {
            transaction = session.getTransaction();
            transaction.begin();
            session.merge(e);
            transaction.commit();
        }catch(Exception ex){
            transaction.rollback();
        }
    }

    @Override
    public List<KhoaHoc> getAll() {
        Query<KhoaHoc> q;
        try (Session session = factory.openSession()) {
            q = session.getNamedQuery("KhoaHoc.findAll");
        }
        return  q.getResultList();
    }

    @Override
    public KhoaHoc getByID(Integer id) {
        try (Session session = factory.openSession()) {
            return  session.get(KhoaHoc.class, id);
        }
    }
    public List<KhoaHoc> getByMaCD(ChuyenDe cd){
        try (Session session = factory.openSession()) {
            cd = session.get(ChuyenDe.class, cd.getMaCD());
            return (List<KhoaHoc>) cd.getKhoaHocCollection();
        }
    }
}
