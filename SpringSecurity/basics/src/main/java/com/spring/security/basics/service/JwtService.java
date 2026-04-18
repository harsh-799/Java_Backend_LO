package com.spring.security.basics.service;

import com.spring.security.basics.dto.UserLoginRequest;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.security.Key;
import java.util.Date;
import java.util.List;

@Service
public class JwtService {

    private final String SECRET = "7d9f2a8c6b4e1f3d9a7c5e2b8f1d6a3c9e7f2b4c6d8a1f3e5b7c9d2a4f6e8b1";

    private final Key key = Keys.hmacShaKeyFor(SECRET.getBytes());

    public String generateToken(Authentication authenticatedUser) {

        String username = authenticatedUser.getName();

        List<String> roles = authenticatedUser.getAuthorities()
                .stream()
                .map(auth -> auth.getAuthority())
                .toList();

        return Jwts.builder()
                .setSubject(authenticatedUser.getName())
                .claim("roles",roles)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 2))
                .signWith(key, SignatureAlgorithm.HS256)
                .compact();
    }

    public String extractUsername(String token) {
        return Jwts.parserBuilder()
                .setSigningKey(key)
                .build()
                .parseClaimsJws(token)
                .getBody()
                .getSubject();
    }

    public List<String> extractRoles(String token) {
        return Jwts.parserBuilder()
                .setSigningKey(key)
                .build()
                .parseClaimsJws(token)
                .getBody()
                .get("roles", List.class);
    }

    public Date expiredTime(String token) {
        return Jwts.parserBuilder()
                .setSigningKey(key)
                .build()
                .parseClaimsJws(token)
                .getBody()
                .getExpiration();
    }

    public boolean isExpired(Date expiredTime) {
        return expiredTime.before(new Date());
    }

    public boolean isValidToken(String token, UserDetails userDetails) {
        return userDetails.getUsername().equals(extractUsername(token)) && !isExpired(expiredTime(token));
    }
}
