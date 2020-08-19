package com.frankmoley.security.app.domain;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.util.Collection;
import java.util.List;

/**
 * @author Frank P. Moley III.
 */
public class Guest extends User {
    public Guest(String username, String password, boolean enabled, boolean accountNonExpired,
                       boolean credentialsNonExpired, boolean accountNonLocked,
                       Collection<? extends GrantedAuthority> authorities) {
        super(username, password, enabled, accountNonExpired, credentialsNonExpired, accountNonLocked, authorities);
        usercount++ ;
    }
    private static int usercount = 0;
    private String id;
    private String firstName;
    private String lastName;
    private String emailAddress;
    private String address;
    private String country;
    private String phoneNumber;

    public static int getUsercount() { return usercount; }
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Guest(String id, String firstName, String lastName, String emailAddress, String address,
                 String country, String phoneNumber, String username, String password, List<GrantedAuthority> authorities,
                 boolean enabled, boolean accountNonExpired, boolean credentialsNonExpired, boolean accountNonLocked) {


        super(username, password, enabled, accountNonExpired, credentialsNonExpired,
                accountNonLocked, authorities) ;
        this.id=id;
        this.firstName=firstName;
        this.lastName=lastName;
        this.emailAddress=emailAddress;
        this.address=address;
        this.country=country;
        this.phoneNumber=phoneNumber;
        usercount++ ;
    }

}
