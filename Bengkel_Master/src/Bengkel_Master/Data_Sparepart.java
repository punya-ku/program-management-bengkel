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
public class Data_Sparepart extends javax.swing.JFrame {
    private Connection conn = new Koneksi().connect();
    private DefaultTableModel tabmodel;
    String sql,kode,nama,stok,harga,ongkos;
    Statement st;
    PreparedStatement ps;
    ResultSet rs;
    /**
     * Creates new form Data_Sparepart
     */
    public Data_Sparepart() {
        initComponents();
        autoNumber();
        off();
        datatable();
        this.setLocationRelativeTo(null);
    }

    public void autoNumber(){
        try {
            sql = "SELECT * FROM sparepart ORDER BY kd_sparepart DESC";
            ps = conn.prepareCall(sql);
            rs = ps.executeQuery(sql);
            if (rs.next()) {
                String kd = rs.getString("kd_sparepart").substring(2);
                String AN =  "" + (Integer.parseInt(kd) + 1);
                String Nol = "";

                if (AN.length()==1) {
                    Nol = "000";
                } else if (AN.length()==2) {
                    Nol = "00";
                } else if (AN.length()==3) {
                    Nol = "0";
                } else if (AN.length()==4) {
                    Nol = "";
                }
                tkode.setText("SP" + Nol + AN);
            } else {
                tkode.setText("SP0001");
            }
            rs.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
   
    public void off(){
        tkode.setEnabled(false);
        tnama.setEnabled(false);
        tstok.setEnabled(false);
        tharga.setEnabled(false);
        tongkos.setEnabled(false);
    }
    
    public void on(){
        tstok.setEnabled(true);
        tnama.setEnabled(true);
        tharga.setEnabled(true);
        tongkos.setEnabled(true);
        tkode.requestFocus();
    }
    
    public void reset(){
        tstok.setText("");
        tnama.setText("");
        tharga.setText("");
        tongkos.setText("");
        btambah.setEnabled(true);      
        bedit.setEnabled(false);
        bhapus.setEnabled(false);
    }
    
    public void datatable(){
        Object[] Baris = {"Kode Sparepart", "Nama Sparepart", "Harga", "Stok", "ongkos"};
        tabmodel = new DefaultTableModel(null, Baris);
        tblsuku.setModel(tabmodel);
        sql = "select * from sparepart";
        try {
            st = conn.createStatement();
            rs = st.executeQuery(sql);
            while (rs.next()) {
                kode = rs.getString("kd_sparepart");
                nama = rs.getString("nama_sparepart");
                stok = rs.getString("stok");
                harga = rs.getString("harga");
                ongkos = rs.getString("ongkos");
                String[] data = {kode,nama,harga,stok,ongkos};
                tabmodel.addRow(data);
            }
        } catch (Exception e) {
            
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
        jLabel5 = new javax.swing.JLabel();
        tkode = new javax.swing.JTextField();
        tnama = new javax.swing.JTextField();
        tharga = new javax.swing.JTextField();
        tstok = new javax.swing.JTextField();
        tongkos = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblsuku = new javax.swing.JTable();
        breset = new javax.swing.JButton();
        btambah = new javax.swing.JButton();
        bedit = new javax.swing.JButton();
        bhapus = new javax.swing.JButton();
        tcari = new javax.swing.JTextField();
        bcari = new javax.swing.JButton();
        bkeluar = new javax.swing.JButton();
        bbatal = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Kode");

        jLabel2.setText("Nama Sparepart");

        jLabel3.setText("Harga");

        jLabel4.setText("Stok");

        jLabel5.setText("Ongkos");

        tkode.setText("jTextField1");
        tkode.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tkodeActionPerformed(evt);
            }
        });

        tnama.setText("jTextField2");

        tharga.setText("jTextField3");

        tstok.setText("jTextField4");

        tongkos.setText("jTextField5");

        tblsuku.setModel(new javax.swing.table.DefaultTableModel(
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
        tblsuku.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblsukuMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblsuku);

        breset.setText("Reset");
        breset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bresetActionPerformed(evt);
            }
        });

        btambah.setText("Tambah");
        btambah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btambahActionPerformed(evt);
            }
        });

        bedit.setText("Edit");
        bedit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                beditActionPerformed(evt);
            }
        });

        bhapus.setText("Hapus");
        bhapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bhapusActionPerformed(evt);
            }
        });

        tcari.setText("jTextField6");
        tcari.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tcariActionPerformed(evt);
            }
        });

        bcari.setText("Cari");
        bcari.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bcariActionPerformed(evt);
            }
        });

        bkeluar.setText("Keluar");

        bbatal.setText("Batal");
        bbatal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bbatalActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(bkeluar)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(24, 24, 24)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel2)
                                .addComponent(jLabel1)
                                .addComponent(jLabel3)
                                .addComponent(jLabel4)
                                .addComponent(jLabel5))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(tkode, javax.swing.GroupLayout.DEFAULT_SIZE, 161, Short.MAX_VALUE)
                                .addComponent(tnama)
                                .addComponent(tharga)
                                .addComponent(tstok)
                                .addComponent(tongkos))
                            .addGap(18, 18, 18)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 452, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(157, 157, 157)
                            .addComponent(breset)
                            .addGap(18, 18, 18)
                            .addComponent(btambah)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(bedit)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(bbatal)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(bhapus)
                                    .addGap(64, 64, 64)
                                    .addComponent(tcari)
                                    .addGap(18, 18, 18)
                                    .addComponent(bcari))))))
                .addContainerGap(28, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(83, 83, 83)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(tkode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(tnama, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(tharga, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(tstok, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(tongkos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(breset)
                    .addComponent(btambah)
                    .addComponent(bedit)
                    .addComponent(bhapus)
                    .addComponent(tcari, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bcari))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bbatal)
                .addGap(21, 21, 21)
                .addComponent(bkeluar)
                .addContainerGap(179, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tkodeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tkodeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tkodeActionPerformed

    private void tcariActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tcariActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tcariActionPerformed

    private void beditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_beditActionPerformed
        // TODO add your handling code here:
        if (bedit.getText()=="Edit") {
            on();
            bedit.setText("UPDATE");
            bhapus.setEnabled(false);
            btambah.setEnabled(false);
        } else {
            sql = "update sparepart set nm_sparepart=?, harga=?, stok=?, ongkos=? where kd_sparepart='"+tkode.getText()+"'";
            try {
                ps = conn.prepareStatement(sql);

                ps.setString(1, tnama.getText());
                ps.setString(2, tharga.getText());
                ps.setString(3, tstok.getText());
                ps.setString(4, tongkos.getText());
                ps.executeUpdate();
                JOptionPane.showMessageDialog(null, "Data Sparepart berhasil Di Update");
                bedit.setText("Edit");
                datatable();
                reset();
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Data Sparepart Gagal Di Update" + e);
            }
        }
    }//GEN-LAST:event_beditActionPerformed

    private void bhapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bhapusActionPerformed
        // TODO add your handling code here:
        int ok = JOptionPane.showConfirmDialog(null, "Apakah Anda Yakin ingin Menghapus Data Ini?", "Konfirmasi Dialog", JOptionPane.YES_NO_OPTION);
        if (ok == 0) {
            sql = "delete from sparepart where kd_sparepart='"+tkode.getText() + "'";
            try {
                ps = conn.prepareStatement(sql);
                ps.executeUpdate();
                JOptionPane.showMessageDialog(null, "Data Sparepart Berhasil Dihapus");
                reset();
                tkode.requestFocus();
                datatable();
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Data Sparepart Gagal Di Hapus" + e);
            }
        }
    }//GEN-LAST:event_bhapusActionPerformed

    private void bbatalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bbatalActionPerformed
        // TODO add your handling code here:
        reset();
        btambah.setText("Tambah");
        off();
    }//GEN-LAST:event_bbatalActionPerformed

    private void tblsukuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblsukuMouseClicked
        // TODO add your handling code here:
        String a,b,c,d,e;
        bedit.setEnabled(true);
        bedit.setText("Edit");
        bhapus.setEnabled(true);
        int bar = tblsuku.getSelectedRow();
        a = tabmodel.getValueAt(bar, 0).toString();
        b = tabmodel.getValueAt(bar, 1).toString();
        c = tabmodel.getValueAt(bar, 2).toString();
        d = tabmodel.getValueAt(bar, 3).toString();
        e = tabmodel.getValueAt(bar, 4).toString();
        tkode.setText(a);
        tnama.setText(b);
        tharga.setText(c);
        tstok.setText(d);
        tongkos.setText(e);
    }//GEN-LAST:event_tblsukuMouseClicked

    private void btambahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btambahActionPerformed
        // TODO add your handling code here:
        String tombol = btambah.getText();
        if (tombol.equals("Tambah")){
            on();
            reset();
            btambah.setText("SIMPAN");
            bedit.setEnabled(false);
            bhapus.setEnabled(false);
        }else{
            sql = "insert into sparepart values(?,?,?,?,?)";
            try{
                ps = conn.prepareStatement(sql);
                ps.setString(1, tkode.getText());
                ps.setString(2, tnama.getText());
                ps.setString(3, tharga.getText());
                ps.setString(4, tstok.getText());
                ps.setString(5, tongkos.getText());
                ps.executeUpdate();
                JOptionPane.showMessageDialog(null, "Data sparepart Berhasil Disimpan");
                reset();
                autoNumber();
                tkode.requestFocus();
                datatable();
            }catch(SQLException e){
                JOptionPane.showConfirmDialog(null, "Data sparepart gagal disimpan" + e);
            }
            btambah.setText("Tambah");
            off();
        }
    }//GEN-LAST:event_btambahActionPerformed

    private void bcariActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bcariActionPerformed
        // TODO add your handling code here:
        String tombol = bcari.getText();
        if (tombol.equals("Cari")){
         Object[] Baris = {"Kode_Sparepart", "Nama_Sparepart", "Harga", "Stok", "Ongkos"};
        tabmodel = new DefaultTableModel(null, Baris);
        tblsuku.setModel(tabmodel);
        sql = "Select * from sparepart where kd_sparepart like '%" + tcari.getText() + "%'" +
            "or nm_sparepart like '%" + tcari.getText() + "%'";
        try {
            st = conn.createStatement();
            rs = st.executeQuery(sql);
            while (rs.next()) {
                kode = rs.getString("kd_sparepart");
                nama = rs.getString("nm_sparepart");
                stok = rs.getString("stok");
                harga = rs.getString("harga");
                ongkos = rs.getString("ongkos");
                String[] data = {kode,nama,harga,stok, ongkos};
                tabmodel.addRow(data);
            }
        } catch (Exception e) {
        }
        bcari.setText("Batal");
    }else{
            datatable();
            bcari.setText("Cari");
            tcari.setText("");
            btambah.setEnabled(true);
        }
    }//GEN-LAST:event_bcariActionPerformed

    private void bresetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bresetActionPerformed
        // TODO add your handling code here:
        reset();
    }//GEN-LAST:event_bresetActionPerformed

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
            java.util.logging.Logger.getLogger(Data_Sparepart.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Data_Sparepart.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Data_Sparepart.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Data_Sparepart.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Data_Sparepart().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bbatal;
    private javax.swing.JButton bcari;
    private javax.swing.JButton bedit;
    private javax.swing.JButton bhapus;
    private javax.swing.JButton bkeluar;
    private javax.swing.JButton breset;
    private javax.swing.JButton btambah;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblsuku;
    private javax.swing.JTextField tcari;
    private javax.swing.JTextField tharga;
    private javax.swing.JTextField tkode;
    private javax.swing.JTextField tnama;
    private javax.swing.JTextField tongkos;
    private javax.swing.JTextField tstok;
    // End of variables declaration//GEN-END:variables
}
