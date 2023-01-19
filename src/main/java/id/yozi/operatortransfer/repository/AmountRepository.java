package id.yozi.operatortransfer.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import id.yozi.operatortransfer.entity.Amount;

@Repository
public interface AmountRepository extends JpaRepository<Amount, Long> {

}
