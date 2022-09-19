package com.ozguryazilim.labwebapplication.service;

import com.ozguryazilim.labwebapplication.entity.Laborant;
import java.util.List;

public interface LaborantService {
    Laborant laborantGetir(Long id);

    void laborantEkle(Laborant laborant);

    void laborantGuncelle(Laborant laborant);

    void laborantSil(Long id);

    List<Laborant> laborantlariGetir();
}
