package id.yozi.operatortransfer.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import id.yozi.operatortransfer.entity.Nasabah;
import id.yozi.operatortransfer.entity.Rekening;

@Repository
public interface RekeningRepository extends JpaRepository<Rekening, Long> {

    void deleteByNasabah(Nasabah nasabah);

    Rekening findByNasabah(Nasabah nasabah);

}
