package com.cibertec.DAWII_EF_LUNA_EVER.model;

import java.time.LocalDate;
import java.util.Collection;
import java.util.Collections;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Builder
@Table(name = "user")
public class User implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String username;
    private String name;
    private String lastname;
    private String email;
    private String password;

    @Column(columnDefinition = "TINYINT(1)")
    private int isActive;
    private LocalDate createdAt;
    private int kind;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        // Si todos los usuarios tendrán las mismas autoridades, puedes asignar una autoridad genérica o basada en el campo `kind`.
        // A continuación, un ejemplo con una autoridad genérica. Ajusta según la lógica de tu aplicación.
        return Collections.singletonList(new SimpleGrantedAuthority("USER"));
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
        return true; // Asume que isActive es un campo que determina si el usuario está activo o no.
    }
}
