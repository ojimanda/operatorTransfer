package id.yozi.operatortransfer.service;

import id.yozi.operatortransfer.entity.Role;
import id.yozi.operatortransfer.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserDetailServiceImpl implements UserDetailsService {

    @Autowired
    LoginService loginService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        User user = loginService.findByUsername(username);
        List<GrantedAuthority> authorities = new ArrayList<>();

        if (user != null) {
            List<Role> roles = user.getRoles();
            if (roles.size() > 0) {
                for (Role role : roles) {
                    authorities.add(new SimpleGrantedAuthority(role.getRole()));
                }
            }
            UserDetails userDetails = org.springframework.security.core.userdetails.User
                    .withUsername(user.getUsername())
                    .password(user.getPassword())
                    .authorities(authorities)
                    .build();

            return userDetails;
        }

        throw new UsernameNotFoundException("User not found");
    }
}
