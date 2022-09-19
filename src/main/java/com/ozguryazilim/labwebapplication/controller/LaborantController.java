package com.ozguryazilim.labwebapplication.controller;

import com.ozguryazilim.labwebapplication.entity.Laborant;
import com.ozguryazilim.labwebapplication.service.LaborantServiceImpl;
import com.ozguryazilim.labwebapplication.service.RaporServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Controller
@RequestMapping("/laborantlar")

public class LaborantController {

    private RaporServiceImpl raporService;

    private LaborantServiceImpl laborantService;

    @Autowired
    public LaborantController(RaporServiceImpl raporService, LaborantServiceImpl laborantService) {
        this.raporService = raporService;
        this.laborantService = laborantService;
    }

    @GetMapping("/anasayfa")
    public String anasayfa(){
        return "laborantanasayfa";
    }

    @GetMapping("/tablo")
    public String tablo(Model model){
        List<Laborant> laborantlar = laborantService.laborantlariGetir();

        model.addAttribute("laborantlar", laborantlar);

        return "laborantlar";
    }

    @GetMapping("/laborantKayit")
    public String laborantKayit(Model model){
        Laborant laborant = new Laborant();
        model.addAttribute("laborant",laborant);
        return "laborantKayit";
    }

    @PostMapping("/laborantEkle")
    public String laborantEkle(@ModelAttribute("laborant") Laborant laborant, BindingResult result){
        if(!result.hasErrors()){
            laborantService.laborantEkle(laborant);
            return "redirect:/laborantlar/tablo";
        }
        return "laborantKayit";
    }

    @GetMapping("/laborantGuncelle")
    public String laborantGuncelle(@RequestParam("id") Long id, Model model){
        Laborant laborant = laborantService.laborantGetir(id);
        model.addAttribute("laborant", laborant);
        return "laborantGuncelle";
    }

    @GetMapping("/laborantSil")
    public String laborantSil(@RequestParam("id") Long id, Model model){
        laborantService.laborantSil(id);
        return "redirect:/laborantlar/anasayfa";
    }
}