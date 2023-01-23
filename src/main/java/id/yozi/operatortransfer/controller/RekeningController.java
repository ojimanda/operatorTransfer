package id.yozi.operatortransfer.controller;

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
import id.yozi.operatortransfer.entity.Provider;
import id.yozi.operatortransfer.entity.Rekening;
import id.yozi.operatortransfer.service.NasabahService;
import id.yozi.operatortransfer.service.ProviderService;
import id.yozi.operatortransfer.service.RekeningService;

@Controller
@RequestMapping("/rekening")
public class RekeningController {

    @Autowired
    NasabahService nasabahService;

    @Autowired
    ProviderService providerService;

    @Autowired
    RekeningService rekeningService;

    @GetMapping
    public String rekeningNasabah(Model model, @RequestParam("id") Long id) {
        Nasabah nasabah = nasabahService.getNasabah(id);
        // List<Rekening> rekening = nasabah.getRekening();
        List<Rekening> rekening = nasabah.getRekening();
        List<Provider> providers = providerService.getAllProvider();
        // for (Rekening rekening2 : rekening) {
        // System.out.println(rekening2.getNoRekening());
        // }
        model.addAttribute("listProvider", providers);
        model.addAttribute("rekening", new Rekening());
        model.addAttribute("listRekening", rekening);
        model.addAttribute("nasabah", nasabah);
        return "customerService/rekening";
    }

    @PostMapping
    public String addRekening(@ModelAttribute("rekening") Rekening rekening, Model model, @RequestParam("id") Long id) {
        Nasabah nasabah = nasabahService.getNasabah(id);
        rekeningService.addRekening(id, rekening);
        List<Rekening> getRekening = nasabah.getRekening();
        List<Provider> providers = providerService.getAllProvider();
        model.addAttribute("listProvider", providers);
        model.addAttribute("rekening", new Rekening());
        model.addAttribute("listRekening", getRekening);
        return "redirect:/customer";
    }

    @GetMapping("/delete")
    public String deleteRekening(@RequestParam("idrek") Long idrek) {
        rekeningService.deleteRekening(idrek);
        return "redirect:/customer";
    }
}
