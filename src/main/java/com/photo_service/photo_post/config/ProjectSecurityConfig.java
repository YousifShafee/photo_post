package com.photo_service.photo_post.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import com.photo_service.photo_post.constants.PhotoPostConstants;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
public class ProjectSecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.csrf(csrf -> csrf.ignoringAntMatchers("/public/**"))
            .authorizeRequests(requests -> requests
                .mvcMatchers("/home").permitAll()
                .mvcMatchers("/login").permitAll()
                .mvcMatchers("/public/**").permitAll()
                .mvcMatchers("/greet").authenticated()
                .mvcMatchers("/photo/**").permitAll()
                .mvcMatchers("/user/**").hasRole(PhotoPostConstants.USER_ROLE)
                .mvcMatchers("/admin/**").hasRole(PhotoPostConstants.ADMIN_ROLE))
                .formLogin(login -> login.loginPage("/login")
                    .defaultSuccessUrl("/greet").failureUrl("/login?error=true").permitAll())
                    .logout(logout -> logout.logoutSuccessUrl("/login?logout=true").invalidateHttpSession(true).permitAll()).httpBasic(withDefaults());
    }
}
