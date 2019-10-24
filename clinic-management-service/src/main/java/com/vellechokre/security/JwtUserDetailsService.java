package com.vellechokre.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.vellechokre.bo.LoginUserBo;
import com.vellechokre.entity.LoginUser;
import com.vellechokre.repository.LoginUserRepo;

@Service
public class JwtUserDetailsService implements UserDetailsService {

    @Autowired
    private LoginUserRepo userDao;

    @Autowired
    private PasswordEncoder bcryptEncoder;

    @Override
    public LoginUserBo loadUserByUsername(String username) throws UsernameNotFoundException {

        LoginUser user = userDao.findByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException("User not found with username: " + username);
        }
        return new LoginUserBo(user.getUsername(), user.getPassword(), user.getId(),
                user.getClinic(), user.getBranchs(), user.getLoginAuthorities(),
                user.getActiveTill());
    }

    public LoginUser save(LoginUser user) {

        user.setPassword(bcryptEncoder.encode(user.getPassword()));
        return userDao.save(user);
    }
}