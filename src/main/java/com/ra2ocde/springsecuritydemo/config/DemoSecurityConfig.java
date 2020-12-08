package com.ra2ocde.springsecuritydemo.config;

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
public class DemoSecurityConfig extends WebSecurityConfigurerAdapter {

	private static final String URL_LOGIN_PAGE = "/loginPage";
	private static final String URL_TO_PROCESS_USER_AUTH = "/authUser";
	
	@Autowired
	private DataSource mySqlDataSource;
	
	// I need to override this method from superclass for auth ( WebSecurityConfigurerAdapter )
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		// add our user for in memory authentication
		/*
		auth.inMemoryAuthentication()
					.withUser( createUser("jhon",   "test123",   "EMPLOYEE") )
					.withUser( createUser("mary",  "test123",   "EMPLOYEE", "MANAGER") ) 
					.withUser( createUser("susan", "test123",   "EMPLOYEE","ADMIN") );
		*/
		// add our user that are located in database
		auth.jdbcAuthentication()
					.dataSource(mySqlDataSource);
	}
	
	@SuppressWarnings(value = "unused")
	private static UserBuilder createUser(String uname, String pwd, String... roles) {
		 UserBuilder user = User.withDefaultPasswordEncoder();
		 return user.username(uname).password(pwd).roles(roles);
	}

	// Configure security of web paths in application, login, logout, etc..
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		// this method passed  a HttpSecurity object and we configure this for make security our web paths
		
		// setting securiry : authorize any request to our webapp only if authenticated and if formLogin say authenticated 
//		http.authorizeRequests()
//					.anyRequest().authenticated()
//				.and()
//					.formLogin()
//						.loginPage(URL_LOGIN_PAGE)
//						.loginProcessingUrl(URL_TO_PROCESS_USER_AUTH)
//						.permitAll(true)
//				.and()
//					.logout().permitAll(true);
		
		http. authorizeRequests()
				.antMatchers("/register").permitAll()
				.antMatchers("/").hasAnyRole("EMPLOYEE")
				.antMatchers("/leaders/**").hasRole("MANAGER")
				.antMatchers("/systems/**").hasRole("ADMIN")
			.and()
				.formLogin()
				.loginPage(URL_LOGIN_PAGE)
				.loginProcessingUrl(URL_TO_PROCESS_USER_AUTH)
				.permitAll(true)
			.and()
				.logout().permitAll(true)
			.and()
				.exceptionHandling()
					.accessDeniedPage("/access-denied");
	}
}