/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package me.kamera.dao;

import java.util.List;
import me.kamera.model.Kamera;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author FERY
 */
@Repository
public class KameraDaoImpl implements KameraDao {
    
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void save(Kamera kamera) {
        sessionFactory.getCurrentSession().save(kamera); 
    }

    @Override
    public void delete(Kamera kamera) {
       sessionFactory.getCurrentSession().delete(kamera);
    }

    @Override
    public void update(Kamera kamera) {
         sessionFactory.getCurrentSession().update(kamera);
    }

    @Override
    public List<Kamera> getList() {
        return sessionFactory.getCurrentSession().createCriteria(Kamera.class).list();
    }
    
}
