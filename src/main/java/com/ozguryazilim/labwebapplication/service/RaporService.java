package com.ozguryazilim.labwebapplication.service;

import com.ozguryazilim.labwebapplication.entity.Rapor;

import java.util.List;

public interface RaporService {

    List<Rapor> raporlariGetir();

    Rapor idBul(Long id);

    void kaydet(Rapor rapor);

    void sil(Long id);

    List<Rapor> ara(String ara);

    List<Rapor> azalanTariheGoreSirala();

    List<Rapor> artanTariheGoreSirala();


}
