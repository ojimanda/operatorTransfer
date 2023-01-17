package id.yozi.operatortransfer.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import id.yozi.operatortransfer.entity.Role;
import id.yozi.operatortransfer.entity.User;
import id.yozi.operatortransfer.repository.RoleRepository;
import id.yozi.operatortransfer.repository.UserRepository;
import jakarta.annotation.PostConstruct;
import jakarta.transaction.Transactional;

@Service
@Transactional
public class InitDefaultUserAuth {

//    @Autowired
//    private RoleRepository roleRepository;
//    @Autowired
//    private UserRepository userRepository;
//
//    @PostConstruct
//    public void index() {
//        Role roleCustomer = new Role();
//        Role roleAdmin = new Role();
//        Role roleOperator = new Role();
//
//        roleCustomer.setRole("customer");
//        roleAdmin.setRole("admin");
//        roleOperator.setRole("operator");
//        roleRepository.save(roleCustomer);
//        roleRepository.save(roleAdmin);
//        roleRepository.save(roleOperator);
//
//        // create user
//        User gm = new User();
//        gm.setUsername("ojimanda");
//        gm.setPassword(new BCryptPasswordEncoder().encode("1234"));
//        List<Role> roles = new ArrayList<>();
//        roles.add(roleAdmin);
//        roles.add(roleCustomer);
//        roles.add(roleOperator);
//        gm.setRoles(roles);
//        userRepository.save(gm);
//
//        User admin = new User();
//        admin.setUsername("admin");
//        admin.setPassword(new BCryptPasswordEncoder().encode("admin"));
//        List<Role> rolesAdmin = new ArrayList<>();
//        rolesAdmin.add(roleAdmin);
//        admin.setRoles(rolesAdmin);
//        userRepository.save(admin);
//
//        User userCustomer = new User();
//        userCustomer.setUsername("customer");
//        userCustomer.setPassword(new BCryptPasswordEncoder().encode("customer"));
//        List<Role> rolesCustomer = new ArrayList<>();
//        rolesCustomer.add(roleCustomer);
//        userCustomer.setRoles(rolesCustomer);
//        userRepository.save(userCustomer);
//
//        User userOperator = new User();
//        userOperator.setUsername("operator");
//        userOperator.setPassword(new BCryptPasswordEncoder().encode("operator"));
//        List<Role> rolesOperator = new ArrayList<>();
//        rolesOperator.add(roleOperator);
//        userOperator.setRoles(rolesOperator);
//        userRepository.save(userOperator);
//    }
}
