package bg.nbu.cscb634.onlinegradebook.config;

import bg.nbu.cscb634.onlinegradebook.services.UserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth, UserDetailsServiceImpl userDetailsService) throws Exception {
//        auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
//
//        http.authorizeRequests().antMatchers(HttpMethod.GET, UsersController.USERS_CONTROLLER_ENDPOINT + "/userInfo").authenticated();
//        http.authorizeRequests().antMatchers(HttpMethod.GET, UsersController.USERS_CONTROLLER_ENDPOINT + "/register").permitAll();
        http.csrf().disable()
                .authorizeRequests().anyRequest().permitAll();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder(10);
    }
}
