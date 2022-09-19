package com.ozguryazilim.labwebapplication.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Configuration
@EnableWebSecurity
public class WebGuvenlik extends WebSecurityConfigurerAdapter {
    public static final String[] PUBLIC_MATCHERS = {
            "/",
            "/login",
            "/css/**",
            "/js/**",
            "/images/**",
            "/webjars/**",
            "/h2-console/**",
            "/anamenu",
            "/raporlar",
            "/raporlar/tablo"
    };

    public static final String[] LABORANT_MATCHERS = {
            "/laborantlar/**"
    };

    public static final String[] RAPOR_MATCHERS = {
            "/raporlar/**"
    };

    public static final String[] LABORANT_RAPOR_MATCHERS = {
            "/laborantlar/**",
            "/raporlar/**"
    };

    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers("/resources/**", "/static/**", "/css/**", "/js/**", "/images/**");
        web.ignoring().antMatchers("/h2-console/**");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable()
                .authorizeRequests()
                .antMatchers("/", "/h2-console", "/raporlar/**").permitAll()
                .antMatchers("/laborantlar/**").permitAll()
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .loginPage("/login")
                .loginProcessingUrl("/login")
                .defaultSuccessUrl("/", true)
                .failureUrl("/login.html?error=true")
                .failureHandler(new AuthenticationFailureHandler() {
                    @Override
                    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception) throws IOException, ServletException {
                        response.sendRedirect("/login.html?error=true");
                    }
                })
                .permitAll()
                .and()
                .logout()
                .permitAll();

        http.headers().frameOptions().disable();
    }

    @Override
    public void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .withUser("admin").password("{noop}admin").roles("ADMIN")
                .and()
                .withUser("laborant").password("{noop}laborant").roles("LABORANT");
    }
}
