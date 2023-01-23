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

    @GetMapping("/edit")
    public String editProvider(Model model, @RequestParam("id") Long id) {
        List<Provider> providers = providerService.getAllProvider();
        model.addAttribute("providers", providers);
        Provider getProvider = providerService.getProviderById(id);
        model.addAttribute("provider", getProvider);

        return "admin/home";
    }

    @PostMapping("/edit")
    public String updateProvider(Model model, @RequestParam("id") Long id,
            @ModelAttribute("provider") Provider provider) {
        List<Provider> providers = providerService.getAllProvider();
        model.addAttribute("providers", providers);
        providerService.updateProvider(id, provider);
        return "redirect:/admin";
    }

    @PostMapping
    public String addProvider(@ModelAttribute("provider") Provider provider, Model model) {

        providerService.addProvider(provider);
        List<Provider> providers = providerService.getAllProvider();
        model.addAttribute("providers", providers);

        return "redirect:/admin";
    }

    @GetMapping("/delete")
    public String deleteProvider(@RequestParam("id") Long id, Model model) {
        providerService.deleteProvider(id);
        List<Provider> providers = providerService.getAllProvider();
        model.addAttribute("providers", providers);
        model.addAttribute("provider", new Provider());
        return "redirect:/admin";
    }
}
