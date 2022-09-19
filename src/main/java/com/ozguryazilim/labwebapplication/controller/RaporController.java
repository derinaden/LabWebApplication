package com.ozguryazilim.labwebapplication.controller;

import com.ozguryazilim.labwebapplication.entity.Laborant;
import com.ozguryazilim.labwebapplication.entity.Rapor;
import com.ozguryazilim.labwebapplication.service.LaborantServiceImpl;
import com.ozguryazilim.labwebapplication.service.RaporServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Controller
@RequestMapping("/raporlar")
public class RaporController {
    private boolean raporSirala = true;

    private RaporServiceImpl raporService;

    private LaborantServiceImpl laborantService;

    @Autowired
    public RaporController(RaporServiceImpl raporService, LaborantServiceImpl laborantService) {
        this.raporService = raporService;
        this.laborantService = laborantService;
    }

    @GetMapping("/anasayfa")
    public String anasayfa() {
        return "raporanasayfa";
    }

    @GetMapping("/tablo")
    public String tablo(Model model) {
        List<Rapor> raporlar = raporService.raporlariGetir();

        model.addAttribute("raporlar", raporlar);

        return "raporlar";
    }

    @GetMapping("/raporKayit")
    public String raporKayit(Model model) {
        Rapor rapor = new Rapor();
        List<Laborant> laborantlar = laborantService.laborantlariGetir();

        model.addAttribute("rapor", rapor);
        if(laborantlar.size() > 0) {
            model.addAttribute("laborantlar", laborantlar);
        }

        return "raporKayit";
    }

    @PostMapping("/raporEkle")
    public String raporEkle(@ModelAttribute("rapor") Rapor rapor, BindingResult result) {

        if (!result.hasErrors()) {
            raporService.kaydet(rapor);
            return "redirect:/raporlar/tablo";
        }

        return "raporKayit";
    }

    @GetMapping("/raporGuncelle")
    public String raporGuncelle(@RequestParam("id") Long id, Model model) {
        Rapor rapor = raporService.idBul(id);
        List<Laborant> laborantlar = laborantService.laborantlariGetir();

        model.addAttribute("rapor", rapor);
        model.addAttribute("laborantlar", laborantlar);

        return "raporGuncelle";
    }

    @GetMapping("/raporSil")
    public String raporSil(@RequestParam("raporId") Long id) {
        raporService.sil(id);

        return "redirect:/raporlar/tablo";
    }

    @GetMapping("/raporAra")
    public String raporAra(@RequestParam("aranan") String aranan, Model model) {
        List<Rapor> raporlar = raporService.ara(aranan);

        model.addAttribute("raporlar", raporlar);

        return "raporlar";
    }

    @GetMapping("/raporSirala")
    public String raporSirala(Model model) {
        List<Rapor> raporlar;

        if(raporSirala) {
            raporlar = raporService.artanTariheGoreSirala();
            raporSirala = false;
        } else {
            raporlar = raporService.azalanTariheGoreSirala();
            raporSirala = true;
        }

        model.addAttribute("raporlar", raporlar);

        return "raporlar";
    }

    @GetMapping("/raporIndir")
    public ResponseEntity<?> indir(@RequestParam("id") Long id) {
        Rapor rapor = raporService.idBul(id);

        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION,
                        "attachment; filename=\"" + rapor.getHastaAdi() + "\"." + rapor.getUzantı())
                .body(new ByteArrayResource(rapor.getRapor_img()));
    }
}
