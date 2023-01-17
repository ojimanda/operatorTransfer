package id.yozi.operatortransfer.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import id.yozi.operatortransfer.entity.Nasabah;
import id.yozi.operatortransfer.entity.Rekening;
import id.yozi.operatortransfer.repository.NasabahRepository;
import id.yozi.operatortransfer.repository.ProviderRepository;
import id.yozi.operatortransfer.repository.RekeningRepository;

@Service
public class NasabahServiceImpl implements NasabahService {

    @Autowired
    NasabahRepository nasabahRepository;

    @Autowired
    ProviderService providerService;

    @Autowired
    RekeningRepository rekeningRepository;

    @Override
    public List<Nasabah> getAllNasabah() {
        // TODO Auto-generated method stub
        return nasabahRepository.findAll();
    }

    @Override
    public Nasabah getNasabah(Long id) {
        // TODO Auto-generated method stub
        return nasabahRepository.findById(id).orElse(null);
    }

    @Override
    public Nasabah addNasabah(Nasabah nasabah) {
        // TODO Auto-generated method stub
        nasabahRepository.save(nasabah);
        return nasabah;
    }

    @Override
    public Nasabah updateNasabah(Long id, Nasabah nasabah) {
        // TODO Auto-generated method stub
        nasabah.setId(id);
        nasabahRepository.saveAndFlush(nasabah);
        return nasabah;
    }

    @Override
    public void deleteNasabah(Long id) {
        // TODO Auto-generated method stub
        // nasabahRepository.deleteById(id);
        // rekeningRepository.deleteByNasabah(nasabahRepository.findById(id).orElse(null));
        Nasabah nasabah = nasabahRepository.findById(id).orElse(null);
        nasabahRepository.deleteById(id);
    }

    int randomWithRange(int min, int max) {
        int range = (max - min) + 1;
        return (int) (Math.random() * range) + min;
    }

}
