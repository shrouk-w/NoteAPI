package com.api.noteapp.security

import com.api.noteapp.service.UserService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.authentication.dao.DaoAuthenticationProvider
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler


import org.springframework.security.config.http.SessionCreationPolicy
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.security.web.AuthenticationEntryPoint
import org.springframework.security.web.SecurityFilterChain


@Configuration
@EnableWebSecurity
class WebSecurityConfiguration {

    @Autowired
    lateinit var service: UserService

    @Autowired
    lateinit var unauthorizedHandler: AuthenticationEntryPoint

    @Autowired
    lateinit var successHandler: WebSecurityAuthSuccessHandler

    @Bean
    fun securityFilterChain(http: HttpSecurity): SecurityFilterChain {
        http
            .csrf { it.disable() }
            .exceptionHandling { it.authenticationEntryPoint(unauthorizedHandler) }
            .sessionManagement { it.sessionCreationPolicy(SessionCreationPolicy.STATELESS) }
            .authorizeHttpRequests { auth ->
                auth
                    .requestMatchers("/notes", "/notes/**").authenticated()
                    .requestMatchers("/todos", "/todos/**").authenticated()
                    .requestMatchers("/users", "/users/**").hasAuthority("ADMIN")
                    .anyRequest().permitAll()
            }
            .formLogin { login ->
                login
                    .successHandler(successHandler)
                    .failureHandler(SimpleUrlAuthenticationFailureHandler())
            }
            .logout { logout -> logout.logoutUrl("/logout").invalidateHttpSession(true).deleteCookies("JSESSIONID") }

        return http.build()
    }

    @Bean
    fun authenticationProvider(): DaoAuthenticationProvider {
        val authProvider = DaoAuthenticationProvider()
        authProvider.setUserDetailsService(service)
        authProvider.setPasswordEncoder(encoder())
        return authProvider
    }
    @Bean
    fun encoder(): PasswordEncoder = BCryptPasswordEncoder(11)

}