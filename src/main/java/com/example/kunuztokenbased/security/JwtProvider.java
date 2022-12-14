package com.example.kunuztokenbased.security;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.security.SignatureException;
import java.sql.Date;

@Component
public class JwtProvider {
    @Value("${jwt.secretkey}")
    private String secretKey;

    @Value("${jwt.token.ttl}")
    private String ttl; //time to live

    //kalit token yasash login phone username email
    public String generateToken(String username) {
        return Jwts.builder()
                .setSubject(username)
                .setIssuedAt(new java.util.Date())
                .setExpiration(new Date(System.currentTimeMillis()+ Long.parseLong(ttl)))
                .signWith(SignatureAlgorithm.HS512, secretKey)
                .compact();
    }

    public String getUsernameFromToken(String token) {
        return Jwts.parser()
                .setSigningKey(secretKey)
                .parseClaimsJws(token)
                .getBody().getSubject();
    }

    //valiadtsiya qilish kerak va muddatini tekshirish kerak
    public boolean validateToken(String token) {
        try {
            Jwts.parser().setSigningKey(secretKey).parseClaimsJws(token);
            return true;
        } catch (Exception exception) {
            System.err.println("Nimadir xatolik bor!");
        }
        return false;
    }

    //
    public boolean isExpired(String token) {
        try {
            Date expiration = (Date) Jwts.parser()
                    .setSigningKey(secretKey)
                    .parseClaimsJws(token)
                    .getBody().getExpiration();
            return expiration.after(new java.util.Date());
        } catch (Exception e) {
            return false;
        }
    }
}
