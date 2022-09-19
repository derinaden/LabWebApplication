package com.ozguryazilim.labwebapplication.entity;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.*;
import java.io.IOException;
import java.time.LocalDateTime;
import org.apache.commons.io.FilenameUtils;


@Entity
@Table(name = "raporlar")
public class Rapor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String dosyaNum;

    private String hastaAdi;

    private String hastaSoyadi;

    private String hastaKimlikNo;

    private String taniBaslik;

    private String taniDetay;

    @DateTimeFormat (pattern = "yyyy-MM-dd'T'HH:mm")
    private LocalDateTime tarih;

    @Lob
    @Column(columnDefinition = "BLOB")
    private byte[] rapor_img;

    @Column(name = "uzantı")
    private String uzantı;

    @ManyToOne
    @JoinColumn(name = "laborant_id")
    private Laborant laborant;

    public Rapor() {
    }

    public Rapor(Long id, String dosyaNum, String hastaAdi, String hastaSoyadi, String hastaKimlikNo, String taniBaslik,
                 String taniDetay, LocalDateTime tarih, byte[] rapor_img, Laborant laborant) {
        this.id = id;
        this.dosyaNum = dosyaNum;
        this.hastaAdi = hastaAdi;
        this.hastaSoyadi = hastaSoyadi;
        this.hastaKimlikNo = hastaKimlikNo;
        this.taniBaslik = taniBaslik;
        this.taniDetay = taniDetay;
        this.tarih = tarih;
        this.rapor_img = rapor_img;
        this.laborant = laborant;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDosyaNum() {
        return dosyaNum;
    }

    public void setDosyaNum(String dosyaNum) {
        this.dosyaNum = dosyaNum;
    }

    public String getHastaAdi() {
        return hastaAdi;
    }

    public void setHastaAdi(String hastaAdi) {
        this.hastaAdi = hastaAdi;
    }

    public String getHastaSoyadi() {
        return hastaSoyadi;
    }

    public void setHastaSoyadi(String hastaSoyadi) {
        this.hastaSoyadi = hastaSoyadi;
    }

    public String getHastaKimlikNo() {
        return hastaKimlikNo;
    }

    public void setHastaKimlikNo(String hastaKimlikNo) {
        this.hastaKimlikNo = hastaKimlikNo;
    }

    public String getTaniBaslik() {
        return taniBaslik;
    }

    public void setTaniBaslik(String taniBaslik) {
        this.taniBaslik = taniBaslik;
    }

    public String getTaniDetay() {
        return taniDetay;
    }

    public void setTaniDetay(String taniDetay) {
        this.taniDetay = taniDetay;
    }

    public LocalDateTime getTarih() {
        return tarih;
    }

    public void setTarih(LocalDateTime tarih) {
        this.tarih = tarih;
    }

    public String getUzantı() {
        return uzantı;
    }

    public void setUzantı(String uzantı) {
        this.uzantı = uzantı;
    }

    public Laborant getLaborant() {
        return laborant;
    }

    public void setLaborant(Laborant laborant) {
        this.laborant = laborant;
    }

    public byte[] getRapor_img() {
        return rapor_img;
    }

    public void setRapor_img(MultipartFile file) throws IOException {
        uzantı = FilenameUtils.getExtension(file.getOriginalFilename());
        this.rapor_img = file.getBytes();
    }
}
