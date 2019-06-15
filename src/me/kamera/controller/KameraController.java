/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package me.kamera.controller;

import java.util.List;
import javax.swing.JOptionPane;
import static me.app.MainApp.getKameraService;
import me.kamera.model.Kamera;
import me.kamera.model.KameraTableModel;
import me.kamera.view.MainView;

/**
 *
 * @author FERY
 */
public class KameraController {
    
    private final MainView mainView;
    private List<Kamera> listKamera;
    private KameraTableModel kameraTableModel;
    
     public KameraController(MainView mainView) {
        this.mainView = mainView;
    }
     
      public void clear() {
        this.mainView.getTxtKode().setText("");
        this.mainView.getTxtMerek().setText("");
        this.mainView.getTxtJenis().setText("");
        this.mainView.getTxtKategori().setText("");
        this.mainView.getTxtHarga().setText("");
        this.mainView.getTxtTanggal().setText("");
    }
      
      public void InsertData() {
        Kamera kamera = new Kamera();
        kamera.setIdKamera(mainView.getTxtKode().getText());
        kamera.setMerek(mainView.getTxtMerek().getText());
        kamera.setJenis(mainView.getTxtJenis().getText());
        kamera.setKategori(mainView.getTxtKategori().getText());
        kamera.setHarga(Integer.parseInt(mainView.getTxtHarga().getText()));
        kamera.setTanggal(mainView.getTxtTanggal().getText());
        
        try {
            getKameraService().save(kamera);
            JOptionPane.showMessageDialog(null, "Berhasil menyimpan data!",
                    "Success", JOptionPane.INFORMATION_MESSAGE);
            clear();
            showData();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Gagal saat menyimpan data!",
                    "Error", JOptionPane.ERROR_MESSAGE);
            clear();
        }
    }
      public void UpdateData() {
        Kamera kamera = new Kamera();
        kamera.setIdKamera(mainView.getTxtKode().getText());
        kamera.setMerek(mainView.getTxtMerek().getText());
        kamera.setJenis(mainView.getTxtJenis().getText());
        kamera.setKategori(mainView.getTxtKategori().getText());
        kamera.setHarga(Integer.parseInt(mainView.getTxtHarga().getText()));
        kamera.setTanggal(mainView.getTxtTanggal().getText());
        
        try {
            getKameraService().update(kamera);
            JOptionPane.showMessageDialog(null, "Berhasil menyimpan data!",
                    "Success", JOptionPane.INFORMATION_MESSAGE);
            clear();
            showData();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Gagal saat menyimpan data!",
                    "Error", JOptionPane.ERROR_MESSAGE);
            clear();
        }
    }
      public void DeleteData() {
        if (this.mainView.getTxtKode().getText() == null) {
            JOptionPane.showMessageDialog(null, "Data belum dipilih tjuy!",
                    "Error", JOptionPane.ERROR_MESSAGE);
        } else {
            Kamera kamera = new Kamera();
            kamera.setIdKamera(this.mainView.getTxtKode().getText());

            int confirm = JOptionPane.showConfirmDialog(null, "Apakah anda yakin ingin menghapus data?",
                    "Warning", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);

            if (confirm == JOptionPane.YES_OPTION) {
                try {
                    getKameraService().delete(kamera);
                    JOptionPane.showMessageDialog(null, "Berhasil menghapus data!",
                            "Success", JOptionPane.INFORMATION_MESSAGE);
                    clear();
                    showData();
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, "Gagal saat menghapus data!",
                            "Error", JOptionPane.ERROR_MESSAGE);
                    clear();
                }
            }
        }
    }

    public void showData() {
        listKamera = getKameraService().getList();
        kameraTableModel = new KameraTableModel(listKamera);
        this.mainView.getTblKamera().setModel(kameraTableModel);
    }
    
     public void getData() {
        int index = this.mainView.getTblKamera().getSelectedRow();
        this.mainView.getTxtKode().setText(String.valueOf(this.mainView.getTblKamera().getValueAt(index, 0)));
        this.mainView.getTxtMerek().setText(String.valueOf(this.mainView.getTblKamera().getValueAt(index, 1)));
        this.mainView.getTxtJenis().setText(String.valueOf(this.mainView.getTblKamera().getValueAt(index, 2)));
        this.mainView.getTxtKategori().setText(String.valueOf(this.mainView.getTblKamera().getValueAt(index, 3)));
        this.mainView.getTxtHarga().setText(String.valueOf(this.mainView.getTblKamera().getValueAt(index, 4)));
        this.mainView.getTxtTanggal().setText(String.valueOf(this.mainView.getTblKamera().getValueAt(index, 5)));
    }

}
