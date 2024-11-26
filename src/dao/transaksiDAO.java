package dao;

import model.Transaksi;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class transaksiDAO {

    private static SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();

    // Create (Save new Transaksi to database)
    public void saveTransaksi(Transaksi transaksi) {
        Session session = factory.openSession();
        Transaction tx = session.beginTransaction();
        session.save(transaksi);
        tx.commit();
        session.close();
    }

    // Read (Retrieve Transaksi by ID)
    public Transaksi getTransaksi(int id) {
        Session session = factory.openSession();
        Transaksi transaksi = (Transaksi) session.get(Transaksi.class, id);
        session.close();
        return transaksi;
    }

   // Update (Update Transaksi by ID)
public void updateTransaksi(int id, String nama_barang, int harga_satuan, int jumlah_beli, int total_harga, int jumlah_bayar, int jumlah_kembalian) {
    Session session = factory.openSession();
    Transaction tx = session.beginTransaction();

    Transaksi transaksi = (Transaksi) session.get(Transaksi.class, id);
    if (transaksi != null) {
        transaksi.setNama_barang(nama_barang);
        transaksi.setHarga_satuan(harga_satuan);
        transaksi.setJumlah_beli(jumlah_beli);
        transaksi.setJumlah_harga(total_harga);
        transaksi.setJumlah_bayar(jumlah_bayar);
        transaksi.setJumlah_kembalian(jumlah_kembalian);

        session.update(transaksi);
        tx.commit();
    } else {
        System.out.println("Transaksi dengan ID " + id + " tidak ditemukan.");
    }
    session.close();
}

    // Delete (Delete Transaksi by ID)
    public void deleteTransaksi(int id) {
        Session session = factory.openSession();
        Transaction tx = session.beginTransaction();

        Transaksi transaksi = (Transaksi) session.get(Transaksi.class, id);
        if (transaksi != null) {
            session.delete(transaksi);
            tx.commit();
        } else {
            System.out.println("Transaksi dengan ID " + id + " tidak ditemukan.");
        }
        session.close();
    }
}
