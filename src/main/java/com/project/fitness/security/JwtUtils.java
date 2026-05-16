package com.project.fitness.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.UnsupportedJwtException;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import io.jsonwebtoken.security.SignatureException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.security.Key;
import java.util.Date;
import java.util.List;

@Component
public class JwtUtils {

    // Secret Key (Base64 Encoded)
    private String jwtSecret =
            "VGhpc0lzQVNlY3JldEtleUZvckpXVFRva2VuR2VuZXJhdGlvbjEyMzQ1Njc4OTA=";

    // Token Expiration Time (2 Days)
    private int jwtExpirationMs = 172800000;


    // Extract JWT From Header

    public String getJwtFromHeader(HttpServletRequest request) {

        String bearerToken = request.getHeader("Authorization");

        if (bearerToken != null && bearerToken.startsWith("Bearer ")) {

            return bearerToken.substring(7);
        }

        return null;
    }


    // Generate JWT Token

    public String generateToken(String userId, String role) {


        return Jwts.builder()


                .setSubject(userId)

                // Store Roles
                .claim(
                        "roles",
                        List.of(new SimpleGrantedAuthority(role))

                )

                // Token Creation Time
                .setIssuedAt(new Date())

                // Expiry Time
                .setExpiration(
                        new Date(
                                new Date().getTime() + jwtExpirationMs
                        )
                )

                // Sign Token
                .signWith(key())

                // Convert to String
                .compact();
    }


    // Generate Secret Key

    private Key key() {

        return Keys.hmacShaKeyFor(
                Decoders.BASE64.decode(jwtSecret)
        );
    }


    // Get Username From JWT

    public String getUsernameFromToken(String jwt) {

        return Jwts.parser()

                .verifyWith((SecretKey) key())
                .build()

                .parseSignedClaims(jwt)

                .getPayload()

                .getSubject();
    }


    // Get All Claims

    public Claims getAllClaims(String jwt) {

        return Jwts.parser()

                .verifyWith((SecretKey) key())

                .build()

                .parseSignedClaims(jwt)

                .getPayload();
    }

    // Validate JWT Token
    public boolean validateJwtToken(String authToken) {

        try {

            Jwts.parser()

                    .verifyWith((SecretKey) key())

                    .build()

                    .parseSignedClaims(authToken);

            return true;

        } catch (SignatureException e) {

            System.out.println("Invalid JWT Signature");

        } catch (MalformedJwtException e) {

            System.out.println("Invalid JWT Token");

        } catch (ExpiredJwtException e) {

            System.out.println("JWT Token is Expired");

        } catch (UnsupportedJwtException e) {

            System.out.println("JWT Token is Unsupported");

        } catch (IllegalArgumentException e) {

            System.out.println("JWT Claims String is Empty");
        }

        return false;
    }
}