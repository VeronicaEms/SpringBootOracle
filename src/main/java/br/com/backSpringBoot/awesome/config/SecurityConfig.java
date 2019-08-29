package br.com.backSpringBoot.awesome.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.cors.CorsConfiguration;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    
//     esse cara pega do banco o usuário
    @Autowired
    private AppUserDetails userDetailsService;
    
//     esse cara gera o token
    @Autowired
    private JWTools JWTools;
    
//     essa é a lista dos endpoints que eu quero deixar público
    private static final String[] WHITE_LIST = {
            "/login"
    };
     
    
    @Override
    protected void configure(HttpSecurity http) throws Exception {
//aqui eu configuro o cors
        http.cors().configurationSource(
                request -> new CorsConfiguration().applyPermitDefaultValues()
        ).and().csrf().disable();
//aqui eu adiciono os filters jwt de autenticação e autorização 
        addJWTFilters(http);

//aqui eu to falando que o que for da WHITE_LIST eu deixo passar e o restante é só se tiver autenticado no sistema
        http.authorizeRequests()
                .antMatchers(WHITE_LIST).permitAll()
                .anyRequest().authenticated();

    }
    
//    aqui eu to falando que o que for da WHITE_LIST eu deixo passar e o restante é só se tiver autenticado no sistema
    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers(WHITE_LIST);
    }

    private void addJWTFilters(HttpSecurity http) throws Exception {
        http.addFilter(new JWTAuthenticationFilter(JWTools, authenticationManager()));
        http.addFilter(new JWTAuthorizationFilter(authenticationManager(), JWTools, userDetailsService));
    }

    
//     aqui eu to falando que a minha autenticação vai ser pelo serviço que pega do banco o usuário
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
    }

// esse cara é o encoder da senha
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
    
@Override
    public void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .withUser("***").password("***").roles("***")
                .and()
                .withUser("***").password("***").roles("***", "***");
    }
    
    
@Override
protected void configure(HttpSecurity http) throws Exception {
    http
            .authorizeRequests()
            .anyRequest()
            .authenticated()
            .and()
            .httpBasic();
}
   
