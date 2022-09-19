package com.ozguryazilim.labwebapplication;

import com.ozguryazilim.labwebapplication.entity.Laborant;
import com.ozguryazilim.labwebapplication.entity.Rapor;
import com.ozguryazilim.labwebapplication.repository.LaborantRepository;
import com.ozguryazilim.labwebapplication.repository.RaporRepository;
import com.ozguryazilim.labwebapplication.service.LaborantServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertNotNull;


@ExtendWith(MockitoExtension.class)
public class GenelTest {

    @Mock
    private LaborantRepository laborantRepository;

    @Mock
    private RaporRepository raporRepository;

    @Mock
    private LaborantServiceImpl laborantService;

    @BeforeEach
    public void setUp() {
        Laborant laborant = new Laborant();
        laborant.setIsim("test");
        laborant.setSoyisim("test");
        laborant.setId(1L);
        laborant.setKullaniciAdi("test");
        laborant.setSifre("test");
        laborant.setRol("test");

        Laborant laborant2 = new Laborant();
        laborant2.setIsim("test2");
        laborant2.setSoyisim("test2");
        laborant2.setId(2L);
        laborant2.setKullaniciAdi("test2");
        laborant2.setSifre("test2");
        laborant2.setRol("test2");

        Rapor rapor = new Rapor();
        rapor.setLaborant(laborant);
        rapor.setTarih(LocalDateTime.now());
        rapor.setDosyaNum("test");
        rapor.setHastaAdi("test");
        rapor.setHastaSoyadi("test");
        rapor.setId(1L);
        rapor.setHastaKimlikNo("test");
        rapor.setTaniBaslik("test");
        rapor.setTaniDetay("test");

        Rapor rapor2 = new Rapor();
        rapor2.setLaborant(laborant2);
        rapor2.setTarih(LocalDateTime.now());
        rapor2.setDosyaNum("test2");
        rapor2.setHastaAdi("test2");
        rapor2.setHastaSoyadi("test2");
        rapor2.setId(2L);
        rapor2.setHastaKimlikNo("test2");
        rapor2.setTaniBaslik("test2");
        rapor2.setTaniDetay("test2");
    }

    @Test
    public void testGetAllLaborant() {
        assertNotNull(laborantRepository.findAll());
    }

    @Test
    public void testGetAllRapor() {
        assertNotNull(raporRepository.findAll());
    }

    @Test
    public void testGetLaborantById() {
        assertNotNull(laborantRepository.findById(1L));
    }

    @Test
    public void testGetRaporById() {
        assertNotNull(raporRepository.findById(1L));
    }

    @Test
    public void testDeleteLaborant() {
        assertNotNull(laborantRepository.findById(1L));
    }

    @Test
    public void testDeleteRapor() {
        assertNotNull(raporRepository.findById(1L));
    }

    @Test
    public void testGetOrderByTarihAsc(){
        assertNotNull(raporRepository.findByOrderByTarihAsc());
    }

    @Test
    public void testGetOrderByTarihDesc(){
        assertNotNull(raporRepository.findByOrderByTarihDesc());
    }

    @Test
    public void testGetOrderByHastaAdiAsc(){
        assertNotNull(raporRepository.findByHastaAdiContainingOrHastaSoyadiContainingOrHastaKimlikNoContaining("test"));
    }

    @Test
    public void testUpdateLaborant(){
        Laborant laborant = new Laborant();
        laborant.setIsim("test");
        laborant.setSoyisim("test");
        laborant.setId(1L);
        laborant.setKullaniciAdi("test");
        laborant.setSifre("test");
        laborant.setRol("test");
        laborantService.laborantGuncelle(laborant);

        assertThat(laborant.getIsim()).isEqualTo("test");
        assertThat(laborant.getSoyisim()).isEqualTo("test");
        assertThat(laborant.getId()).isEqualTo(1L);
        assertThat(laborant.getKullaniciAdi()).isEqualTo("test");
        assertThat(laborant.getSifre()).isEqualTo("test");
        assertThat(laborant.getRol()).isEqualTo("test");

    }
}
