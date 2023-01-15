package uas.mvc.models;

import java.io.Serializable;
import java.time.LocalDateTime;
import javax.persistence.*;
import org.hibernate.annotations.CreationTimestamp;

/**
 *
 * @author agus
 */
@Entity
@Table(name = "angsuran")
public class Angsuran implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, unique = true)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "anggota_nik", nullable = false)
    private Anggota anggota;

    @ManyToOne
    @JoinColumn(name = "pinjaman_id", nullable = false)
    private Pinjaman pinjaman;

    @Column(name = "jumlah", nullable = false)
    private Long jumlah;

    @Column(name = "keterangan", nullable = false)
    private String keterangan;

    @CreationTimestamp()
    private LocalDateTime tanggal_transaksi;

    public Angsuran() {
    }

    public Angsuran(Integer id) {
        this.id = id;
    }

    public Angsuran(Integer id, Anggota anggota, Pinjaman pinjaman, Long jumlah, String keterangan, LocalDateTime tanggal_transaksi) {
        this.id = id;
        this.anggota = anggota;
        this.pinjaman = pinjaman;
        this.jumlah = jumlah;
        this.keterangan = keterangan;
        this.tanggal_transaksi = tanggal_transaksi;
    }

    public Integer getId() {
        return id;
    }

    public Anggota getAnggota() {
        return anggota;
    }

    public Angsuran setAnggota(Anggota anggota) {
        this.anggota = anggota;
        return this;
    }

    public Pinjaman getPinjaman() {
        return pinjaman;
    }

    public Angsuran setPinjaman(Pinjaman pinjaman) {
        this.pinjaman = pinjaman;
        return this;
    }

    public Long getJumlah() {
        return jumlah;
    }

    public Angsuran setJumlah(Long jumlah) {
        this.jumlah = jumlah;
        return this;
    }

    public String getKeterangan() {
        return keterangan;
    }

    public Angsuran setKeterangan(String keterangan) {
        this.keterangan = keterangan;
        return this;
    }

    public LocalDateTime getTanggalTransaksi() {
        return tanggal_transaksi;
    }

    public Angsuran setTanggal_transaksi(LocalDateTime tanggal_transaksi) {
        this.tanggal_transaksi = tanggal_transaksi;
        return this;
    }

}
