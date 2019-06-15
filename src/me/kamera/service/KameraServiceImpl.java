/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package me.kamera.service;

import java.util.List;
import me.kamera.dao.KameraDao;
import me.kamera.model.Kamera;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author FERY
 */
@Service("KameraService")
@Transactional(readOnly = false)
public class KameraServiceImpl implements KameraService{
    
    @Autowired
    private KameraDao kameradao;
     
    @Transactional
    @Override
    public void save(Kamera kamera) {
        kameradao.save(kamera);
    }

    @Transactional
    @Override
    public void delete(Kamera kamera) {
        kameradao.delete(kamera);
    }

    @Transactional
    @Override
    public void update(Kamera kamera) {
        kameradao.update(kamera);
    }

    @Override
    public List<Kamera> getList() {
        return kameradao.getList();
    }
    
}
