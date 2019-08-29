
package br.com.backSpringBoot.awesome.service;

import br.com.backSpringBoot.awesome.model.User_Token;
import br.com.backSpringBoot.awesome.repository.UserRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;


public class CustomUserDetailService implements UserDetailsService {
     private final UserRepository userRepository;
    private String username;
           
     @Autowired
     public CustomUserDetailService(UserRepository userRepository) {
         this.userRepository = userRepository;
     }
     
    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        User_Token user = Optional.ofNullable(userRepository.findByUsername(username))
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));
    List<GrantedAuthority> authorityListAdmin = AuthorityUtils.createAuthorityList("ROLE_USER", "ROLE_ADMIN");
    List<GrantedAuthority> authorityListUser = AuthorityUtils.createAuthorityList("ROLE_USER", "ROLE_ADMIN");
    return new org.springframework.security.core.userdetails.User
     (user.getUsername(), user.getPassword(), user.isIndAdmin() ? authorityListAdmin : authorityListUser);
    }
}
