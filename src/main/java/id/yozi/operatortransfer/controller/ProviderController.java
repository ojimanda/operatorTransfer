package id.yozi.operatortransfer.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import id.yozi.operatortransfer.entity.Provider;
import id.yozi.operatortransfer.service.ProviderService;

@Controller
@RequestMapping("/admin")
public class ProviderController {

    @Autowired
    ProviderService providerService;

    @GetMapping
    public String homeAdmin(Model model) {
        Provider provider = new Provider();
        List<Provider> providers = providerService.getAllProvider();
        model.addAttribute("provider", provider);
        model.addAttribute("providers", providers);
        return "admin/home";
    }

    @PostMapping
    public String addProvider(@ModelAttribute("provider") Provider provider, Model model) {

        providerService.addProvider(provider);
        List<Provider> providers = providerService.getAllProvider();
        model.addAttribute("providers", providers);

        return "redirect:/";
    }
}
