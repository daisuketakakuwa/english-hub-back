package jp.english.hub.englishhubback;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import jp.english.hub.englishhubback.domain.user.UserService;

@Configuration
public class EnglishHubBackConfiguration implements WebMvcConfigurer {

    @Bean
    ModelMapper modelMapper() {
        return new ModelMapper();
    }

    @Bean(name = "inMemoryUserDetailsManager")
    public UserDetailsService inMemoryUserDetailsService() {
        // ここでUserDetailsServiceを作るときは、パスワードをエンコードする必要がある。
        UserDetails user = User.builder().username("takakuwa").password(this.passwordEncoder().encode("takakuwa"))
                .roles("USER").build();
        return new InMemoryUserDetailsManager(user);
    }

    @Bean(name = "passwordUsernameUserDetails")
    public UserDetailsService userService() {
        return new UserService();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

}
