package id.yozi.operatortransfer.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import id.yozi.operatortransfer.entity.History;

@Repository
public interface HistoryRepository extends JpaRepository<History, Long> {

}
