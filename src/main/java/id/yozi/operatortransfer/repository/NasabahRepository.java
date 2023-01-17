package id.yozi.operatortransfer.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import id.yozi.operatortransfer.entity.Nasabah;

@Repository
public interface NasabahRepository extends JpaRepository<Nasabah, Long> {

    Nasabah deleteRekeningById(Long id);

}
