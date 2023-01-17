package id.yozi.operatortransfer.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import id.yozi.operatortransfer.entity.Nasabah;
import id.yozi.operatortransfer.entity.Rekening;
import id.yozi.operatortransfer.repository.NasabahRepository;
import id.yozi.operatortransfer.repository.RekeningRepository;

@Service
public class RekeningService {

    @Autowired
    RekeningRepository rekeningRepository;

    @Autowired
    NasabahRepository nasabahRepository;

    public List<Rekening> getAllRekening() {
        return rekeningRepository.findAll();
    }

    public List<Rekening> getRekeningNasabah(Long id) {
        return nasabahRepository.findById(id).get().getRekening();
    }

    public Rekening getRekeningById(Long id) {
        return rekeningRepository.findById(id).orElse(null);
    }

    public Rekening addRekening(Long id, Rekening rekening) {
        Nasabah nasabah = nasabahRepository.findById(id).orElse(null);
        List<Rekening> getRekening = nasabah.getRekening();
        getRekening.add(rekening);
        nasabah.setRekening(getRekening);
        nasabahRepository.saveAndFlush(nasabah);
        return rekeningRepository.save(rekening);
    }

    public void deleteRekening(Long id) {
        nasabahRepository.deleteRekeningById(id);
        rekeningRepository.deleteById(id);
    }

}
