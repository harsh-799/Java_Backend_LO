package com.spring.security.basics.service;

import com.spring.security.basics.dto.UserLoginRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.configurers.userdetails.DaoAuthenticationConfigurer;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    private AuthenticationManager authenticationManager;

    @Autowired
    public AuthService(AuthenticationManager authenticationManager) {
        this.authenticationManager = authenticationManager;
    }

    // Simple connection concept:
    // AuthenticationManager is in Intf and it has method which is of type AUthentication i.e [    Authentication authenticate(Authentication authentication) throws AuthenticationException;]
    // Now this method is of type Authentication and Authentication is itself is interface so
    // For it we have UsernamePasswordAuthenticationToken class which is impl of Authentication [it's work is to simply contain user login Request]
    // Now we can simply visulise it like Authentication authentication = new UsernamePasswordAuthenticationToken( bla-bla)
    // Now this obj is passed into the parameter of Step 1 basically method of AuthenticatonManager method (authenticate)
    // SO till now something like this happened     Authentication authenticate(UsernamePasswordAuthentication( bla-bla)) throws AuthenticationException;
    // Now we need some classes which have impl of this     Authentication authenticate(Authentication authentication) throws AuthenticationException; method of AuthenticatorManager Intf
    // So we have ProviderManager which actually implements the above method and it doesn't contains credentials verify logic rather than it recieves authentication object, finds suitable AuthenticationProvider, delegates Authentication
    // Since FOr finding suitable AuthenticationProvider means for sure AuthenticationProvider has many impl so AuthenticationProvider is intf
    // AuthenticationProvider (specifically DaoAuthenticationProvider) is impl of it
    // It's DaoAuthenticationProvider that actually Verifies user Cred

    public Authentication loginService(UserLoginRequest loginRequest) {
        Authentication authentication = new UsernamePasswordAuthenticationToken(
                loginRequest.getUsername(),
                loginRequest.getPassword()
        );


        Authentication result = authenticationManager.authenticate(authentication);

        System.out.println("Authenticated: " + result.isAuthenticated());

        return result;
    }

}
