package id.yozi.operatortransfer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import id.yozi.operatortransfer.entity.Rekening;
import id.yozi.operatortransfer.repository.RekeningRepository;

@Configuration
@SpringBootApplication
public class OperatortransferApplication {

	@Autowired
	RekeningRepository rekeningRepository;

	public static void main(String[] args) {
		SpringApplication.run(OperatortransferApplication.class, args);
	}

	

}
