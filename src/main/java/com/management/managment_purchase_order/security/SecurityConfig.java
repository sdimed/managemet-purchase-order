package com.management.managment_purchase_order.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configuration.EnableGlobalAuthentication;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(securedEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        BCryptPasswordEncoder b = new BCryptPasswordEncoder();

        auth.inMemoryAuthentication().withUser("admin").password("{noop}123").roles("ADMIN","SUPERADMIN");
        auth.inMemoryAuthentication().withUser("sidi").password("{noop}123").roles("ADMIN");
        auth.inMemoryAuthentication().withUser("ahmed").password("{noop}123").roles("SUPERADMIN");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable()
                .authorizeRequests()
                .anyRequest()
                .authenticated().and().formLogin().loginPage("/login").permitAll()
                .defaultSuccessUrl("/index.html")
                .failureUrl("/error.html");
    }
}
