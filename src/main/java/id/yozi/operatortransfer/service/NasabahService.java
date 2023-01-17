package id.yozi.operatortransfer.service;

import java.util.List;

import org.springframework.stereotype.Service;

import id.yozi.operatortransfer.entity.Nasabah;

@Service
public interface NasabahService {

    public List<Nasabah> getAllNasabah();

    public Nasabah getNasabah(Long id);

    public Nasabah addNasabah(Nasabah nasabah);

    public Nasabah updateNasabah(Long id, Nasabah nasabah);

    public void deleteNasabah(Long id);
}
