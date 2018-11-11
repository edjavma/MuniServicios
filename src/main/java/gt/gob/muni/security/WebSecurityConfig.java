package gt.gob.muni.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter{
	
	@Autowired
	@Qualifier("customUserDetailsService")
	UserDetailsService userDetailsService;

	
	@Autowired
	public void configAuthentication(AuthenticationManagerBuilder auth) throws Exception {
		/*auth.userDetailsService(userDetailsService);
		auth.authenticationProvider(authenticationProvider());*/
		auth.inMemoryAuthentication().withUser("muni").password("muni").roles("ADMIN");
	}
	
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
		/*.antMatchers("/ver/**").access("hasRole('ROLE_LECTURA') or hasRole('ROLE_ESCRITURA')")
		.antMatchers("/descarga/**").access("hasRole('ROLE_LECTURA') or hasRole('ROLE_ESCRITURA')")
		.antMatchers("/filtro/**").access("hasRole('ROLE_LECTURA')")
		.antMatchers("/busqueda/**").access("hasRole('ROLE_ESCRITURA')")
		.antMatchers("/guardar/**").access("hasRole('ROLE_ESCRITURA')")
		.antMatchers("/listar/**").access("hasRole('ROLE_ESCRITURA')")
		.antMatchers("/role/**").access("hasRole('ROLE_ADMIN')")		
		.antMatchers("/usuario/**").access("hasRole('ROLE_ADMIN')")
		.antMatchers("/asignar/**").access("hasRole('ROLE_ADMIN')")*/
		.antMatchers("/password/**").authenticated()
		.antMatchers("/welcome/**").authenticated()
		.antMatchers("/principal.jsp").authenticated()
		.antMatchers("/principal.jsp#!/").authenticated()
		.and()
		  .formLogin().loginPage("/login")
		  .defaultSuccessUrl("/welcome")
		  .failureUrl("/login?error")
		  .usernameParameter("username").passwordParameter("password")
		.and()
		  .logout().logoutSuccessUrl("/login?logout")
		.and()
		  .exceptionHandling().accessDeniedPage("/")
		.and()
		  .csrf().disable();
	}
	
	@Bean
	public DaoAuthenticationProvider authenticationProvider() {
		DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
		authenticationProvider.setUserDetailsService(userDetailsService);
		authenticationProvider.setPasswordEncoder(passwordEncoder());
		return authenticationProvider;
	}
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
}
