package dometa.backend.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .csrf(csrf -> csrf.disable())
            .authorizeHttpRequests(auth -> auth
                .requestMatchers("/api/pb/**").permitAll()    // 공개 API
                .requestMatchers("/api/pv/**").authenticated() // 보호 API
                .anyRequest().permitAll() // 나머지도 허용
            )
            .formLogin().disable()
            .httpBasic().disable();
            //     .requestMatchers("/api/hello").permitAll() // ✅ 인증 없이 허용
            //     .anyRequest().authenticated()              // 그 외는 인증 필요
            // )
            // .formLogin(); // 기본 로그인 페이지 사용

        return http.build();
    }
}
