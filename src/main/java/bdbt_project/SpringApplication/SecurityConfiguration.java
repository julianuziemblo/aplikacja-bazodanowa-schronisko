package bdbt_project.SpringApplication;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        var users = Application.getUsers();
        for(var username: users.keySet()){
            var password = users.get(username);
            auth.inMemoryAuthentication()
                    .withUser(username)
                    .password(password)
                    .roles("USER");
        }
        auth.inMemoryAuthentication()
                .withUser("albertologuapo@gmail.com")
                .password("123")
                .roles("EMPLOYEE")
                .and()
                .withUser("emp")
                .password("emp")
                .roles("EMPLOYEE")
                .and()
                .withUser("admin")
                .password("admin")
                .roles("ADMIN");
    }

    @Bean
    public PasswordEncoder getPasswordEncoder() {
        return NoOpPasswordEncoder.getInstance();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/", "/index").permitAll()
                .antMatchers("/resources/static/**").permitAll()
                .antMatchers("/main").authenticated()
                .antMatchers("/main_admin").access("hasRole('ADMIN')")
                .antMatchers("/employee/main_employee").access("hasRole('EMPLOYEE')")
                .antMatchers("/employee/emp_umowy").access("hasRole('EMPLOYEE')")
                .antMatchers("/main_employee").access("hasRole('EMPLOYEE')")
                .antMatchers("/main_user").access("hasRole('USER')")
                .antMatchers("/user/podpisz").access("hasRole('USER')")
                .antMatchers("/user/umowy").access("hasRole('USER')")
                .and()
                .formLogin()
                .loginPage("/login")
                .defaultSuccessUrl("/main")
                .permitAll()
                .and()
                .logout()
                .logoutUrl("/index")
                .logoutSuccessUrl("/index")
                .permitAll();
    }

}
