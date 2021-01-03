//package com.in28minutes.rest.webservices.restfulwebservices;
//
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
//
//@Configuration
//@EnableWebSecurity
//public class SecurityConfiguration extends WebSecurityConfigurerAdapter implements WebMvcConfigurer {
//
//	// Session doesn't need to be created.
//	@Override
//	protected void configure(HttpSecurity http) throws Exception {
//		http.csrf().disable();
////         .authorizeRequests()
////             .anyRequest().permitAll();
//	}
//
//}
