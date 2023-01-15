package uas.mvc.models;

import java.io.Serializable;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import javax.persistence.*;
import org.hibernate.annotations.CreationTimestamp;

/**
 *
 * @author agus
 */
@Entity
@Table(name = "simpanan")
public class Simpanan implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, unique = true)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "anggota_nik", nullable = false)
    private Anggota anggota;

    @Column(name = "jumlah", nullable = false)
    private Long jumlah;

    @Enumerated(EnumType.STRING)
    private SimpananType type;

    @Column(name = "saldo_awal", nullable = false)
    private Long saldoAwal;

    @Column(name = "saldo_akhir", nullable = false)
    private Long saldoAkhir;

    @CreationTimestamp()
    private LocalDateTime tanggal_transaksi;

    @Column(name = "keterangan", nullable = true)
    private String keterangan;

    public static enum SimpananType {
        CREDIT, DEBIT
    }

    public Simpanan() {
    }

    public Simpanan(Anggota anggota, Long jumlah, SimpananType type, LocalDateTime tanggalTransaksi, String keterangan) {
        this.anggota = anggota;
        this.jumlah = jumlah;
        this.type = type;
        this.tanggal_transaksi = tanggalTransaksi;
        this.keterangan = keterangan;
    }

    public Simpanan(Integer id, Anggota anggota, Long jumlah, SimpananType type, Long saldo_awal, Long saldo_akhir, LocalDateTime tanggal_transaksi, String keterangan) {
        this.id = id;
        this.anggota = anggota;
        this.jumlah = jumlah;
        this.type = type;
        this.saldoAwal = saldo_awal;
        this.saldoAkhir = saldo_akhir;
        this.tanggal_transaksi = tanggal_transaksi;
        this.keterangan = keterangan;
    }

    public Integer getID() {
        return id;
    }

    public Anggota getAnggota() {
        return anggota;
    }

    public Simpanan setAnggota(Anggota anggota) {
        this.anggota = anggota;
        return this;
    }

    public Long getJumlah() {
        return jumlah;
    }

    public Simpanan setJumlah(Long jumlah) {
        this.jumlah = jumlah;
        return this;
    }

    public SimpananType getType() {
        return type;
    }

    public Simpanan setType(SimpananType type) {
        this.type = type;
        return this;
    }

    public Long getSaldoAwal() {
        return saldoAwal;
    }

    public Simpanan setSaldoAwal(Long saldo_awal) {
        this.saldoAwal = saldo_awal;
        return this;
    }

    public Long getSaldoAkhir() {
        return saldoAkhir;
    }

    public Simpanan setSaldoAkhir(Long saldo_akhir) {
        this.saldoAkhir = saldo_akhir;
        return this;
    }

    public LocalDateTime getTanggalTransaksi() {
        return tanggal_transaksi;
    }

    public Simpanan setTanggal_transaksi(Timestamp LocalDateTime) {
        this.tanggal_transaksi = tanggal_transaksi;
        return this;
    }

    public String getKeterangan() {
        return keterangan;
    }

    public Simpanan setKeterangan(String keterangan) {
        this.keterangan = keterangan;
        return this;
    }

}
