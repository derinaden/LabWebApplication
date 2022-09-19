package com.ozguryazilim.labwebapplication.entity;

import lombok.Data;
import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "laborantlar")
@Data
public class Laborant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String isim;

    private String soyisim;

    private String hastaneNo;

    private String KullaniciAdi;

    private String sifre;

    private String rol;

    @OneToMany(mappedBy = "laborant")
    private List<Rapor> raporlar;

    public Laborant() {
    }

    public Laborant(Long id, String isim, String soyisim, String hastaneNo, String kullaniciAdi, String sifre, String rol) {
        this.id = id;
        this.isim = isim;
        this.soyisim = soyisim;
        this.hastaneNo = hastaneNo;
        this.KullaniciAdi = kullaniciAdi;
        this.sifre = sifre;
        this.rol = rol;
    }

    public Laborant(Long id, String isim, String soyisim, String hastaneNo, String kullaniciAdi, String sifre, String rol, List<Rapor> raporlar) {
        this.id = id;
        this.isim = isim;
        this.soyisim = soyisim;
        this.hastaneNo = hastaneNo;
        this.KullaniciAdi = kullaniciAdi;
        this.sifre = sifre;
        this.rol = rol;
        this.raporlar = raporlar;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getIsim() {
        return isim;
    }

    public void setIsim(String isim) {
        this.isim = isim;
    }

    public String getSoyisim() {
        return soyisim;
    }

    public List<Rapor> getRaporlar() {
        return raporlar;
    }

    public void setRaporlar(List<Rapor> raporlar) {
        this.raporlar = raporlar;
    }

    public void setSoyisim(String soyisim) {
        this.soyisim = soyisim;
    }

    public String getHastaneNo() {
        return hastaneNo;
    }

    public void setHastaneNo(String hastaneNo) {
        this.hastaneNo = hastaneNo;
    }

    public String getKullaniciAdi() {
        return KullaniciAdi;
    }

    public void setKullaniciAdi(String kullaniciAdi) {
        KullaniciAdi = kullaniciAdi;
    }

    public String getSifre() {
        return sifre;
    }

    public void setSifre(String sifre) {
        this.sifre = sifre;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }
}

