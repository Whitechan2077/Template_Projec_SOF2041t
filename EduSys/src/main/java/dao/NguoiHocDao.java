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
    private Session session;
    private SessionFactory factory;
    private Transaction transaction;

    
    public NguoiHocDao(SessionFactory factory) {
        this.factory = factory;
        this.session = factory.openSession();
        this.transaction = session.getTransaction();
    }

    @Override
    public void insert(NguoiHoc e) {
        transaction.begin();
        session.persist(e);
        transaction.commit();
    }

    @Override
    public void delete(NguoiHoc e) {
       transaction.begin();
       session.remove(e);
       transaction.commit();    }

    @Override
    public void update(NguoiHoc e) {
       transaction.begin();
       session.merge(e);
       transaction.commit();    }

    @Override
    public List<NguoiHoc> getAll() {
         Query<NguoiHoc> q = session.getNamedQuery("NguoiHoc.findAll");
         return  q.getResultList();
    }

    @Override
    public NguoiHoc getByID(String id) {
        Query<NguoiHoc> q = session.getNamedQuery("NguoiHoc.findByMaNH");
        q.setParameter("maNH", id);
        return q.getSingleResult();
    }
    public List<NguoiHoc>getNguoiHoc(){
        return session.createQuery("SELECT nh FROM NguoiHoc nh WHERE nh NOT IN (SELECT hv.maNH FROM HocVien hv)").getResultList();
    }
}
