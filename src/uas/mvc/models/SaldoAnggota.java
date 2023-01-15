package uas.mvc.models;

import java.io.Serializable;
import javax.persistence.*;

/**
 *
 * @author agus
 */
@Entity
@Table(name = "saldo_anggota")
public class SaldoAnggota implements Serializable {

    @Id
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "anggota_nik", nullable = false)
    private Anggota anggota;

    @Column(name = "saldo_simpanan", columnDefinition = "bigint default 0")
    private Long saldo_simpanan;

    @Column(name = "sisa_pinjaman", columnDefinition = "bigint default 0")
    private Long sisa_pinjaman;

    public SaldoAnggota() {
    }

    public SaldoAnggota(Long saldo_simpanan, Long total_pinjaman) {
        this.saldo_simpanan = saldo_simpanan;
        this.sisa_pinjaman = total_pinjaman;
    }

    public SaldoAnggota(Anggota anggota, Long saldo_simpanan, Long total_pinjaman) {
        this.anggota = anggota;
        this.saldo_simpanan = saldo_simpanan;
        this.sisa_pinjaman = total_pinjaman;
    }

    public Anggota getAnggota() {
        return anggota;
    }

    public SaldoAnggota setAnggota(Anggota anggota) {
        this.anggota = anggota;
        return this;
    }

    public Long getSaldoSimpanan() {
        return saldo_simpanan;
    }

    public SaldoAnggota setSaldoSimpanan(Long saldo_simpanan) {
        this.saldo_simpanan = saldo_simpanan;
        return this;
    }

    public Long getSisaPinjaman() {
        return sisa_pinjaman;
    }

    public SaldoAnggota setSisaPinjaman(Long sisa_pinjaman) {
        this.sisa_pinjaman = sisa_pinjaman;
        return this;
    }

}
