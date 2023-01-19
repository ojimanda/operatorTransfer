package id.yozi.operatortransfer.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import id.yozi.operatortransfer.entity.Nasabah;
import id.yozi.operatortransfer.entity.Rekening;
import id.yozi.operatortransfer.service.NasabahService;
import id.yozi.operatortransfer.service.RekeningService;
import jakarta.transaction.Transactional;

@Controller
@RequestMapping("/customer")
public class NasabahController {

    @Autowired
    NasabahService nasabahService;

    @Autowired
    RekeningService rekeningService;

    @GetMapping
    public String homeCustomer(Model model) {
        List<Nasabah> nasabahs = nasabahService.getAllNasabah();
        List<String> tipeIdentity = new ArrayList<>();
        tipeIdentity.add("KTP");
        tipeIdentity.add("SIM");
        model.addAttribute("tipeIdentitas", tipeIdentity);
        model.addAttribute("nasabah", new Nasabah());
        model.addAttribute("nasabahs", nasabahs);
        return "customerService/home";
    }

    @GetMapping("/edit")
    public String editNasabah(Model model, @RequestParam("id") Long id) {
        List<Nasabah> nasabahs = nasabahService.getAllNasabah();
        List<String> tipeIdentity = new ArrayList<>();
        tipeIdentity.add("KTP");
        tipeIdentity.add("SIM");
        model.addAttribute("tipeIdentitas", tipeIdentity);
        Nasabah nasabah = nasabahService.getNasabah(id);
        model.addAttribute("nasabah", nasabah);
        model.addAttribute("nasabahs", nasabahs);
        return "customerService/home";
    }

    @PostMapping("/edit")
    public String updateNasabah(Model model, @RequestParam("id") Long id, @ModelAttribute("nasabah") Nasabah nasabah) {
        nasabahService.updateNasabah(id, nasabah);
        List<Nasabah> nasabahs = nasabahService.getAllNasabah();
        List<String> tipeIdentity = new ArrayList<>();
        tipeIdentity.add("KTP");
        tipeIdentity.add("SIM");
        model.addAttribute("tipeIdentitas", tipeIdentity);
        model.addAttribute("nasabah", new Nasabah());
        model.addAttribute("nasabahs", nasabahs);
        return "redirect:/customer";
    }

    @PostMapping
    public String addNasabah(Model model, @ModelAttribute("nasabah") Nasabah nasabah) {
        List<Nasabah> nasabahs = nasabahService.getAllNasabah();
        List<String> tipeIdentity = new ArrayList<>();
        tipeIdentity.add("KTP");
        tipeIdentity.add("SIM");
        model.addAttribute("tipeIdentitas", tipeIdentity);
        model.addAttribute("nasabah", new Nasabah());
        model.addAttribute("nasabahs", nasabahs);
        nasabahService.addNasabah(nasabah);

        return "redirect:/customer";
    }

    @GetMapping("/delete")
    @Transactional
    public String deleteNasabah(Model model, @RequestParam("id") Long id) {
        List<Nasabah> nasabahs = nasabahService.getAllNasabah();
        model.addAttribute("nasabah", new Nasabah());
        model.addAttribute("nasabahs", nasabahs);
        List<String> tipeIdentity = new ArrayList<>();
        tipeIdentity.add("KTP");
        tipeIdentity.add("SIM");
        model.addAttribute("tipeIdentitas", tipeIdentity);
        nasabahService.deleteNasabah(id);
        return "redirect:/customer";
    }
}
