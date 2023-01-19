package id.yozi.operatortransfer.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import id.yozi.operatortransfer.entity.Nasabah;
import id.yozi.operatortransfer.entity.Rekening;
import id.yozi.operatortransfer.repository.NasabahRepository;
import id.yozi.operatortransfer.repository.ProviderRepository;
import id.yozi.operatortransfer.repository.RekeningRepository;

@Service
public class RekeningService {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    RekeningRepository rekeningRepository;

    @Autowired
    NasabahRepository nasabahRepository;

    @Autowired
    ProviderRepository providerRepository;

    public List<Rekening> getAllRekening() {
        return rekeningRepository.findAll();
    }

    public List<Rekening> getRekeningNasabah(Long id) {
        // return nasabahRepository.findById(id).get().getRekening();
        return rekeningRepository.findByNasabah(nasabahRepository.findById(id));
    }

    public Rekening getRekeningByNoRek(String noRek) {
        return rekeningRepository.findByNoRekening(noRek);
    }

    public Rekening getRekeningById(Long id) {
        return rekeningRepository.findById(id).orElse(null);
    }

    public Rekening addRekening(Long id, Rekening rekening) {
        Nasabah nasabah = nasabahRepository.findById(id).orElse(null);
        List<Rekening> getRekening = nasabah.getRekening();
        System.out.println(getRekening.size());
        List<Rekening> newRekening = new ArrayList<>();
        for (Rekening rekening2 : getRekening) {
            newRekening.add(rekening2);
            System.out.println("1 " + rekening2.getNoRekening());
        }
        rekening.setNasabah(nasabah);
        rekening.setNoRekening("" + rekening.getProvider().getKode() + randomWithRange(1000000, 9999999));
        newRekening.add(rekening);
        for (Rekening rekening2 : newRekening) {
            System.out.println("2 " + rekening2.getNoRekening());
        }
        nasabah.setRekening(newRekening);
        nasabahRepository.saveAndFlush(nasabah);

        return rekening;
    }

    public void deleteRekening(Long idRek) {
        // Nasabah nasabah = nasabahRepository.findById(id).orElse(null);
        // List<Rekening> listNasabah = nasabah.getRekening();
        // listNasabah.remove(rekeningRepository.findById(idRek).orElse(null));
        // nasabah.setRekening(listNasabah);
        // nasabahRepository.saveAndFlush(nasabah);

        rekeningRepository.deleteById(idRek);
    }

    // public void deleteRekeningByNasabah(Nasabah nasabah) {
    // rekeningRepository.deleteByNasabah(nasabah);
    // }

    int randomWithRange(int min, int max) {
        int range = (max - min) + 1;
        return (int) (Math.random() * range) + min;
    }
}
