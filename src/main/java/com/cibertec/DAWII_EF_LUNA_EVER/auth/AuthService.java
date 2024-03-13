package com.cibertec.DAWII_EF_LUNA_EVER.auth;

import com.cibertec.DAWII_EF_LUNA_EVER.jwt.JwtService;
import com.cibertec.DAWII_EF_LUNA_EVER.model.User;
import com.cibertec.DAWII_EF_LUNA_EVER.repo.UserRepo;

import java.time.LocalDate;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final UserRepo userRepository;
    private final JwtService jwtService;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;

    public AuthResponse login(LoginRequest request) {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword()));
        UserDetails user = userRepository.findByUsername(request.getUsername()).orElseThrow(() -> new RuntimeException("User not found"));
        String token = jwtService.getToken(user);
        return AuthResponse.builder()
            .token(token)
            .build();
    }

    public AuthResponse register(UserRequest request) {
        // Asegúrate de que los nombres de los campos coincidan con los de tu clase User.
        User user = new User();
        user.setUsername(request.getUsername());
        user.setName(request.getName()); // Ajustado de 'nombre' a 'name'
        user.setLastname(request.getLastname()); // 'apellido' está bien, asumiendo que es 'lastname' en User
        user.setEmail(request.getEmail()); // Ajustado de 'correo' a 'email'
        user.setPassword(passwordEncoder.encode(request.getPassword()));
        // Considera cómo manejar 'isActive', 'createdAt', y 'kind' aquí también.
        user.setIsActive(1); // Asumiendo que nuevo usuario siempre está activo
        user.setCreatedAt(LocalDate.now()); // Fecha actual como fecha de creación
        // El campo 'kind' dependerá de tu lógica específica si es necesario

        userRepository.save(user);

        return AuthResponse.builder()
            .token(jwtService.getToken(user))
            .build();
    }
}
