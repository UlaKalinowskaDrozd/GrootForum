package com.ula.grootforum.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.*;

import javax.sql.DataSource;

/**
 * Created by Urszula Kalinowska-Drozd on 19.08.17.
 */

@EnableWebSecurity
@ComponentScan("com.ula.grootforum.*")
public class SecurityConfig extends WebSecurityConfigurerAdapter{

    @Autowired
    DataSource dataSource;

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth
                .jdbcAuthentication()
                .dataSource(dataSource)
                .usersByUsernameQuery("select password, userName, enabled, role from user where userName=?")
                .authoritiesByUsernameQuery("select userName, 'ROLE_USER' from user where userName=?");
    }

        @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers("/", "/signin", "/login", "/topicsList").permitAll()
                .antMatchers("/createTopic", "/topic/**", "/UsersList", "/user/*").hasRole("USER")
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .loginPage("/login")
                .permitAll()

                .defaultSuccessUrl("/")
                .and()
                .logout().logoutSuccessUrl("/");
    }
}
