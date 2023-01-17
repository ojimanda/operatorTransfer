package id.yozi.operatortransfer.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import id.yozi.operatortransfer.entity.Nasabah;
import id.yozi.operatortransfer.entity.Provider;
import id.yozi.operatortransfer.entity.Rekening;
import id.yozi.operatortransfer.entity.Role;
import id.yozi.operatortransfer.entity.User;
import id.yozi.operatortransfer.repository.NasabahRepository;
import id.yozi.operatortransfer.repository.ProviderRepository;
import id.yozi.operatortransfer.repository.RekeningRepository;
import id.yozi.operatortransfer.repository.RoleRepository;
import id.yozi.operatortransfer.repository.UserRepository;
import jakarta.annotation.PostConstruct;
import jakarta.transaction.Transactional;

@Service
@Transactional
public class InitDefaultUserAuth {

    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private UserRepository userRepository;

    @Autowired
    ProviderRepository providerRepository;

    @Autowired
    NasabahRepository nasabahRepository;

    @Autowired
    RekeningRepository rekeningRepository;

    @PostConstruct
    public void index() {
        Role roleCustomer = new Role();
        Role roleAdmin = new Role();
        Role roleOperator = new Role();

        roleCustomer.setRole("customer");
        roleAdmin.setRole("admin");
        roleOperator.setRole("operator");
        roleRepository.save(roleCustomer);
        roleRepository.save(roleAdmin);
        roleRepository.save(roleOperator);

        // create user
        User gm = new User();
        gm.setUsername("ojimanda");
        gm.setPassword(new BCryptPasswordEncoder().encode("1234"));
        List<Role> roles = new ArrayList<>();
        roles.add(roleAdmin);
        roles.add(roleCustomer);
        roles.add(roleOperator);
        gm.setRoles(roles);
        userRepository.save(gm);

        User admin = new User();
        admin.setUsername("admin");
        admin.setPassword(new BCryptPasswordEncoder().encode("admin"));
        List<Role> rolesAdmin = new ArrayList<>();
        rolesAdmin.add(roleAdmin);
        admin.setRoles(rolesAdmin);
        userRepository.save(admin);

        User userCustomer = new User();
        userCustomer.setUsername("customer");
        userCustomer.setPassword(new BCryptPasswordEncoder().encode("customer"));
        List<Role> rolesCustomer = new ArrayList<>();
        rolesCustomer.add(roleCustomer);
        userCustomer.setRoles(rolesCustomer);
        userRepository.save(userCustomer);

        User userOperator = new User();
        userOperator.setUsername("operator");
        userOperator.setPassword(new BCryptPasswordEncoder().encode("operator"));
        List<Role> rolesOperator = new ArrayList<>();
        rolesOperator.add(roleOperator);
        userOperator.setRoles(rolesOperator);
        userRepository.save(userOperator);

        // provider
        Provider provider1 = new Provider();
        provider1.setName("bni");
        provider1.setKode(101);
        providerRepository.save(provider1);
        Provider provider2 = new Provider();
        provider2.setName("bri");
        provider2.setKode(102);
        providerRepository.save(provider2);
        Provider provider3 = new Provider();
        provider3.setName("bca");
        provider3.setKode(103);
        providerRepository.save(provider3);

        // nasabah
        Nasabah nasabah1 = new Nasabah();
        nasabah1.setFullName("oji");
        nasabah1.setNoIdentity(123456);
        nasabah1.setTipeIdentity("ktp");
        nasabah1.setEmail("oji@gmail.com");
        nasabah1.setContact("123123");
        nasabahRepository.save(nasabah1);

        Nasabah nasabah2 = new Nasabah();
        nasabah2.setFullName("budi");
        nasabah2.setNoIdentity(123457);
        nasabah2.setTipeIdentity("ktp");
        nasabah2.setEmail("budi@gmail.com");
        nasabah2.setContact("123123");
        nasabahRepository.save(nasabah2);

        Nasabah nasabah3 = new Nasabah();
        nasabah3.setFullName("siti");
        nasabah3.setNoIdentity(123458);
        nasabah3.setTipeIdentity("ktp");
        nasabah3.setEmail("siti@gmail.com");
        nasabah3.setContact("123123");
        nasabahRepository.save(nasabah3);

        // rekening
        Rekening rekening1 = new Rekening();
        rekening1.setProvider(provider1);
        rekening1.setNasabah(nasabah1);
        rekening1.setNoRekening("43543");
        rekening1.setSaldo(200000);
        rekeningRepository.save(rekening1);

        Rekening rekening2 = new Rekening();
        rekening2.setProvider(provider2);
        rekening2.setNasabah(nasabah2);
        rekening2.setNoRekening("7878787");
        rekening2.setSaldo(200000);
        rekeningRepository.save(rekening2);

        Rekening rekening3 = new Rekening();
        rekening3.setProvider(provider3);
        rekening3.setNasabah(nasabah3);
        rekening3.setNoRekening("12123244");
        rekening3.setSaldo(200000);
        rekeningRepository.save(rekening3);
    }
}
