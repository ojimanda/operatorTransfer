package id.yozi.operatortransfer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import id.yozi.operatortransfer.entity.Rekening;
import id.yozi.operatortransfer.repository.RekeningRepository;
import jakarta.persistence.EntityManager;

@Component
public class utils {

    @Autowired
    RekeningRepository rekeningRepository;

    public Rekening getDetailRekening(String rek) {
        return new Rekening();
    }

    // @Bean(name = "getstring")
    public String getString(String str) {
        // Rekening rekening = rekeningRepository.findByNoRekening(str);
        return str;
    }
}
