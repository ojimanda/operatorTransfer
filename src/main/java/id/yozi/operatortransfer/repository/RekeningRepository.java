package id.yozi.operatortransfer.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import id.yozi.operatortransfer.entity.Nasabah;
import id.yozi.operatortransfer.entity.Rekening;
import jakarta.transaction.Transactional;

@Repository
public interface RekeningRepository extends JpaRepository<Rekening, Long> {

    // Rekening findByNasabah(Nasabah nasabah);

    void deleteAllByNasabah(Nasabah nasabah);

    List<Rekening> findByNasabah(Optional<Nasabah> findById);

    Rekening findByNoRekening(String noRekening);

    @Modifying(clearAutomatically = true, flushAutomatically = true)
    @Transactional
    @Query(value = "DELETE FROM rekening WHERE id = ?1", nativeQuery = true)
    void deleteById(Long id);

    // @Modifying
    // @Transactional
    // @Query(value = "UPDATE nasabah n set n.rekening = ?2 where u.lastname = ?1",
    // nativeQuery = true)
    // void tambahRekening(Long id, List<Rekening> rekening);

}
