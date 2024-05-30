-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Waktu pembuatan: 30 Bulan Mei 2024 pada 08.30
-- Versi server: 10.4.24-MariaDB
-- Versi PHP: 8.1.6

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `projek_akhir_pbo`
--

-- --------------------------------------------------------

--
-- Struktur dari tabel `jadwal`
--

CREATE TABLE `jadwal` (
  `id_jadwal` int(11) NOT NULL,
  `kodeJadwal` varchar(10) NOT NULL,
  `jamKeberangkatan` varchar(15) NOT NULL,
  `jamKedatangan` varchar(15) NOT NULL,
  `harga` varchar(20) NOT NULL,
  `kodePesawat` varchar(10) NOT NULL,
  `kodeKotaAwal` varchar(10) NOT NULL,
  `kodeKotaTujuan` varchar(10) NOT NULL,
  `kursiDiambil` int(11) DEFAULT 0,
  `kursiTersedia` int(11) DEFAULT 0,
  `statusKuota` varchar(10) GENERATED ALWAYS AS (case when `kursiDiambil` = `kursiTersedia` then 'penuh' else 'tersedia' end) STORED
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data untuk tabel `jadwal`
--

INSERT INTO `jadwal` (`id_jadwal`, `kodeJadwal`, `jamKeberangkatan`, `jamKedatangan`, `harga`, `kodePesawat`, `kodeKotaAwal`, `kodeKotaTujuan`, `kursiDiambil`, `kursiTersedia`) VALUES
(12, 'JD01', '10:00', '12:00', '1200000', 'PW01', 'KT01', 'KT03', 110, 100),
(13, 'JD02', '10:00', '12:00', '200000', 'PW03', 'KT01', 'KT03', 100, 100),
(14, 'JD03', '08:00', '10:00', '190822', 'PW01', 'KT01', 'KT03', 1, 900);

-- --------------------------------------------------------

--
-- Struktur dari tabel `kota`
--

CREATE TABLE `kota` (
  `id_kota` int(11) NOT NULL,
  `kodeKota` varchar(10) NOT NULL,
  `kota` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data untuk tabel `kota`
--

INSERT INTO `kota` (`id_kota`, `kodeKota`, `kota`) VALUES
(1, 'KT01', 'Jogja'),
(2, 'KT02', 'Semarang'),
(3, 'KT03', 'Jakarta');

-- --------------------------------------------------------

--
-- Struktur dari tabel `pemesanan`
--

CREATE TABLE `pemesanan` (
  `id_pesan` int(11) NOT NULL,
  `nik` varchar(25) NOT NULL,
  `nama` varchar(25) NOT NULL,
  `noHp` varchar(20) NOT NULL,
  `kota_awal` int(11) NOT NULL,
  `kota_tujuan` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Struktur dari tabel `pesawat`
--

CREATE TABLE `pesawat` (
  `id_pesawat` int(11) NOT NULL,
  `kodePesawat` varchar(10) NOT NULL,
  `pesawat` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data untuk tabel `pesawat`
--

INSERT INTO `pesawat` (`id_pesawat`, `kodePesawat`, `pesawat`) VALUES
(1, 'PW01', 'Garuda Indonesia'),
(2, 'PW02', 'Terbang jaya'),
(6, 'PW03', 'Batik');

-- --------------------------------------------------------

--
-- Struktur dari tabel `users`
--

CREATE TABLE `users` (
  `id_user` int(11) NOT NULL,
  `nama` varchar(50) NOT NULL,
  `email` varchar(50) NOT NULL,
  `username` varchar(50) NOT NULL,
  `password` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data untuk tabel `users`
--

INSERT INTO `users` (`id_user`, `nama`, `email`, `username`, `password`) VALUES
(1, 'test', 'test@gmail.com', '123', '123'),
(2, 'wijdan', 'wijdan@gmail.com', '321', '321'),
(4, 'kuro', 'kuro', '1234', '1234'),
(5, 'shiro', 'shirio@gmail.com', '12345', '12345'),
(12, '123', '123', '098', '098'),
(13, 'Akbar', '1', 'arif1', '123'),
(18, 'a', 'a', 'rolly', '123'),
(19, 'Ageng', 'ageng@gmail.com', 'ageng', '123');

--
-- Indexes for dumped tables
--

--
-- Indeks untuk tabel `jadwal`
--
ALTER TABLE `jadwal`
  ADD PRIMARY KEY (`id_jadwal`),
  ADD UNIQUE KEY `kodeJadwal` (`kodeJadwal`),
  ADD KEY `pesawatJadwal` (`kodePesawat`),
  ADD KEY `kotaAwalJadwal` (`kodeKotaAwal`),
  ADD KEY `kotaTujuanJadwal` (`kodeKotaTujuan`);

--
-- Indeks untuk tabel `kota`
--
ALTER TABLE `kota`
  ADD PRIMARY KEY (`id_kota`),
  ADD UNIQUE KEY `kodeKota` (`kodeKota`);

--
-- Indeks untuk tabel `pemesanan`
--
ALTER TABLE `pemesanan`
  ADD PRIMARY KEY (`id_pesan`),
  ADD KEY `kota_awal_pesan` (`kota_awal`),
  ADD KEY `kota_tujuan_pesan` (`kota_tujuan`);

--
-- Indeks untuk tabel `pesawat`
--
ALTER TABLE `pesawat`
  ADD PRIMARY KEY (`id_pesawat`),
  ADD UNIQUE KEY `kodePesawat` (`kodePesawat`);

--
-- Indeks untuk tabel `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`id_user`),
  ADD UNIQUE KEY `username` (`username`);

--
-- AUTO_INCREMENT untuk tabel yang dibuang
--

--
-- AUTO_INCREMENT untuk tabel `jadwal`
--
ALTER TABLE `jadwal`
  MODIFY `id_jadwal` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=15;

--
-- AUTO_INCREMENT untuk tabel `kota`
--
ALTER TABLE `kota`
  MODIFY `id_kota` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;

--
-- AUTO_INCREMENT untuk tabel `pemesanan`
--
ALTER TABLE `pemesanan`
  MODIFY `id_pesan` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT untuk tabel `pesawat`
--
ALTER TABLE `pesawat`
  MODIFY `id_pesawat` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT untuk tabel `users`
--
ALTER TABLE `users`
  MODIFY `id_user` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=20;

--
-- Ketidakleluasaan untuk tabel pelimpahan (Dumped Tables)
--

--
-- Ketidakleluasaan untuk tabel `jadwal`
--
ALTER TABLE `jadwal`
  ADD CONSTRAINT `kotaAwalJadwal` FOREIGN KEY (`kodeKotaAwal`) REFERENCES `kota` (`kodeKota`),
  ADD CONSTRAINT `kotaTujuanJadwal` FOREIGN KEY (`kodeKotaTujuan`) REFERENCES `kota` (`kodeKota`),
  ADD CONSTRAINT `pesawatJadwal` FOREIGN KEY (`kodePesawat`) REFERENCES `pesawat` (`kodePesawat`);

--
-- Ketidakleluasaan untuk tabel `pemesanan`
--
ALTER TABLE `pemesanan`
  ADD CONSTRAINT `kota_awal_pesan` FOREIGN KEY (`kota_awal`) REFERENCES `kota` (`id_kota`),
  ADD CONSTRAINT `kota_tujuan_pesan` FOREIGN KEY (`kota_tujuan`) REFERENCES `kota` (`id_kota`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
