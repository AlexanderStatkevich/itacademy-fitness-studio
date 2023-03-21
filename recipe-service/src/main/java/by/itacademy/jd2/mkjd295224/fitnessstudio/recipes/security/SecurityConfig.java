package by.itacademy.jd2.mkjd295224.fitnessstudio.recipes.security;

import by.itacademy.jd2.mkjd295224.fitnessstudio.recipes.security.jwt.JwtAuthEntryPoint;
import by.itacademy.jd2.mkjd295224.fitnessstudio.recipes.security.jwt.JwtDeniedHandler;
import by.itacademy.jd2.mkjd295224.fitnessstudio.recipes.security.jwt.JwtFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    private final JwtAuthEntryPoint authEntryPoint;

    private final JwtDeniedHandler jwtDeniedHandler;

    public SecurityConfig(JwtAuthEntryPoint authEntryPoint, JwtDeniedHandler jwtDeniedHandler) {

        this.authEntryPoint = authEntryPoint;
        this.jwtDeniedHandler = jwtDeniedHandler;
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http, JwtFilter filter) throws Exception {

        http.cors().and().csrf().disable()
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .exceptionHandling()
                .authenticationEntryPoint(authEntryPoint)
                .accessDeniedHandler(jwtDeniedHandler)
                .and()
                .authorizeHttpRequests((req) -> req
                        .requestMatchers(HttpMethod.GET, "/api/v1/product", "/api/v1/recipe").permitAll()
                        .anyRequest().authenticated());

        http.addFilterBefore(filter, UsernamePasswordAuthenticationFilter.class);
        return http.build();
    }


    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
