package es.iesmm.GlobalChatAPI.auth;

import es.iesmm.GlobalChatAPI.services.UsuarioService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.oauth2.server.resource.OAuth2ResourceServerConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.jwt.JwtDecoder;
import org.springframework.security.oauth2.jwt.NimbusJwtDecoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.access.intercept.AuthorizationFilter;

import java.security.Security;

@Configuration
public class SecurityConfig {

    @Bean
    PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests((authHttp) ->
                authHttp.anyRequest().authenticated()
        );
        http.oauth2ResourceServer(resourceServer -> resourceServer.jwt(Customizer.withDefaults()));

        return http.build();

    }


    @Bean
    JwtDecoder jwtDecoder(){
        String jwkSetUri= "https://www.googleapis.com/service_accounts/v1/jwk/securetoken@system.gserviceaccount.com";
        return NimbusJwtDecoder.withJwkSetUri(jwkSetUri).build();
    }


    }
//        http.authorizeHttpRequests((authHttp) -> authHttp
//                .requestMatchers("/authorized").permitAll()
//                .requestMatchers(HttpMethod.GET, "/hello").hasAnyAuthority("SOCOPE_read","SCOPE_write")
//                .anyRequest().authenticated()
//                ).csrf(csrf -> csrf.disable())
//                .sessionManagement(session-> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
//                .oauth2Login(login -> login.loginPage("/oauth2/authorization/globalChatAPI"))
//                .oauth2Client(Customizer.withDefaults())
//                .oauth2ResourceServer(resourceServer -> resourceServer.jwt(Customizer.withDefaults()));
//        return http.build();
    //http.addFilterAfter(new AuthFilter(), AuthFilter.class);


