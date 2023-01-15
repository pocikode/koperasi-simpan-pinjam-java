package uas.mvc.models;

import java.io.Serializable;
import java.sql.Date;
import java.util.Set;
import javax.persistence.*;

/**
 *
 * @author agus
 */
@Entity
@Table(name = "anggota")
public class Anggota implements Serializable {

    @Id
    @Column(name = "nik", nullable = false, unique = true)
    private Long nik;

    @Column(name = "nama", nullable = false)
    private String nama;

    @Column(name = "tempat_lahir", nullable = false)
    private String tempatLahir;

    @Column(name = "tanggal_lahir", nullable = false)
    private java.sql.Date tanggalLahir;

    @Column(name = "pekerjaan", nullable = false)
    private String pekerjaan;

    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "no_hp", nullable = false)
    private String noHP;

    @OneToOne(mappedBy = "anggota", cascade = CascadeType.REMOVE)
    private SaldoAnggota saldoAnggota;

    @OneToMany(mappedBy = "anggota", cascade = CascadeType.REMOVE)
    private Set<Simpanan> dataSimpanan;
    
    @OneToMany(mappedBy = "anggota", cascade = CascadeType.REMOVE)
    private Set<Pinjaman> dataPinjaman;
    
    @OneToMany(mappedBy = "anggota", cascade = CascadeType.REMOVE)
    private Set<Angsuran> dataAngsuran;

    public Anggota() {
    }

    public Anggota(long nik) {
        this.nik = nik;
    }

    public Anggota(Long nik, String nama, String tempat_lahir, Date tanggal_lahir, String pekerjaan, String email, String no_hp) {
        this.nik = nik;
        this.nama = nama;
        this.tempatLahir = tempat_lahir;
        this.tanggalLahir = tanggal_lahir;
        this.pekerjaan = pekerjaan;
        this.email = email;
        this.noHP = no_hp;
    }

    public Long getNik() {
        return nik;
    }

    public Anggota setNik(Long nik) {
        this.nik = nik;
        return this;
    }

    public String getNama() {
        return nama;
    }

    public Anggota setNama(String nama) {
        this.nama = nama;
        return this;
    }

    public String getTempatLahir() {
        return tempatLahir;
    }

    public Anggota setTempatLahir(String tempat_lahir) {
        this.tempatLahir = tempat_lahir;
        return this;
    }

    public Date getTanggalLahir() {
        return tanggalLahir;
    }

    public Anggota setTanggalLahir(Date tanggal_lahir) {
        this.tanggalLahir = tanggal_lahir;
        return this;
    }

    public String getPekerjaan() {
        return pekerjaan;
    }

    public Anggota setPekerjaan(String pekerjaan) {
        this.pekerjaan = pekerjaan;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public Anggota setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getNoHP() {
        return noHP;
    }

    public Anggota setNoHP(String no_hp) {
        this.noHP = no_hp;
        return this;
    }

    public SaldoAnggota getSaldoAnggota() {
        return saldoAnggota;
    }

    public Anggota setSaldoAnggota(SaldoAnggota saldoAnggota) {
        this.saldoAnggota = saldoAnggota;
        return this;
    }

    public Set<Simpanan> getDataSimpanan() {
        return dataSimpanan;
    }

    public Anggota setDataSimpanan(Set<Simpanan> dataSimpanan) {
        this.dataSimpanan = dataSimpanan;
        return this;
    }

    @Override
    public String toString() {
        return nik + " - " + nama;
    }
}
