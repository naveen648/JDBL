package com.example.SpringSecurityTest.Config;

import jakarta.servlet.DispatcherType;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
@EnableMethodSecurity
//@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.csrf((csrf) -> csrf.disable())
                .authorizeHttpRequests((authz) -> authz
//                                .requestMatchers("/home/student/**")
//                                .hasRole("STUDENT")
//
//                                .requestMatchers("/home/admin/**")
//                                .hasRole("ADMIN")
//
                                .requestMatchers("/home/public/**")
//                                .hasRole("public")   // use either .hasrole {or} .permitAll
                                .permitAll()
                                .anyRequest()
                                .authenticated()
                )
                .formLogin(withDefaults());
        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Bean
    public UserDetailsService userDetailsService(){
        UserDetails adminuser= User.withUsername("naveen")
                .password(passwordEncoder().encode("naveen"))
                .roles("ADMIN","STUDENT")
                .build();
        UserDetails studentuser= User.withUsername("student")
                .password(passwordEncoder().encode("student"))
                .roles("STUDENT")
                .build();

        return new InMemoryUserDetailsManager(adminuser,studentuser);

//      return new CustomUserDetailsService(); ***

//        UserDetails publicuser= User.withUsername("public")
//                .password("public")
//                .roles("public_role")
//                .build();
    }
}
