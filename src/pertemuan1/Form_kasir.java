/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pertemuan1;
 
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.table.DefaultTableModel; // Untuk DefaultTableModel
import java.sql.Connection; // Untuk Connection
import java.sql.PreparedStatement; // Untuk PreparedStatement
import java.sql.ResultSet; // Untuk ResultSet
import java.sql.SQLException; // Untuk SQLException
import javax.swing.JOptionPane; // Untuk JOptionPane
import java.sql.DriverManager; // Untuk DriverManager

import dao.transaksiDAO;
import model.Transaksi;

public class Form_kasir extends javax.swing.JFrame {

    private Connection connection;
    
    public Form_kasir() {
        initComponents();
        connectToDatabase();
        
    tampilkanDataKeTabel(); // Panggil metode untuk menampilkan data di tabel
    }
    // Metode untuk mendapatkan ID yang dipilih dari tabel
private int getSelectedIdFromTable() {
    int selectedRow = tb_kolom.getSelectedRow(); // jTable1 adalah nama variabel tabel Anda

    if (selectedRow == -1) {
        JOptionPane.showMessageDialog(this, "Pilih data di tabel terlebih dahulu!", "Error", JOptionPane.ERROR_MESSAGE);
        return -1;
    }

    // Ambil nilai dari kolom pertama
    Object value = tb_kolom.getValueAt(selectedRow, 0);
    
    // Periksa apakah nilai dapat dikonversi menjadi integer
    if (value != null && value instanceof Number) {
        int selectedId = ((Number) value).intValue();
        System.out.println("ID yang dipilih: " + selectedId);  // Log ID untuk debugging
        return selectedId;
    } else {
        JOptionPane.showMessageDialog(this, "ID tidak valid!", "Error", JOptionPane.ERROR_MESSAGE);
        return -1;
    }
}
     // Method untuk koneksi ke database
    private void connectToDatabase() {
        try {
        String url = "jdbc:mysql://localhost:3306/db_rpl2"; // Ganti dengan nama database Anda
        String user = "root"; // Ganti dengan username database Anda
        String password = ""; // Ganti dengan password database Anda
            // Inisialisasi koneksi
            connection = DriverManager.getConnection(url, user, password);
            System.out.println("Koneksi ke database berhasil!");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Koneksi ke database gagal: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }

    }
  
    
    // Jangan lupa untuk menutup koneksi saat aplikasi ditutup
    protected void finalize() throws Throwable {
        if (connection != null && !connection.isClosed()) {
            connection.close();
        }
        super.finalize();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jRadioButton1 = new javax.swing.JRadioButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        nama_barang = new javax.swing.JComboBox<>();
        harga_satuan = new javax.swing.JTextField();
        jumlah_beli = new javax.swing.JTextField();
        jumlah_harga = new javax.swing.JTextField();
        jumlah_bayar = new javax.swing.JTextField();
        jumlah_kembalian = new javax.swing.JTextField();
        batal = new javax.swing.JButton();
        keluar = new javax.swing.JButton();
        hitung_jumlah_barang = new javax.swing.JButton();
        bayar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tb_kolom = new javax.swing.JTable();
        Simpan = new javax.swing.JButton();
        edit = new javax.swing.JButton();
        delete = new javax.swing.JButton();
        set = new javax.swing.JButton();

        jRadioButton1.setText("jRadioButton1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("APLIKASI KASIR RUMAH JUS");

        jLabel2.setText("NAMA MINUMAN");

        jLabel3.setText("HARGA JUS");

        jLabel4.setText("JUMLAH BELI");

        jLabel5.setText("JUMLAH HARGA");

        jLabel6.setText("JUMLAH BAYAR");

        jLabel7.setText("JUMLAH KEMBALIAN");

        nama_barang.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Pilih Jus", "Jus Alpukat", "Jus Mangga", "Jus Sirsak", "Jus Jeruk", "Jus Apel", "Jus Melon" }));
        nama_barang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nama_barangActionPerformed(evt);
            }
        });

        harga_satuan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                harga_satuanActionPerformed(evt);
            }
        });

        batal.setText("CLEAR");
        batal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                batalActionPerformed(evt);
            }
        });

        keluar.setText("KELUAR");
        keluar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                keluarActionPerformed(evt);
            }
        });

        hitung_jumlah_barang.setText("HITUNG JUMLAH JUS");
        hitung_jumlah_barang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                hitung_jumlah_barangActionPerformed(evt);
            }
        });

        bayar.setText("BAYAR");
        bayar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bayarActionPerformed(evt);
            }
        });

        tb_kolom.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "ID", "Nama Jus", "Harga Satuan", "Jumlah Beli", "Total Harga", "Jumlah Bayar", "Jumlah Kembalian"
            }
        ));
        jScrollPane1.setViewportView(tb_kolom);

        Simpan.setText("SIMPAN");
        Simpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SimpanActionPerformed(evt);
            }
        });

        edit.setText("EDIT");
        edit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editActionPerformed(evt);
            }
        });

        delete.setText("DELETE");
        delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteActionPerformed(evt);
            }
        });

        set.setText("SET");
        set.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                setActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel2)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6)
                            .addComponent(jLabel7))
                        .addGap(36, 36, 36)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jumlah_bayar, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 137, Short.MAX_VALUE)
                            .addComponent(jumlah_harga, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jumlah_beli, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(nama_barang, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(harga_satuan, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jumlah_kembalian))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(hitung_jumlah_barang)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(bayar)
                                .addGap(35, 35, 35))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(390, 390, 390)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(109, 109, 109)
                        .addComponent(keluar)
                        .addGap(18, 18, 18)
                        .addComponent(batal)
                        .addGap(18, 18, 18)
                        .addComponent(Simpan))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(140, 140, 140)
                        .addComponent(edit, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(delete)
                        .addGap(18, 18, 18)
                        .addComponent(set)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 811, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel1)
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(nama_barang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(harga_satuan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(jumlah_beli, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(hitung_jumlah_barang))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(jumlah_harga, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(jumlah_bayar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(bayar))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(jumlah_kembalian, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(keluar)
                            .addComponent(Simpan)
                            .addComponent(batal))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(edit)
                            .addComponent(delete)
                            .addComponent(set))
                        .addGap(0, 53, Short.MAX_VALUE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void nama_barangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nama_barangActionPerformed
        String NamaBarang=(String)nama_barang.getSelectedItem();
        switch (NamaBarang){
        case "Jus Alpukat":
        harga_satuan.setText("15000");
        break;
        case "Jus Mangga":
        harga_satuan.setText("15000");
        break;
        case "Jus Sirsak":
        harga_satuan.setText("15000");
        break;
        case "Jus Jeruk":
        harga_satuan.setText("15000");
        break;
        case "Jus Apel":
        harga_satuan.setText("15000");
        break;
        case "Jus Melon":
        harga_satuan.setText("15000");
        break;
        // TODO add your handling code here:
    }//GEN-LAST:event_nama_barangActionPerformed

    private void harga_satuanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_harga_satuanActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_harga_satuanActionPerformed

    private void hitung_jumlah_barangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hitung_jumlah_barangActionPerformed
        int JumlahBarang=Integer.parseInt(jumlah_beli.getText());
        int HargaBarang=Integer.parseInt(harga_satuan.getText());
        jumlah_harga.setText(Integer.toString(HargaBarang*JumlahBarang));
// TODO add your handling code here:
    }//GEN-LAST:event_hitung_jumlah_barangActionPerformed

    private void bayarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bayarActionPerformed
        int JumlahBayar=Integer.parseInt(jumlah_bayar.getText());
        int JumlahHarga=Integer.parseInt(jumlah_harga.getText());
        if (JumlahBayar>=JumlahHarga){
        jumlah_kembalian.setText(Integer.toString(JumlahBayar-JumlahHarga));
        }
        else {
        jumlah_kembalian.setText("Uang Anda Kurang");
        }

// TODO add your handling code here:
    }//GEN-LAST:event_bayarActionPerformed

    private void batalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_batalActionPerformed
            harga_satuan.setText("");
            jumlah_beli.setText("");
            jumlah_harga.setText("");
            jumlah_bayar.setText("");
            jumlah_kembalian.setText("");
            nama_barang.setSelectedIndex(0);

        // TODO add your handling code here:
    }//GEN-LAST:event_batalActionPerformed

    private void keluarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_keluarActionPerformed
           System.exit(0);
        // TODO add your handling code here:
    }//GEN-LAST:event_keluarActionPerformed

    private void SimpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SimpanActionPerformed
         // Pastikan field input tidak kosong
    if (nama_barang.getSelectedItem() == null || harga_satuan.getText().isEmpty() ||
        jumlah_beli.getText().isEmpty() || jumlah_harga.getText().isEmpty() ||
        jumlah_bayar.getText().isEmpty() || jumlah_kembalian.getText().isEmpty()) {
        
        JOptionPane.showMessageDialog(null, "Harap isi semua field!", "Error", JOptionPane.ERROR_MESSAGE);
        return;
    }

    // Ambil data dari form
    String namaMakanan = nama_barang.getSelectedItem().toString();
    int hargaSatuan = Integer.parseInt(harga_satuan.getText());
    int jumlahBeli = Integer.parseInt(jumlah_beli.getText());
    int totalHarga = Integer.parseInt(jumlah_harga.getText());
    int jumlahBayar = Integer.parseInt(jumlah_bayar.getText());
    int kembalian = Integer.parseInt(jumlah_kembalian.getText());

    Transaksi transaksi = new Transaksi();
    transaksi.setNama_barang(namaMakanan);
    transaksi.setHarga_satuan(hargaSatuan);
    transaksi.setJumlah_beli(jumlahBeli);
    transaksi.setJumlah_harga(totalHarga);
    transaksi.setJumlah_bayar(jumlahBayar);
    transaksi.setJumlah_kembalian(kembalian);


    transaksiDAO transaksiDAO = new transaksiDAO();
    transaksiDAO.saveTransaksi(transaksi);

    JOptionPane.showMessageDialog(null, "Data transaksi berhasil disimpan!", "Sukses", JOptionPane.INFORMATION_MESSAGE);
    tampilkanDataKeTabel();
    }//GEN-LAST:event_SimpanActionPerformed

    private void editActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editActionPerformed
       int selectedRow = tb_kolom.getSelectedRow();
    if (selectedRow == -1) {
        JOptionPane.showMessageDialog(null, "Pilih baris yang valid untuk diedit", "Peringatan", JOptionPane.WARNING_MESSAGE);
        return;
    }

    int selectedId = Integer.parseInt(tb_kolom.getValueAt(selectedRow, 0).toString());
    String namaMakanan = nama_barang.getSelectedItem().toString();
    int hargaSatuan = Integer.parseInt(harga_satuan.getText());
    int jumlahBeli = Integer.parseInt(jumlah_beli.getText());
    int totalHarga = Integer.parseInt(jumlah_harga.getText());
    int jumlahBayar = Integer.parseInt(jumlah_bayar.getText());
    int kembalian = Integer.parseInt(jumlah_kembalian.getText());

    transaksiDAO transaksiDAO = new transaksiDAO();
    transaksiDAO.updateTransaksi(selectedId, namaMakanan, hargaSatuan, jumlahBeli, totalHarga, jumlahBayar, kembalian);

    JOptionPane.showMessageDialog(null, "Data transaksi berhasil diperbarui!", "Sukses", JOptionPane.INFORMATION_MESSAGE);
    tampilkanDataKeTabel();
    }//GEN-LAST:event_editActionPerformed

    private void deleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteActionPerformed
       int selectedRow = tb_kolom.getSelectedRow();
    if (selectedRow == -1) {
        JOptionPane.showMessageDialog(null, "Pilih baris yang valid untuk dihapus", "Peringatan", JOptionPane.WARNING_MESSAGE);
        return;
    }

    int selectedId = Integer.parseInt(tb_kolom.getValueAt(selectedRow, 0).toString());

    transaksiDAO transaksiDAO = new transaksiDAO();
    transaksiDAO.deleteTransaksi(selectedId);

    JOptionPane.showMessageDialog(null, "Data transaksi berhasil dihapus!", "Sukses", JOptionPane.INFORMATION_MESSAGE);
    tampilkanDataKeTabel();
    }//GEN-LAST:event_deleteActionPerformed
    
    private void setActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_setActionPerformed
            // Ambil data dari baris yang dipilih di tabel
    int selectedRow = tb_kolom.getSelectedRow(); // Ambil baris yang dipilih
    if (selectedRow != -1) { // Pastikan ada baris yang dipilih
        try {
            // Ambil data dari kolom yang sesuai dan set ke komponen yang sesuai
            nama_barang.setSelectedItem(tb_kolom.getValueAt(selectedRow, 1).toString().trim()); // Kolom 1 untuk nama_barang
            harga_satuan.setText(tb_kolom.getValueAt(selectedRow, 2).toString());   // Kolom 2 untuk harga_satuan
            jumlah_beli.setText(tb_kolom.getValueAt(selectedRow, 3).toString());    // Kolom 3 untuk jumlah_beli
            jumlah_harga.setText(tb_kolom.getValueAt(selectedRow, 4).toString());   // Kolom 4 untuk jumlah_harga
            jumlah_bayar.setText(tb_kolom.getValueAt(selectedRow, 5).toString());   // Kolom 5 untuk jumlah_bayar
            jumlah_kembalian.setText(tb_kolom.getValueAt(selectedRow, 6).toString()); // Kolom 6 untuk jumlah_kembalian

            // Menangani ComboBox berdasarkan pilihan sebelumnya di tabel
            String namaMakanan = tb_kolom.getValueAt(selectedRow, 1).toString().trim(); // Kolom 1 untuk nama_makanan
            switch (namaMakanan) {
                case "Pilih Jus":
                    nama_barang.setSelectedIndex(0);
                    break;
                case "Jus Alpukat":
                    nama_barang.setSelectedIndex(1);
                    break;
                case "Jus Mangga":
                    nama_barang.setSelectedIndex(2);
                    break;
                case "Jus Sirsak":
                    nama_barang.setSelectedIndex(3);
                    break;
                case "Jus Jeruk":
                    nama_barang.setSelectedIndex(4);
                    break;
                case "Jus Apel":
                    nama_barang.setSelectedIndex(5);
                    break;
                case "Jus Melon":
                    nama_barang.setSelectedIndex(6);
                    break;
                default:
                    nama_barang.setSelectedIndex(-1); // Jika tidak ditemukan, set ke index -1
            }
        } catch (NumberFormatException e) {
            // Tangani error jika data yang diambil tidak bisa diubah ke tipe data yang sesuai
            JOptionPane.showMessageDialog(this, "Data yang diambil tidak valid. Pastikan data dalam format yang benar.");
        }
    } else {
        // Tampilkan pesan jika tidak ada baris yang dipilih
        JOptionPane.showMessageDialog(this, "Silakan pilih data dari tabel.");
    }
    }                                           

    private void btn_hapusActionPerformed(java.awt.event.ActionEvent evt) {                                          
        // Ambil ID dari data yang dipilih di tabel
    int selectedRow = tb_kolom.getSelectedRow(); // Ambil baris yang dipilih
    
    if (selectedRow == -1) {
        // Menampilkan pesan jika ID tidak valid
        JOptionPane.showMessageDialog(null, "Pilih baris yang valid untuk dihapus", "Peringatan", JOptionPane.WARNING_MESSAGE);
        return;
    }
    
    // Ambil ID transaksi dari kolom pertama di baris yang dipilih
    int selectedId = Integer.parseInt(tb_kolom.getValueAt(selectedRow, 0).toString());

    // Instance TransaksiDAO
    transaksiDAO transaksiDAO = new transaksiDAO();
    
    // Hapus data dari database menggunakan TransaksiDAO
    transaksiDAO.deleteTransaksi(selectedId);

    // Tampilkan pesan sukses
    JOptionPane.showMessageDialog(null, "Data transaksi berhasil dihapus!", "Sukses", JOptionPane.INFORMATION_MESSAGE);

    // Panggil metode untuk menampilkan data setelah berhasil dihapus
    tampilkanDataKeTabel(); 
    }                                         

    
    private void tampilkanDataKeTabel() {
    DefaultTableModel model = (DefaultTableModel) tb_kolom.getModel();
    model.setRowCount(0); // Hapus semua data di tabel terlebih dahulu

    String sql = "SELECT * FROM transaksi_minuman";

    try {
        PreparedStatement pstmt = connection.prepareStatement(sql);
        ResultSet rs = pstmt.executeQuery();

        while (rs.next()) {
            Object[] row = {
                //ambil data dari field tabel di db
                rs.getString("id"),
                rs.getString("nama_minuman"),
                rs.getInt("harga_jus"),
                rs.getInt("jmlh_beli"),
                rs.getInt("jmlh_harga"),
                rs.getInt("jmlh_bayar"),
                rs.getInt("jmlh_kembalian"),
            };
            model.addRow(row);
        }

    } catch (SQLException e) {
        JOptionPane.showMessageDialog(this, "Gagal menampilkan data: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
    }
        // TODO add your handling code here:
    }//GEN-LAST:event_setActionPerformed
        
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
            java.util.logging.Logger.getLogger(Form_kasir.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Form_kasir.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Form_kasir.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Form_kasir.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Form_kasir().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Simpan;
    private javax.swing.JButton batal;
    private javax.swing.JButton bayar;
    private javax.swing.JButton delete;
    private javax.swing.JButton edit;
    private javax.swing.JTextField harga_satuan;
    private javax.swing.JButton hitung_jumlah_barang;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jumlah_bayar;
    private javax.swing.JTextField jumlah_beli;
    private javax.swing.JTextField jumlah_harga;
    private javax.swing.JTextField jumlah_kembalian;
    private javax.swing.JButton keluar;
    private javax.swing.JComboBox<String> nama_barang;
    private javax.swing.JButton set;
    private javax.swing.JTable tb_kolom;
    // End of variables declaration//GEN-END:variables
}