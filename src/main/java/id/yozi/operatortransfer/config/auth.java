package id.yozi.operatortransfer.config;

import id.yozi.operatortransfer.service.UserDetailServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class auth {
        @Autowired
        UserDetailServiceImpl userDetailService;

        @Bean
        public BCryptPasswordEncoder bCryptPasswordEncoder() {
                return new BCryptPasswordEncoder();
        }

        @Bean
        public DaoAuthenticationProvider authenticationProvider() {
                DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
                provider.setUserDetailsService(userDetailService);
                provider.setPasswordEncoder(bCryptPasswordEncoder());
                return provider;
        }

        @Bean
        public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
                httpSecurity.authorizeHttpRequests()
                                .requestMatchers("/").permitAll();
                httpSecurity.authorizeHttpRequests()
                                .requestMatchers("/admin/**")
                                .hasAnyAuthority("admin");
                httpSecurity.authorizeHttpRequests()
                                .requestMatchers("/customer/**", "/rekening/**")
                                .hasAnyAuthority("admin", "customer");
                httpSecurity.authorizeHttpRequests()
                                .requestMatchers("/operator/**")
                                .hasAnyAuthority("admin", "operator");
                httpSecurity.authorizeHttpRequests().anyRequest().authenticated().and().formLogin().loginPage("/login")
                                .permitAll().and().logout().logoutRequestMatcher(new AntPathRequestMatcher("/logout"));
                // httpSecurity.authorizeHttpRequests().and().formLogin();

                return httpSecurity.build();

        }
}
