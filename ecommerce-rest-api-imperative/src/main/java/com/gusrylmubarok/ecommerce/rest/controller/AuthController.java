package com.gusrylmubarok.ecommerce.rest.controller;

import com.gusrylmubarok.ecommerce.rest.UserApi;
import com.gusrylmubarok.ecommerce.rest.entity.UserEntity;
import com.gusrylmubarok.ecommerce.rest.exceptions.InvalidRefreshTokenException;
import com.gusrylmubarok.ecommerce.rest.model.RefreshToken;
import com.gusrylmubarok.ecommerce.rest.model.SignInReq;
import com.gusrylmubarok.ecommerce.rest.model.SignedInUser;
import com.gusrylmubarok.ecommerce.rest.model.User;
import com.gusrylmubarok.ecommerce.rest.service.UserService;
import javax.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.InsufficientAuthenticationException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.ResponseEntity.accepted;
import static org.springframework.http.ResponseEntity.ok;
import static org.springframework.http.ResponseEntity.status;

@RestController
public class AuthController implements UserApi {

    private final UserService service;
    private final PasswordEncoder passwordEncoder;

    public AuthController(UserService service, PasswordEncoder passwordEncoder) {
        this.service = service;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public ResponseEntity<SignedInUser> getAccessToken(@Valid RefreshToken refreshToken) {
        return ok(service.getAccessToken(refreshToken).orElseThrow(InvalidRefreshTokenException::new));
    }

    @Override
    public ResponseEntity<SignedInUser> signIn(@Valid SignInReq signInReq) {
        UserEntity userEntity = service.findUserByUsername(signInReq.getUsername());
        if (passwordEncoder.matches(signInReq.getPassword(), userEntity.getPassword())) {
            return ok(service.getSignedInUser(userEntity));
        }
        throw new InsufficientAuthenticationException("Unauthorized.");
    }

    @Override
    public ResponseEntity<Void> signOut(@Valid RefreshToken refreshToken) {
        service.removeRefreshToken(refreshToken);
        return accepted().build();
    }

    @Override
    public ResponseEntity<SignedInUser> signUp(@Valid User user) {
        // Have a validation for all required fields.
        return status(HttpStatus.CREATED).body(service.createUser(user).get());
    }
}
