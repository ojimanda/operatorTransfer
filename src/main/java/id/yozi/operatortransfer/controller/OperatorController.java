package id.yozi.operatortransfer.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import id.yozi.operatortransfer.entity.Amount;
import id.yozi.operatortransfer.entity.Rekening;
import id.yozi.operatortransfer.repository.AmountRepository;
import id.yozi.operatortransfer.repository.RekeningRepository;
import id.yozi.operatortransfer.service.AmountService;
import id.yozi.operatortransfer.service.RekeningService;

@Controller
@RequestMapping("/operator")
public class OperatorController {

    @Autowired
    RekeningService rekeningService;

    @Autowired
    AmountRepository amountRepository;

    @Autowired
    AmountService amountService;

    @Autowired
    RekeningRepository rekeningRepository;

    @GetMapping
    public String homeOperator(Model model) {

        List<Rekening> rekenings = rekeningService.getAllRekening();
        List<Amount> allAmount = amountRepository.findAll();
        model.addAttribute("amount", new Amount());
        model.addAttribute("listAmount", allAmount);
        model.addAttribute("listRekening", rekenings);
        model.addAttribute("rekPengirim", new Rekening());
        model.addAttribute("rekPenerima", new Rekening());
        return "operator/home";
    }

    @PostMapping
    public String addOperator(@ModelAttribute("rekPengirim") Rekening rekPengirim,
            @ModelAttribute("rekPenerima") Rekening rekPenerima, @ModelAttribute("amount") Amount amount, Model model) {

        String pengirim = rekPengirim.getNoRekening().split(",")[0];
        String penerima = rekPenerima.getNoRekening().split(",")[1];
        Rekening rPengirim = rekeningRepository.findByNoRekening(pengirim);
        Rekening rPenerima = rekeningRepository.findByNoRekening(penerima);
        amountService.addAmount(amount, rPengirim, rPenerima);
        List<Rekening> rekenings = rekeningService.getAllRekening();
        List<Amount> allAmount = amountRepository.findAll();
        model.addAttribute("amount", new Amount());
        model.addAttribute("listAmount", allAmount);
        model.addAttribute("listRekening", rekenings);
        model.addAttribute("rekPengirim", new Rekening());
        model.addAttribute("rekPenerima", new Rekening());
        return "redirect:/operator";
    }
}
