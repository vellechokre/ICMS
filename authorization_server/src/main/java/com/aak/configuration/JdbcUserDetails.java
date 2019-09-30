package com.aak.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.aak.domain.Credential;
import com.aak.repository.CredentialRepository;

/**
 * Project authorization_server
 *
 * @author nishant.bhardwaz
 * @version 1.0
 * @date Aug 27, 2019
 */
public class JdbcUserDetails implements UserDetailsService {

    @Autowired
    private CredentialRepository credentialRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Credential credential = credentialRepository.findByName(username);
        if (credential == null) {
            throw new UsernameNotFoundException("User" + username + "can not be found");
        }
        User user = new User(credential.getName(), credential.getPassword(),
                credential.isEnabled(), true, true, true, credential.getAuthorities());
        return user;
    }
}
