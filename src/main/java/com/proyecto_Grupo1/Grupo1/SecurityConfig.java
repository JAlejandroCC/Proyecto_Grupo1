package com.proyecto_Grupo1.Grupo1;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .withUser("admin").password("{noop}2511").roles("admin").and()
                
                .withUser("user").password("{noop}1125").roles("user").and()
        
                .withUser("client").password("{noop}123").roles("client").and()
                
                .withUser("hacker").password("{noop}123").roles("hacker");
    } 
    
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                
                
                
                .antMatchers("/").hasAnyRole("user","admin","client")
                
                
                .and().formLogin().loginPage("/login")
                
                .and().exceptionHandling().accessDeniedPage("/errores/403");
    }
}
