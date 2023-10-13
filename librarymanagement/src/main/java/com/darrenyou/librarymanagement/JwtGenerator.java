package com.darrenyou.librarymanagement;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import java.security.Key;
import java.util.Date;

public class JwtGenerator {

    private static Key secretKey = Keys.secretKeyFor(SignatureAlgorithm.HS256);
    private static long validityInMilliseconds = 3600000;

    public static String generateJwtToken(int userId) {
        Date now = new Date();
        Date validity = new Date(now.getTime() + validityInMilliseconds);

        return Jwts.builder()
                .setSubject(Integer.toString(userId))
                .setIssuedAt(now)
                .setExpiration(validity)
                .signWith(SignatureAlgorithm.HS256, secretKey)
                .compact();
    }
}
