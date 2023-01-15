package uas.mvc.models;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Set;
import javax.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import uas.mvc.utils.Helpers;

/**
 *
 * @author agus
 */
@Entity
@Table(name = "pinjaman")
public class Pinjaman implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, unique = true)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "anggota_nik", nullable = false)
    private Anggota anggota;

    @Column(name = "jumlah", nullable = false)
    private Long jumlah;

    @Column(name = "bunga", nullable = false, columnDefinition = "int default 0")
    private Integer bunga;

    @Column(name = "total_pinjaman", nullable = false)
    private Long total_pinjaman;

    @Column(name = "keterangan", nullable = false)
    private String keterangan;

    @Enumerated(EnumType.STRING)
    private PinjamanStatus status;

    @CreationTimestamp()
    private LocalDateTime tanggal_transaksi;

    @OneToMany(mappedBy = "pinjaman", cascade = CascadeType.REMOVE)
    private Set<Angsuran> dataAngsuran;

    public static enum PinjamanStatus {
        LUNAS, BELUM_LUNAS
    }

    public Pinjaman() {
    }

    public Pinjaman(Integer id) {
        this.id = id;
    }

    public Pinjaman(Integer id, Anggota anggota, Long jumlah, Integer bunga, Long total_pinjaman, String keterangan, PinjamanStatus status, LocalDateTime tanggal_transaksi) {
        this.id = id;
        this.anggota = anggota;
        this.jumlah = jumlah;
        this.bunga = bunga;
        this.total_pinjaman = total_pinjaman;
        this.keterangan = keterangan;
        this.status = status;
        this.tanggal_transaksi = tanggal_transaksi;
    }

    public Integer getId() {
        return id;
    }

    public Anggota getAnggota() {
        return anggota;
    }

    public Pinjaman setAnggota(Anggota anggota) {
        this.anggota = anggota;
        return this;
    }

    public Long getJumlah() {
        return jumlah;
    }

    public Pinjaman setJumlah(Long jumlah) {
        this.jumlah = jumlah;
        return this;
    }

    public Integer getBunga() {
        return bunga;
    }

    public Pinjaman setBunga(Integer bunga) {
        this.bunga = bunga;
        return this;
    }

    public Long getTotalPinjaman() {
        return total_pinjaman;
    }

    public Pinjaman setTotalPinjaman(Long total_pinjaman) {
        this.total_pinjaman = total_pinjaman;
        return this;
    }

    public String getKeterangan() {
        return keterangan;
    }

    public Pinjaman setKeterangan(String keterangan) {
        this.keterangan = keterangan;
        return this;
    }

    public PinjamanStatus getStatus() {
        return status;
    }

    public Pinjaman setStatus(PinjamanStatus status) {
        this.status = status;
        return this;
    }

    public LocalDateTime getTanggalTransaksi() {
        return tanggal_transaksi;
    }

    public Pinjaman setTanggal_transaksi(LocalDateTime tanggal_transaksi) {
        this.tanggal_transaksi = tanggal_transaksi;
        return this;
    }

    @Override
    public String toString() {
        return this.id + " - " + Helpers.formatRupiah(this.total_pinjaman);
    }

}
