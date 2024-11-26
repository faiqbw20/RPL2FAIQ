-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Waktu pembuatan: 24 Nov 2024 pada 08.21
-- Versi server: 10.4.32-MariaDB
-- Versi PHP: 8.1.25

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `db_rpl2`
--

-- --------------------------------------------------------

--
-- Struktur dari tabel `transaksi_minuman`
--

CREATE TABLE `transaksi_minuman` (
  `id` int(11) NOT NULL,
  `nama_minuman` varchar(20) NOT NULL,
  `harga_jus` int(11) NOT NULL,
  `jmlh_beli` int(11) NOT NULL,
  `jmlh_harga` int(11) NOT NULL,
  `jmlh_bayar` int(11) NOT NULL,
  `jmlh_kembalian` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data untuk tabel `transaksi_minuman`
--

INSERT INTO `transaksi_minuman` (`id`, `nama_minuman`, `harga_jus`, `jmlh_beli`, `jmlh_harga`, `jmlh_bayar`, `jmlh_kembalian`) VALUES
(2, 'Jus Apel', 15000, 2, 30000, 50000, 20000);

--
-- Indexes for dumped tables
--

--
-- Indeks untuk tabel `transaksi_minuman`
--
ALTER TABLE `transaksi_minuman`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT untuk tabel yang dibuang
--

--
-- AUTO_INCREMENT untuk tabel `transaksi_minuman`
--
ALTER TABLE `transaksi_minuman`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
