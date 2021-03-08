package au.com.whitellama.budgetmodelling.security;

import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication()
		    .withUser("budgetuser")
		    .password("#1tsaS3cr3t")
		    .roles("USER")
		    .and()
		    .withUser("budgetadmin")
		    .password("#Sup3rl33t")
		    .roles("ADMIN");
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable()
		    .authorizeRequests()
		    .antMatchers(HttpMethod.POST, "/api/v1/budget/income").hasAnyRole("USER", "ADMIN")
		    .antMatchers(HttpMethod.POST, "/api/v1/budget/expense").hasAnyRole("USER", "ADMIN")
		    .antMatchers(HttpMethod.GET,  "/api/v1/budget/model/*").hasAnyRole("USER", "ADMIN")
		    .antMatchers(HttpMethod.GET,  "/api/v1/budget/model").hasAnyRole("USER", "ADMIN")
		    .antMatchers(HttpMethod.GET,  "/api/v1/budget").hasAnyRole("USER", "ADMIN")
		    .anyRequest().authenticated()
		    .and().httpBasic();
		http.cors(); // allow local angular client
	}

	@Bean
	public PasswordEncoder getPasswordEncoder() {
		// TODO use a proper password encoder here
		return NoOpPasswordEncoder.getInstance();
	}
	
	@Bean
	public CorsFilter getCorsFilter() {
		return new CorsFilter();
	}
}

