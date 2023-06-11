package com.app.develite.Config;

import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Service;

import com.app.develite.user.UserGetDto;
import com.app.develite.user.UserService;

@Service

public class JwtService {
    @Autowired
    private UserService userService;

    private final static String SECRET_KEY="713377YzcJhPiygTeYv2weZhFXDWQff9oA66546A576E5A723475377821412543";




    private Key getSignInKey(){
            byte [] KeyByte = Decoders.BASE64.decode(SECRET_KEY);
        return Keys.hmacShaKeyFor(KeyByte);
    }

    private Claims ExctractAllClaims(String Token){
        return Jwts.parserBuilder().setSigningKey(getSignInKey()).build().parseClaimsJws(Token).getBody();
    }

    public <T> T extractClaim(String token,Function<Claims ,T> claimsResolver){
        final Claims claims = ExctractAllClaims(token);

        return claimsResolver.apply(claims);
    }

    public String extractUsername(String token){
        return extractClaim(token, Claims::getSubject);
    }


    public String GenerateToken(
        Map <String, Object> extraClaims,
        UserDetails userdetails){
            UserGetDto xxx = userService.getUserByUsername(userdetails.getUsername());
            extraClaims.put("role", xxx.getRole().toString());
            return Jwts.builder().setClaims(extraClaims).setSubject(userdetails.getUsername())
            .setIssuedAt(new Date(System.currentTimeMillis())).setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 24))
            .signWith(getSignInKey(),SignatureAlgorithm.HS256).compact();
        }


        public String GenerateToken(UserDetails userDetails){
            return GenerateToken(new HashMap<>(),userDetails);
        }

        public boolean isTokenValid(String token,UserDetails userDetails){
            final String username = extractUsername(token);
            return(username.equals(userDetails.getUsername()) && !isTokenExpired(token));
        }

    private Date extractExpiration(String token) {
        return extractClaim(token, Claims::getExpiration);
    }
    private boolean isTokenExpired(String token) {
        return extractExpiration(token).before(new Date());
    }



}
