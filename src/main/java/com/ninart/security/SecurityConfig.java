package com.ninart.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.ninart.repository.IUserRepository;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{

	@Autowired
	private IUserRepository repository;
	
	protected void configure(HttpSecurity http) throws Exception{
		http
		  .authorizeRequests()
		    .antMatchers("/resources/**").permitAll()
		    .antMatchers("/home").permitAll()
		    .anyRequest().authenticated()
		    
		  .and()
		  
		  .formLogin()
		    .loginPage("/login")
		    .permitAll()
		  
		  .and()
		  
		  .logout()
		  	.permitAll();
	}
	
	public void configure(AuthenticationManagerBuilder auth) throws Exception{
		auth.userDetailsService(new UserDetailsService(){
			public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException{
				return repository.findOne(username);
			}
		});		
	}
}
