package com.mypet.MyPet.controllers;

import com.mypet.MyPet.exceptions.ErrorMessages;
import com.mypet.MyPet.exceptions.UserException;
import com.mypet.MyPet.requests.PersonRequest;
import com.mypet.MyPet.security.JwtUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthenticationManager authenticationManager;
    private final UserDetailsService userDetailsService;
    private final JwtUtil jwtUtil;
    @PostMapping("/authenticate")
    public ResponseEntity<String> authenticate(@RequestBody PersonRequest request) {
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword())
            );
        final UserDetails user = userDetailsService.loadUserByUsername(request.getEmail());
        if (user != null) {
            return ResponseEntity.ok(jwtUtil.generateToken(user));
        }
        } catch( Exception ex){
            System.out.println(ex.getMessage());
            throw new UserException(ErrorMessages.THE_PASSWORD_INCORRECT.getErrormessage());
        }

        return ResponseEntity.status(400).body("error occurred");

    }

}
