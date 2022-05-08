package com.acom.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;


@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{
	
	@Autowired
	private AuthenticationSuccessHandler successHandler;
	
	@Autowired
	private UserDetailsService userDetailsService;

	
	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Bean
	@Override
	protected AuthenticationManager authenticationManager() throws Exception {
		// TODO Auto-generated method stub
		return super.authenticationManager();
	}

	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder builder) throws Exception {
		builder.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
	}
	
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
		    .csrf().disable()
		    .authorizeRequests()
		        .antMatchers("/register").permitAll()
		        .antMatchers("/").permitAll()
				.antMatchers("/admin").hasRole("ADMIN")
				.antMatchers("/admin/don-hang").hasRole("ADMIN")
				.antMatchers("/admin/san-pham").hasRole("ADMIN")
				.antMatchers("/admin/danh-muc").hasRole("ADMIN")
				.antMatchers("/admin/nhan-hieu").hasRole("ADMIN")
				.antMatchers("/admin/tai-khoan").hasRole("ADMIN")
				.antMatchers("/admin/lien-he").hasRole("ADMIN")
				.antMatchers("/admin/thong-ke").hasRole("ADMIN")
				.antMatchers("/admin/profile").hasRole("ADMIN")
				.antMatchers("/shipper").hasRole("SHIPPER")
			    .and()
			.formLogin()
			    .loginPage("/login")
			    .usernameParameter("email")
				.passwordParameter("password")
				.successHandler(successHandler)
				.failureUrl("/login?error")
			    .and()
			 .logout()
			    .logoutUrl("/logout")
			    .logoutSuccessUrl("/login?logout")
			    .and()
	         .rememberMe().key("uniqueAndSecret").rememberMeParameter("remember-me")
	            .and()
			.exceptionHandling().accessDeniedPage("/login?accessDenied");
	}
	

}
