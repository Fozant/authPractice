package com.fauzan.authPractice.model;

import java.util.Collection;
import java.util.List;

import javax.management.relation.Role;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "user")
public class User implements UserDetails {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String firstname;

    private String lastname;

    private String email;
    
    private String password;

    @Enumerated(EnumType.STRING)
    private Role  role;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        // TODO Auto-generated method stub
        return List.of(new SimpleGrantedAuthority(((Entity) role).name()));
    }

    @Override
    public String getUsername() {
        // TODO Auto-generated method stub
        return email;
    }

    @Override
    public boolean isAccountNonExpired() {
        // TODOtrue;
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        // TODOtrue;
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        // TODOtrue;
        return true;
    }

    @Override
    public boolean isEnabled() {
        // TODOtrue;
        return true;
    }

    @Override
    public String getPassword() {
       
        return password;
    }
    


}
