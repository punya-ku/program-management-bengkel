/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bengkel_Master;

import Koneksi.Koneksi;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Ari
 */
public class Mekanik_Bengkel extends javax.swing.JFrame {
    private Connection conn = new Koneksi().connect();
    private DefaultTableModel tabmodel;
    String sql, code, name, alamat, telepon, kd, angka, nol;
    //String[] data;
    PreparedStatement ps;
    Statement st;
    ResultSet rs;
    /**
     * Creates new form Mekanik_Bengkel
     */
    public Mekanik_Bengkel() {
        initComponents();
        autoNumber();
        off();
        datatable();
        this.setLocationRelativeTo(null);
    }

    public void datatable(){
        Object[] Baris={"Kode", "Nama", "Alamat", "Telpon"};
        tabmodel = new DefaultTableModel(null, Baris);
        tblmekanik.setModel(tabmodel);
        sql = "select * from mekanik";
        try{
            st=conn.createStatement();
            rs=st.executeQuery(sql);
            while(rs.next()){
                code=rs.getString("kd_mekanik");
                name=rs.getString("nama_mekanik");
                alamat=rs.getString("alamat");
                telepon=rs.getString("no_telp");
                String[] data={code, name, alamat, telepon};
                tabmodel.addRow(data);
            }
        }catch(SQLException e){
            System.out.println("Kesalahan Query");
        }
    }
    
    public void reset(){
        nama.setText("");
        asal.setText("");
        hp.setText("");
        simpan.setEnabled(true);
        edit.setEnabled(false);
        hapus.setEnabled(false);
    }
    
    public void on(){
        asal.setEnabled(true);
        nama.setEnabled(true);
        hp.setEnabled(true);
        kode.requestFocus();
    }
    
    public void off(){
        kode.setEnabled(false);
        nama.setEnabled(false);
        asal.setEnabled(false);
        hp.setEnabled(false);
    }
    
    public void autoNumber(){
        try {
            sql = "SELECT * FROM mekanik ORDER BY kd_mekanik DESC";
            ps = conn.prepareCall(sql);
            rs = ps.executeQuery(sql);
            if (rs.next()) {
                kd = rs.getString("kd_mekanik").substring(2);
                angka =  "" + (Integer.parseInt(kd) + 1);
                nol = "";

                if (angka.length()==1) {
                    nol = "000";
                } else if (angka.length()==2) {
                    nol = "00";
                } else if (angka.length()==3) {
                    nol = "0";
                } else if (angka.length()==4) {
                    nol = "";
                }
                kode.setText("M" + nol + angka);
            } else {
                kode.setText("M0001");
            }
            rs.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        hp = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        asal = new javax.swing.JTextArea();
        nama = new javax.swing.JTextField();
        kode = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblmekanik = new javax.swing.JTable();
        simpan = new javax.swing.JButton();
        edit = new javax.swing.JButton();
        hapus = new javax.swing.JButton();
        reset = new javax.swing.JButton();
        keluar = new javax.swing.JButton();
        tcari = new javax.swing.JTextField();
        cari = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Kode");

        jLabel2.setText("Nama");

        jLabel3.setText("Alamat");

        jLabel4.setText("No. Hp");

        hp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                hpActionPerformed(evt);
            }
        });

        asal.setColumns(20);
        asal.setRows(5);
        jScrollPane1.setViewportView(asal);

        tblmekanik.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tblmekanik.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblmekanikMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tblmekanik);

        simpan.setText("Tambah");
        simpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                simpanActionPerformed(evt);
            }
        });

        edit.setText("Edit");
        edit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editActionPerformed(evt);
            }
        });

        hapus.setText("Hapus");
        hapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                hapusActionPerformed(evt);
            }
        });

        reset.setText("Reset");
        reset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                resetActionPerformed(evt);
            }
        });

        keluar.setText("Keluar");
        keluar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                keluarActionPerformed(evt);
            }
        });

        cari.setText("Cari");
        cari.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cariActionPerformed(evt);
            }
        });

        jLabel5.setText("Data Mekanik Bengkel Cihuy");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(294, 294, 294)
                .addComponent(jLabel5)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(keluar))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1)
                            .addComponent(jLabel4))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(57, 57, 57)
                                .addComponent(reset)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(simpan))
                            .addComponent(hp)
                            .addComponent(nama)
                            .addComponent(kode)
                            .addComponent(jScrollPane1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(edit)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(hapus)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(tcari, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cari))
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 452, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(19, 19, 19))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 43, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(tcari, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cari)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(kode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(nama, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(hp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(reset)
                            .addComponent(edit)
                            .addComponent(simpan)
                            .addComponent(hapus))))
                .addGap(43, 43, 43)
                .addComponent(keluar)
                .addGap(55, 55, 55))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void resetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_resetActionPerformed
        // TODO add your handling code here:
        reset();
    }//GEN-LAST:event_resetActionPerformed

    private void tblmekanikMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblmekanikMouseClicked
        // TODO add your handling code here:
        String a,b,c,d;
        edit.setEnabled(true);
        edit.setText("Edit");
        hapus.setEnabled(true);
        int bar = tblmekanik.getSelectedRow();
        a = tabmodel.getValueAt(bar, 0).toString();
        b = tabmodel.getValueAt(bar, 1).toString();
        c = tabmodel.getValueAt(bar, 2).toString();
        d = tabmodel.getValueAt(bar, 3).toString();
        kode.setText(a);
        nama.setText(b);
        asal.setText(c);
        hp.setText(d);
    }//GEN-LAST:event_tblmekanikMouseClicked

    private void editActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editActionPerformed
        // TODO add your handling code here:
        if (edit.getText()=="Edit") {
            on();
            edit.setText("Update");
            hapus.setEnabled(false);
            simpan.setEnabled(false);
        } else {
            sql = "update mekanik set nm_mekanik=?, alamat=?, no_telepon=? where kd_mekanik='"+kode.getText()+"'";
            try {
                ps = conn.prepareStatement(sql);
                ps.setString(1, nama.getText());
                ps.setString(2, asal.getText());
                ps.setString(3, hp.getText());
                ps.executeUpdate();
                JOptionPane.showMessageDialog(null, "Data mekanik berhasil Di Update");
                edit.setText("Edit");
                datatable();
                reset();
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Data Gagal Di Update" + e);
            }
        }
    }//GEN-LAST:event_editActionPerformed

    private void simpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_simpanActionPerformed
        // TODO add your handling code here:
        String tombol = simpan.getText();
        if (tombol.equals("Tambah")) {
            on();
            reset();
            simpan.setText("Simpan");
            edit.setEnabled(false);
            hapus.setEnabled(false);
        } else {
            sql = "insert into mekanik values(?,?,?,?)";
            try {
                ps = conn.prepareStatement(sql);
                ps.setString(1, kode.getText());
                ps.setString(2, nama.getText());
                ps.setString(3, asal.getText());
                ps.setString(4, hp.getText());
                ps.executeUpdate();
                JOptionPane.showMessageDialog(null, "Data mekanik Berhasil Disimpan");
                reset();
                autoNumber();
                kode.requestFocus();
                datatable();
            } catch (SQLException e) {
                JOptionPane.showConfirmDialog(null, "Data mekanik gagal disimpan" + e);
            }
            simpan.setText("Tambah");
            off();
        }
    }//GEN-LAST:event_simpanActionPerformed

    private void hapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hapusActionPerformed
        // TODO add your handling code here:
        int ok = JOptionPane.showConfirmDialog(null, "Apakah Anda Yakin ingin Menghapus Data Ini?", "Konfirmasi Dialog", JOptionPane.YES_NO_OPTION);
        if (ok == 0) {
            sql = "delete from mekanik where kd_mekanik='"+kode.getText() + "'";
            try {
                ps = conn.prepareStatement(sql);
                ps.executeUpdate();
                JOptionPane.showMessageDialog(null, "Data mekanik Berhasil Dihapus");
                reset();
                kode.requestFocus();
                datatable();
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Data Gagal Di Hapus" + e);
            }
        }
    }//GEN-LAST:event_hapusActionPerformed

    private void keluarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_keluarActionPerformed
        // TODO add your handling code here:
        new MenuUtama().setVisible(true);
        dispose();
    }//GEN-LAST:event_keluarActionPerformed

    private void cariActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cariActionPerformed
        // TODO add your handling code here:
        String tombol = cari.getText();
        if (tombol.equals("Cari")){
        Object[] Baris = {"Kode", "Nama", "Alamat", "Telepon"};
        tabmodel = new DefaultTableModel(null, Baris);
        tblmekanik.setModel(tabmodel);
        String sql = "Select * from mekanik where kd_mekanik like '%" + tcari.getText() + "%'" +
            "or nama_mekanik like '%" + tcari.getText() + "%'";
        try {
            st = conn.createStatement();
            rs = st.executeQuery(sql);
            while (rs.next()) {
                code = rs.getString("kd_mekanik");
                name = rs.getString("nama_mekanik");
                alamat = rs.getString("alamat");
                telepon = rs.getString("no_telp");
                String[] data = {code,name,alamat,telepon};
                tabmodel.addRow(data);
            }
        } catch (Exception e) {
        }
         cari.setText("Batal");
    }else{
            datatable();
            cari.setText("Cari");
            tcari.setText("");
            simpan.setEnabled(true);
        }
    }//GEN-LAST:event_cariActionPerformed

    private void hpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hpActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_hpActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Mekanik_Bengkel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Mekanik_Bengkel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Mekanik_Bengkel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Mekanik_Bengkel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Mekanik_Bengkel().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea asal;
    private javax.swing.JButton cari;
    private javax.swing.JButton edit;
    private javax.swing.JButton hapus;
    private javax.swing.JTextField hp;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JButton keluar;
    private javax.swing.JTextField kode;
    private javax.swing.JTextField nama;
    private javax.swing.JButton reset;
    private javax.swing.JButton simpan;
    private javax.swing.JTable tblmekanik;
    private javax.swing.JTextField tcari;
    // End of variables declaration//GEN-END:variables
}
