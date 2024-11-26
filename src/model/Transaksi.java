package model;

import javax.persistence.*;

@Entity
@Table(name = "transaksi_minuman")
public class Transaksi {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

        @Column(name = "nama_minuman")
    private String nama_barang;

    @Column(name = "harga_jus")
    private int harga_satuan;

    @Column(name = "jmlh_beli")
    private int jumlah_beli;

    @Column(name = "jmlh_harga")
    private int jumlah_harga;

    @Column(name = "jmlh_bayar")
    private int jumlah_bayar;

    @Column(name = "jmlh_kembalian")
    private int jumlah_kembalian;


    // Getters and Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getNama_barang() { return nama_barang; }
    public void setNama_barang(String nama_barang) { this.nama_barang = nama_barang; }

    // Transaksi.java (pastikan getter dan setter sesuai field)
    public int getHarga_satuan() { return harga_satuan; }
    public void setHarga_satuan(int harga_satuan) { this.harga_satuan = harga_satuan; }

    public int getJumlah_beli() { return jumlah_beli; }
    public void setJumlah_beli(int jumlah_beli) { this.jumlah_beli = jumlah_beli; }

    public int getJumlah_harga() { return jumlah_harga; }
    public void setJumlah_harga(int jumlah_harga) { this.jumlah_harga = jumlah_harga; }

    public int getJumlah_bayar() { return jumlah_bayar; }
    public void setJumlah_bayar(int jumlah_bayar) { this.jumlah_bayar = jumlah_bayar; }

    public int getJumlah_kembalian() { return jumlah_kembalian; }
    public void setJumlah_kembalian(int jumlah_kembalian) { this.jumlah_kembalian = jumlah_kembalian; }

}