package com.archerprop.peja.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import com.archerprop.peja.service.UsuarioService;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig {

    @Autowired

    private UsuarioService usuarioService;

    @Bean
    BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.authenticationProvider(new DaoAuthenticationProvider() {
            {
                setPasswordEncoder(passwordEncoder());
                setUserDetailsService(usuarioService);
            }
        })
                .csrf(withDefaults())
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/form/**").permitAll()
                        .requestMatchers("/js/**", "/css/**", "/sources/**").permitAll()
                        .requestMatchers("/admin/**").hasAnyAuthority("ADMIN", "SUPERADMIN")
                        .requestMatchers("/user/**").hasAnyAuthority("DOCENTE", "ESTUDIANTE")
                        .anyRequest().authenticated())
                .formLogin(form -> form
                        .loginPage("/login")
                        .defaultSuccessUrl("/home", true)
                        .permitAll())
                .logout(logout -> logout
                        .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
                        .logoutSuccessUrl("/login?logout")
                        .invalidateHttpSession(true)
                        .deleteCookies("JSESSIONID")
                        .permitAll());
        return http.build();
    }

}