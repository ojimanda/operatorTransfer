package id.yozi.operatortransfer.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import id.yozi.operatortransfer.entity.Provider;

@Repository
public interface ProviderRepository extends JpaRepository<Provider, Long> {

    Provider findByName(String name);

    @Query(value = "SELECT max(kode) FROM provider")
    int getMaxKode();
}
