package com.company.config;

import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.User.UserBuilder;

@Configuration
@EnableWebSecurity
public class SecurityConfigurerAdapter extends WebSecurityConfigurerAdapter {

	@Autowired
	AuthenticationSuccessHandler authenticationSuccessHandler;

//	// Authentication without JDBC
//	@Override
//	protected void configure(AuthenticationManagerBuilder authenticationManagerBuilder) throws Exception {
//		UserBuilder users = User.withDefaultPasswordEncoder();
//		authenticationManagerBuilder.inMemoryAuthentication()
//				.withUser(users.username("none").password("none").roles("none"))
//				.withUser(users.username("user").password("user").roles("user", "none"))
//				.withUser(users.username("admin").password("admin").roles("admin", "user", "none"))
//				.withUser(users.username("tester").password("tester").roles("tester", "admin", "user", "none"));
//	}

	// Authentication with JDBC
	@Autowired
	private DataSource dataSource;

	@Override
	protected void configure(AuthenticationManagerBuilder authenticationManagerBuilder) throws Exception {
		authenticationManagerBuilder.jdbcAuthentication().dataSource(dataSource);
	}

	@Override
	protected void configure(HttpSecurity httpSecurity) throws Exception {
		httpSecurity.authorizeRequests()
				.antMatchers("/").permitAll()
				.antMatchers("/user").hasRole("user")
				.antMatchers("/admin/**").hasRole("admin")
				.antMatchers("/tester/**").hasRole("tester")
				.and().formLogin().loginPage("/login").loginProcessingUrl("/authenticate").successHandler(authenticationSuccessHandler).permitAll()
				.and().logout().logoutSuccessUrl("/").permitAll()
				.and().exceptionHandling().accessDeniedPage("/accessDenied");
	}
}