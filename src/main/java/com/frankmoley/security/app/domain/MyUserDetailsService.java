package com.frankmoley.security.app.domain;

import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;

import com.frankmoley.security.app.domain.Guest;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service("userDetailsService")
public class MyUserDetailsService implements UserDetailsService {
    private static List<Guest> users = new ArrayList();

    public MyUserDetailsService() {
        boolean enabled = true;
        boolean accountNonExpired = true;
        boolean credentialsNonExpired = true;
        boolean accountNonLocked = true;
        users.add(new Guest("1","roy", "adams", "radams1v@xinhuanet.com",
                "2872 Marquette Street","United States","1-(235)314-9823","roy",
                new BCryptPasswordEncoder().encode("password"),AuthorityUtils.createAuthorityList("ROLE_USER"),
                enabled,accountNonExpired,credentialsNonExpired,accountNonLocked));

        users.add(new Guest("2","betty","anderson","banderson14@digg.com",
                "3538 Scofield Drive","United States","1-(291)830-0405","betty",
                new BCryptPasswordEncoder().encode("password"),AuthorityUtils.createAuthorityList("ROLE_USER"),
                enabled,accountNonExpired,credentialsNonExpired,accountNonLocked));

        users.add(new Guest("3","roger", "alvarez", "ralvarezk@blogs.com",
                "3 Green Plaza","Spain","6-(980)036-6105","roger",
                new BCryptPasswordEncoder().encode("password"),AuthorityUtils.createAuthorityList("ROLE_ADMIN"),
                enabled,accountNonExpired,credentialsNonExpired,accountNonLocked));
    }
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<Guest> user = users.stream()
                .filter(u -> u.getUsername().equals(username))
                .findAny();
        if (!user.isPresent()) {
            throw new UsernameNotFoundException("User not found by name: " + username);
        }
        return user.get();
    }

    public static Guest loadUserById(String id) {
        Optional<Guest> user = users.stream()
                .filter(u->u.getId().equals(id))
                .findAny();
        if (!user.isPresent()) {
            return null;
        }
        else return user.get() ;
    }





}
