package id.yozi.operatortransfer.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import id.yozi.operatortransfer.entity.User;
import id.yozi.operatortransfer.repository.RoleRepository;
import id.yozi.operatortransfer.repository.UserRepository;

import java.util.List;

@Service
public class LoginService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    RoleRepository roleRepository;

    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    public List<User> getUsers() {
        return userRepository.findAll();
    }

    

}
