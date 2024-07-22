//package br.com.postechfiap.carrinhocompra_login.infrastructure.security.oauth2.config;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.Customizer;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.security.web.SecurityFilterChain;
//import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
//
//@Configuration
//@EnableWebSecurity
//public class SecurityConfigBKP {
//
//    @Bean
//    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//        http
//            .authorizeHttpRequests((authorize)->{
//                authorize.requestMatchers("/").permitAll();
//                authorize.anyRequest().authenticated();
//            })
//            .oauth2Login(Customizer.withDefaults())
//            .formLogin(Customizer.withDefaults());
//        return http.build();
//    }
//
//    @Bean
//    public SecurityFilterChain configure(HttpSecurity http) throws Exception {
//        http
//                .authorizeHttpRequests((requests) -> requests
//                        .requestMatchers(new AntPathRequestMatcher("/**")).permitAll()
//                        .anyRequest().authenticated())
//                .httpBasic(Customizer.withDefaults())
//                .csrf(AbstractHttpConfigurer::disable);
//        return http.build();
//    }
//
//    @Bean
//    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//        http
//            .csrf(AbstractHttpConfigurer::disable)
//            .authorizeRequests()
//            .requestMatchers("/usuario/criarConta").permitAll()
//            .requestMatchers("/login**").permitAll()
//            .anyRequest()
//            .authenticated()
//            .and()
//            .formLogin(Customizer.withDefaults());
//        return http.build();
//    }
//
//    @Bean
//    public PasswordEncoder passwordEncoder() {
//        return new BCryptPasswordEncoder();
//    }
////
////    @Bean
////    public UserDetailsService userDetailsManager(
////            UsuarioRepository usuarioRepository,
////            UsuarioMapper usuarioMapper
////    ) {
////        return new CustomUserDetailsService(
////                usuarioRepository,
////                usuarioMapper);
////    }
//
//
////    @Bean
////    public JwtDecoder jwtDecoder() {
////        return JwtDecoders.fromIssuerLocation("https://my-auth-server.com");
////    }
//
//}
