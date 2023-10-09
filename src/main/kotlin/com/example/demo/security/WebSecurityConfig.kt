package com.example.demo.security

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.core.userdetails.User
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.security.crypto.factory.PasswordEncoderFactories
import org.springframework.security.provisioning.InMemoryUserDetailsManager
import org.springframework.security.web.SecurityFilterChain
import java.util.function.Function

@Configuration
@EnableWebSecurity
class WebSecurityConfig {
/*    @Bean
    fun securityFilterChain(http: HttpSecurity): SecurityFilterChain {
        http
                .authorizeHttpRequests { requests ->
                    requests.requestMatchers("/").permitAll()
                            .anyRequest().authenticated()
                }
                .formLogin { form -> form.loginPage("/login").permitAll() }
                .logout { logout -> logout.permitAll() }
        return http.build()
    }*/

    @Bean
    fun userDetailsService(): UserDetailsService {
        val encoder = PasswordEncoderFactories.createDelegatingPasswordEncoder()
        val user = User.withUsername("user").password(encoder.encode("password")).roles("USER").build()
        return InMemoryUserDetailsManager(user)
    }
}