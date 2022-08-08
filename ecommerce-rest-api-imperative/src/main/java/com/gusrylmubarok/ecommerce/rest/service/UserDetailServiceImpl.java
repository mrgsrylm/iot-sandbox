package com.gusrylmubarok.ecommerce.rest.service;

import com.gusrylmubarok.ecommerce.rest.entity.UserEntity;
import com.gusrylmubarok.ecommerce.rest.repository.UserRepository;
import org.apache.logging.log4j.util.Strings;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserDetailServiceImpl implements UserDetailsService {

    private UserRepository userRepository;

    public UserDetailServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        if(Strings.isBlank(username)) {
            throw new UsernameNotFoundException("Invalid User");
        }
        final String uname = username.trim();
        Optional<UserEntity> oUserEntity = userRepository.findByUsername(uname);
        UserEntity userEntity = oUserEntity.orElseThrow(
                () -> new UsernameNotFoundException(String.format("Given user(%) not found.", uname)));

        return User.builder()
                .username(userEntity.getUsername())
                .password(userEntity.getPassword())
                .authorities(userEntity.getRole().getAuthority())
                .build();
    }
}
