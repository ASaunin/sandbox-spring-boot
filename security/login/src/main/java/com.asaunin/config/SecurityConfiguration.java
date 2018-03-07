package com.asaunin.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(securedEnabled = true)
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

	@Autowired
	public void configureAuth(AuthenticationManagerBuilder auth) throws Exception {
		auth
			.inMemoryAuthentication()
				.withUser("admin")
					.password("{noop}admin")
					.roles("ADMIN")
					.and()
				.withUser("john")
					.password("{noop}doe")
					.roles("USER");
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
			.authorizeRequests()
				.antMatchers("/","/guest").permitAll()
				.antMatchers("/webjars/**").permitAll()
				.antMatchers("/static/**").permitAll()
				.antMatchers("/user").authenticated()
                .antMatchers("/admin/**").hasRole("ADMIN")
				.and()
			.formLogin()
				.loginPage("/login")
                .usernameParameter("email")
                .passwordParameter("password")
				.defaultSuccessUrl("/")
				.and()
			.logout()
				.logoutUrl("/logout")
				.logoutSuccessUrl("/")
                .permitAll()
                .and()
			.csrf()
				.disable();
	}

}