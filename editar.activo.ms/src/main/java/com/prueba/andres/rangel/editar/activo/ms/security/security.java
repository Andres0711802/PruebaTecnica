package com.prueba.andres.rangel.editar.activo.ms.security;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.cors.CorsUtils;


@Configuration
@EnableWebSecurity
public class security {

	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		BCryptPasswordEncoder b  = new BCryptPasswordEncoder();
		return b;
	}
	
	@Bean
	protected InMemoryUserDetailsManager configureAuthentication() throws Exception{
		
		List<UserDetails> userDetails = new ArrayList<>();
		
		List<GrantedAuthority> admin = new ArrayList<>();
		admin.add(new SimpleGrantedAuthority("EMPLOYEE"));
		
		userDetails.add(new User("admin",
				"$2a$10$2YJlzfKQhINzMd4iHSIAvusTT.EsbabrB2CcSESZs3HNeleaU4rNm",admin));
		
		return new InMemoryUserDetailsManager(userDetails);
	}
	
	@Bean
	protected SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
		
		http.authorizeRequests()
		.requestMatchers(CorsUtils::isPreFlightRequest).permitAll()
		.anyRequest()
		.authenticated()
		.and()
		.httpBasic();
		
		return http.build();
	}

}
