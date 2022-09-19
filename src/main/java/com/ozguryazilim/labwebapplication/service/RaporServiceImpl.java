package com.ozguryazilim.labwebapplication.service;

import com.ozguryazilim.labwebapplication.entity.Rapor;
import com.ozguryazilim.labwebapplication.repository.RaporRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RaporServiceImpl implements RaporService {

    @Autowired
    private RaporRepository raporRepository;

    @Override
    public List<Rapor> raporlariGetir() {
        return raporRepository.findAll();
    }

    @Override
    public Rapor idBul(Long id) {
        return raporRepository.findById(id).get();
    }

    @Override
    public void kaydet(Rapor rapor) {
         raporRepository.save(rapor);
    }

    @Override
    public void sil(Long id) {
        raporRepository.deleteById(id);
    }

    @Override
    public List<Rapor> ara(String ara) {
        List<Rapor> sonuclar = null;
        if (ara != null && (ara.trim().length() > 0)) {
            sonuclar = raporRepository.findByHastaAdiContainingOrHastaSoyadiContainingOrHastaKimlikNoContaining(ara);
        } else if (ara.trim().length() == 0) {
            sonuclar = raporRepository.findAll();
        }
        return sonuclar;
    }

    @Override
    public List<Rapor> azalanTariheGoreSirala() {
        return raporRepository.findByOrderByTarihDesc();
    }

    @Override
    public List<Rapor> artanTariheGoreSirala() {
        return raporRepository.findByOrderByTarihAsc();
    }
}
