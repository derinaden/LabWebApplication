package com.ozguryazilim.labwebapplication.service;

import com.ozguryazilim.labwebapplication.entity.Laborant;
import com.ozguryazilim.labwebapplication.repository.LaborantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class LaborantServiceImpl implements LaborantService {

    @Autowired
    private LaborantRepository laborantRepository;

    @Override
    public Laborant laborantGetir(Long id) {
        return laborantRepository.findById(id).get();
    }

    @Override
    public void laborantEkle(Laborant laborant) {
        laborantRepository.save(laborant);
    }

    @Override
    public void laborantGuncelle(Laborant laborant) {
        laborant.setIsim(laborant.getIsim());
        laborant.setSoyisim(laborant.getSoyisim());
        laborant.setKullaniciAdi(laborant.getKullaniciAdi());
        laborant.setSifre(laborant.getSifre());
        laborant.setRol(laborant.getRol());

        laborantRepository.save(laborant);
    }

    @Override
    public void laborantSil(Long id) {
        laborantRepository.deleteById(id);
    }

    @Override
    public List<Laborant> laborantlariGetir() {
        return laborantRepository.findAll();
    }
}
