/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package dao;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 *
 * @author buidu
 * @param <E>
 * @param <K>
 */
public interface DAO<E,K> {
    public void insert(E e);
    public void delete(E e);
    public void update(E e);
    public List<E> getAll();
    public E getByID(K id);
}
