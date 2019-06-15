/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package me.kamera.model;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author FERY
 */
public class KameraTableModel extends AbstractTableModel {
    
     private List<Kamera> listKamera = new ArrayList<>();
     private final String HEADER[] = {"IdKamera", "Merek", "Jenis", "Kategori", "Harga","Tanggal"};
     
     public KameraTableModel(List<Kamera> listKamera) {
        this.listKamera = listKamera;
    }

    @Override
    public int getRowCount() {
        return this.listKamera.size();
    }

    @Override
    public int getColumnCount() {
        return this.HEADER.length;
    }
    
     @Override
    public String getColumnName(int column) {
        return HEADER[column];
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
       Kamera kamera = listKamera.get(rowIndex);

        switch (columnIndex) {
            case 0:
                return kamera.getIdKamera();
            case 1:
                return kamera.getMerek();
            case 2:
                return kamera.getJenis();
            case 3:
                return kamera.getKategori();
            case 4:
                return kamera.getHarga();
            case 5:
                return kamera.getTanggal();
            default:
                return null;
        }
    
    }
}
