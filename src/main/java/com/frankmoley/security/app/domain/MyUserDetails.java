package com.frankmoley.security.app.domain;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;

import com.frankmoley.security.app.domain.Guest;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.persistence.Column;
import java.util.*;
import java.util.stream.Collectors;

//@Service("userDetailsService")
public class MyUserDetails implements UserDetails {
    //private static List<Guest> users = new ArrayList();

    private String username;
    private String password;
    private boolean enabled;
    private List<GrantedAuthority> authorities;

    private int id;

    private String firstName;
    private String lastName;
    private String emailAddress;
    private String address;
    private String country;
    private String phoneNumber;

    public MyUserDetails(Guest user) {
        this.username = user.getUsername();
        this.password = user.getPassword();
        this.enabled = user.isEnabled();
        this.authorities = Arrays.stream(user.getRoles().split(","))
                .map(SimpleGrantedAuthority::new)
                .collect(Collectors.toList());
        this.id=user.getId();
        this.firstName=user.getFirstName() ;
        this.lastName=user.getLastName();
        this.emailAddress=user.getEmailAddress();
        this.address=user.getAddress();
        this.country=user.getCountry();
        this.phoneNumber=user.getPhoneNumber();

    }
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return enabled;
    }

    public int getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public String getAddress() {
        return address;
    }

    public String getCountry() {
        return country;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }
}
