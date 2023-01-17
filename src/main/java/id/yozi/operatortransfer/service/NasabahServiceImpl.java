package id.yozi.operatortransfer.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import id.yozi.operatortransfer.entity.Nasabah;
import id.yozi.operatortransfer.repository.NasabahRepository;

@Service
public class NasabahServiceImpl implements NasabahService {

    @Autowired
    NasabahRepository nasabahRepository;

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
        return null;
    }

    @Override
    public Nasabah updateNasabah(Nasabah nasabah) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void deleteNasabah(Long id) {
        // TODO Auto-generated method stub

    }

}
