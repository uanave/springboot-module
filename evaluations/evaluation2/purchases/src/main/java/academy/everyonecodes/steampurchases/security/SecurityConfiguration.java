package academy.everyonecodes.steampurchases.security;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

import java.util.List;

import static java.util.stream.Collectors.toList;

@Configuration
@EnableGlobalMethodSecurity(securedEnabled = true)
@ConfigurationProperties("purchases")
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    private List<GamesUser> gameAdmins;

    void setGameAdmins(List<GamesUser> gameAdmins) {
        this.gameAdmins = gameAdmins;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.cors().and().csrf().disable()
                .authorizeRequests()
                .antMatchers("/games").permitAll()
                .anyRequest().authenticated()
                .and()
                .httpBasic();
    }

    @Bean
    public UserDetailsService userDetailsService(PasswordEncoder encoder) {
        List<UserDetails> users = gameAdmins.stream()
                .map(gameAdmin -> createUserDetails(encoder, gameAdmin))
                .collect(toList());
        return new InMemoryUserDetailsManager(users);
    }

    private UserDetails createUserDetails(PasswordEncoder encoder, GamesUser gamesUser) {
        return User.withUsername(gamesUser.getUsername())
                .password(encoder.encode(gamesUser.getPassword()))
                .authorities(gamesUser.getAuthorities())
                .build();
    }

    @Bean
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}

