//package com.itl.configuration;
//
//import java.io.IOException;
//
//import javax.servlet.ServletException;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import javax.sql.DataSource;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.http.HttpMethod;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.config.http.SessionCreationPolicy;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.crypto.bcrypt.BCrypt;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
//import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
//
//@Configuration
//@EnableWebSecurity
//public class mySecurityConfig extends WebSecurityConfigurerAdapter {
//
//	private final int logRounds = 10;
//
//	@Autowired
//	private JWTFilter JWTFilter;
//
//	@Autowired
//	private DataSource dataSource;
//
//	@Autowired
//	private JwtAuthEntryPoint jwtAuthEntryPoint;
//
//	
//	@Autowired
//	public void configAuthentication(AuthenticationManagerBuilder auth) throws Exception {
//		auth.jdbcAuthentication().passwordEncoder(new BCryptPasswordEncoder()).dataSource(dataSource)
//				.usersByUsernameQuery("select userName, password, 'true' as enable from UserTable where userName =?")
//				.authoritiesByUsernameQuery("select userName, role from UserTable where userName=?");
//
//	}
//
//	
//	@Override
//	protected void configure(HttpSecurity http) throws Exception {
//		http
//		.authorizeRequests()
//		.antMatchers("/UserDetails2")
//		.hasRole("USER")
//		.anyRequest()
//		.fullyAuthenticated()
//		.and()
//		.formLogin().successHandler(new AuthenticationSuccessHandler() {
//			
//					@Override
//					public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
//							Authentication authentication) throws IOException, ServletException {
//						// run custom logics upon successful login
//						UserDetails userDetails = (UserDetails) authentication.getPrincipal();
//						String username = userDetails.getUsername();
//						System.out.println("The user " + username + " has logged in.");
//						response.sendRedirect("login_success_handler");
//					}
//				});
//		
//		
//       http .exceptionHandling().authenticationEntryPoint(jwtAuthEntryPoint).and().sessionManagement()
//		.sessionCreationPolicy(SessionCreationPolicy.STATELESS);
//		
//		http.addFilterBefore(JWTFilter, UsernamePasswordAuthenticationFilter.class);
//		http.cors();
//	}
//
//
//
//	
//	@Bean
//	public PasswordEncoder passwordEncoder() {
//		return new BCryptPasswordEncoder(10);
//
//	}
//
//	public String hash(String password) {
//		return BCrypt.hashpw(password, BCrypt.gensalt(logRounds));
//	}
//
//}
