package com.SmartParking.Proyect.domain;

import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;

public class JwtResponse {

    private User_Smart user_smart;
    private String jwtToken;

    private String bearer = "Bearer";

    private Collection<? extends GrantedAuthority> authorities;

    public JwtResponse(User_Smart user_smart, String jwtToken, Collection<? extends GrantedAuthority> authorities) {
        this.user_smart = user_smart;
        this.jwtToken = jwtToken;
        this.authorities = authorities;
    }

    public User_Smart getUser_smart() {
        return user_smart;
    }

    public void setUser_smart(User_Smart user_smart) {
        this.user_smart = user_smart;
    }

    public String getJwtToken() {
        return jwtToken;
    }

    public void setJwtToken(String jwtToken) {
        this.jwtToken = jwtToken;
    }

    public String getBearer() {
        return bearer;
    }

    public void setBearer(String bearer) {
        this.bearer = bearer;
    }

    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    public void setAuthorities(Collection<? extends GrantedAuthority> authorities) {
        this.authorities = authorities;
    }
}
