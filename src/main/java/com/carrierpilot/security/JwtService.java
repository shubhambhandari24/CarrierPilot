package com.carrierpilot.security;

import java.security.Key;
import java.util.Date;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;

@Service
public class JwtService {
	@Value("${jwt.secret}")
	private String secretKey;
	@Value("${jwt.expiration}")
	private long expiration;
	public String generateToken(String email) {
		return Jwts.builder().setSubject(email).setIssuedAt(new Date()).setExpiration(new Date(System.currentTimeMillis()+expiration)).signWith(signatureKey(), SignatureAlgorithm.HS256).compact();
	}
	private Key signatureKey() {
		return Keys.hmacShaKeyFor(secretKey.getBytes());
	}
	public String extractEmailFromToken(String token) {
		return Jwts.parserBuilder().setSigningKey(signatureKey()).build().parseClaimsJws(token).getBody().getSubject();
	}
	public boolean isTokenExipred(String token) {
		return Jwts.parserBuilder().setSigningKey(signatureKey()).build().parseClaimsJws(token).getBody().getExpiration().before(new Date());
	}
	public boolean isTokenValid(String token, String email) {
		String extractedEmail = extractEmailFromToken(token);
		return (extractedEmail.equals(email)&& !(isTokenExipred(token)));
	}
	

}
