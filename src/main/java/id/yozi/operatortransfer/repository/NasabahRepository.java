package id.yozi.operatortransfer.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import id.yozi.operatortransfer.entity.Nasabah;
import id.yozi.operatortransfer.entity.Rekening;
import jakarta.transaction.Transactional;

@Repository
public interface NasabahRepository extends JpaRepository<Nasabah, Long> {

    
}
