package no_wire.no_wire.auth.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import no_wire.no_wire.auth.model.AuthenticationRequest;
import no_wire.no_wire.auth.model.AuthenticationResponse;
import no_wire.no_wire.config.JwtService;
import no_wire.no_wire.user.service.UserService;

@Service
@RequiredArgsConstructor
public class AuthenticationService {

    @Autowired
    private UserService userService;

    @Autowired
    private JwtService jwtService;

    @Autowired
    private AuthenticationManager authenticationManager;

    public AuthenticationResponse authenticate(AuthenticationRequest request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getEmail(),
                        request.getPassword()));
        var user = userService.getUserByEmail(request.getEmail());
        var jwtToken = jwtService.generateToken(user);
        return AuthenticationResponse.builder()
                .token(jwtToken)
                .role(user.getRole())
                .email(request.getEmail())
                .id(user.getUserID())
                .build();
    }
}
