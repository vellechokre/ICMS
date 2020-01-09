package com.vellechokre.security;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.vellechokre.bo.LoginUserBo;
import com.vellechokre.entity.LoginUser;
import com.vellechokre.repository.LoginUserRepo;

@RestController
@CrossOrigin
public class JwtAuthenticationController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Autowired
    private JwtUserDetailsService userDetailsService;

    @Autowired
    private LoginUserRepo userRepo;

    @RequestMapping(value = "/authenticate", method = RequestMethod.POST,
                    consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> createAuthenticationToken(@RequestBody JwtRequest authenticationRequest) throws Exception {

        authenticate(authenticationRequest.getUsername(), authenticationRequest.getPassword());
        validate(authenticationRequest);
        final LoginUserBo loginUser =
                userDetailsService.loadUserByUsername(authenticationRequest.getUsername());
        final String token = jwtTokenUtil.generateToken(loginUser);
        return ResponseEntity.ok(new JwtResponse(token, loginUser));
    }

    /**
     * @param authenticationRequest
     * @return
     * @throws Exception
     */
    private boolean validate(JwtRequest authenticationRequest) throws Exception {

        List<Integer> ids = new ArrayList<>();
        authenticationRequest.getBranchs().forEach(i -> ids.add(i.getId()));
        LoginUser user = userRepo.findByUsernameAndClinicIdAndBranchsIdIn(
                authenticationRequest.getUsername(), authenticationRequest.getClinic().getId(),
                ids);
        if (Objects.isNull(user)) {
            throw new Exception("Invalid user.");
        } else {
            return true;
        }
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public ResponseEntity<?> saveUser(@RequestBody LoginUser user) throws Exception {

        return ResponseEntity.ok(userDetailsService.save(user));
    }

    private void authenticate(String username, String password) throws Exception {

        try {
            authenticationManager
                    .authenticate(new UsernamePasswordAuthenticationToken(username, password));
        } catch (DisabledException e) {
            throw new Exception("USER_DISABLED", e);
        } catch (BadCredentialsException e) {
            throw new Exception("INVALID_CREDENTIALS", e);
        }
    }
}