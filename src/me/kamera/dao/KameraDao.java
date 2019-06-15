/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package me.kamera.dao;

import java.util.List;
import me.kamera.model.Kamera;

/**
 *
 * @author FERY
 */
public interface KameraDao {
    
    public void save(Kamera kamera);
    public void delete(Kamera kamera);
    public void update(Kamera kamera);
    public List<Kamera> getList();
    
}
