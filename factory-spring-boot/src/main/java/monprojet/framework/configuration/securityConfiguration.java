package monprojet.framework.configuration;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

//@Configuration
//public class securityConfiguration extends WebSecurityConfigurerAdapter {
//	
//////	@Autowired
//////    UserDetailsServiceImpl userDetailsService;
////	
//////    @Bean
//////    public BCryptPasswordEncoder passwordEncoder() {
//////        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
//////        return bCryptPasswordEncoder;
//////    }
//////     
//    @Autowired
//    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception { 
// 
////        auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
//    }
//	
//	@Override
//    protected void configure(HttpSecurity http) throws Exception {
//
//    }
//}
@Configuration
public class securityConfiguration extends WebSecurityConfigurerAdapter {
	
	@Autowired
	DataSource dataSource;
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
//		.authenticated()
		
		http.authorizeRequests().antMatchers("/")
		.permitAll().anyRequest().anonymous()
		.and().formLogin().loginPage("/auth/login").permitAll().defaultSuccessUrl("/")
		.failureUrl("/auth/login");
		http.csrf().disable();
		http.headers().frameOptions().disable();
	}
	
	@Override
	public void configure(WebSecurity web) throws Exception {
		web.ignoring().antMatchers("/public/**", "/resources/**", "/javax.faces.resource/**");
	}

//	@Autowired
//	protected void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
//		
//		auth.inMemoryAuthentication()
//				.withUser(User.withDefaultPasswordEncoder().username("user").password("user").roles("USER").build());
//		auth.inMemoryAuthentication()
//				.withUser(User.withDefaultPasswordEncoder().username("admin").password("admin").roles("ADMIN").build());
//	}

	@Autowired
	public void configAuthentication(AuthenticationManagerBuilder auth) throws Exception {
		auth.jdbcAuthentication().dataSource(dataSource)
				.usersByUsernameQuery("select username, password, enable from user_tbl where username = ?")
				.authoritiesByUsernameQuery("select username, role from userrole_tbl where username = ?");
	}
}