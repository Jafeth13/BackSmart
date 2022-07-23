package com.SmartParking.Proyect.service;

import com.SmartParking.Proyect.domain.JwtRequest;
import com.SmartParking.Proyect.domain.JwtResponse;
import com.SmartParking.Proyect.domain.User_Smart;
import com.SmartParking.Proyect.repository.UserRepository;
import com.SmartParking.Proyect.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service
public class JwtService implements UserDetailsService {

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private UserRepository userRepository;

   @Autowired
    private AuthenticationManager authenticationManager;

    public JwtResponse createJwtToken(JwtRequest jwtRequest) throws Exception {
        String userEmail = jwtRequest.getEmail();
        String userPassword = jwtRequest.getPassword();
        authenticate(userEmail, userPassword);

        UserDetails userDetails = loadUserByUsername(userEmail);
        User_Smart user = userRepository.findByEmail(userEmail);
        String newGeneratedToken = jwtUtil.generateToken(user);

        return new JwtResponse(user, newGeneratedToken, userDetails.getAuthorities());
    }

    @Override
    public UserDetails loadUserByUsername(String userEmail) throws UsernameNotFoundException {
        User_Smart user = userRepository.findByEmail(userEmail);

        if (user != null) {
            return new org.springframework.security.core.userdetails.User(
                    user.getEmail(),
                    user.getPassword(),
                    getAuthority(user)
            );
        } else {
            throw new UsernameNotFoundException("User not found with email: " + userEmail);
        }
    }

    private Collection<? extends GrantedAuthority> getAuthority(User_Smart user) {
        List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();

        authorities.add(new SimpleGrantedAuthority("ROLE_" + user.getRole().getName()));

        return authorities;
    }

    private void authenticate(String userName, String userPassword) throws Exception {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(userName, userPassword));
        } catch (DisabledException e) {
            throw new Exception("USER_DISABLED", e);
        } catch (BadCredentialsException e) {
            throw new Exception("INVALID_CREDENTIALS", e);
        }
    }
}
