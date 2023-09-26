/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import com.edusys.entity.ChuyenDe;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

/**
 *
 * @author buidu
 */
public class ChuyenDeDao implements DAO<ChuyenDe, String> {

    private final SessionFactory factory;

    public ChuyenDeDao(SessionFactory factory) {
        this.factory = factory;
    }

    @Override
    public void insert(ChuyenDe e) {
        Transaction transaction = null;
        try (Session session = factory.openSession()) {
            transaction = session.getTransaction();
            transaction.begin();
            session.persist(e);
            transaction.commit();
        } catch (Exception ex) {
            transaction.rollback();
        }
    }

    @Override
    public void delete(ChuyenDe e) {
        Transaction transaction = null;
        try (Session session = factory.openSession()) {
            transaction = session.getTransaction();
            transaction.begin();
            session.remove(e);
            transaction.commit();
        } catch (Exception ex) {
            transaction.rollback();
        }
    }

    @Override
    public void update(ChuyenDe e) {
        Transaction transaction = null;
        try (Session session = factory.openSession()) {
            transaction = session.getTransaction();
            transaction.begin();
            session.merge(e);
            transaction.commit();
        } catch (Exception ex) {
            transaction.rollback();
        }

    }

    @Override
    public List<ChuyenDe> getAll() {
        try (Session session = factory.openSession()) {
            Query<ChuyenDe> query = session.getNamedQuery("ChuyenDe.findAll");
            return query.getResultList();
        }
    }

    @Override
    public ChuyenDe getByID(String id) {
        try (Session session = factory.openSession()) {
            Query<ChuyenDe> q = session.getNamedQuery("ChuyenDe.findByMaCD");
            q.setParameter("maCD", id);
            return q.getSingleResult();
        }
    }
}
