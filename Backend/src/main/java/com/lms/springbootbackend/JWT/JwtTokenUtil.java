package com.lms.springbootbackend.JWT;

import com.lms.springbootbackend.model.Privilege;
import com.lms.springbootbackend.model.Role;
import com.lms.springbootbackend.model.User;
import io.jsonwebtoken.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.Date;

@Component
public class JwtTokenUtil {

    private static final long  EXPIRE_DURATION = 24 * 60 * 60 * 1000; // 24 h
    Logger logger = LoggerFactory.getLogger(JwtTokenUtil.class);

    @Value("${app.jwt.secret}")
    private String secretKey;

    public String generateAccessToken(User user){
        // getting user role
        Role role = user.getRole();
        // getting user's privilege names
        int n = user.getRole().getPrivileges().size();
        String privilegeNames[] = new String[n];
        int i = 0;
        for (Privilege x : user.getRole().getPrivileges())
            privilegeNames[i++] = x.getPrivilege_name();
        //System.out.println(Arrays.toString(arr));

        // binding data
        return Jwts.builder()
                .setSubject(user.getId() + "," + user.getEmail())
                .claim("role", role.getRole_name())
                .claim("privileges", Arrays.toString(privilegeNames))
                .setIssuer("supunVX")
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRE_DURATION))
                .signWith(SignatureAlgorithm.HS512, secretKey)
                .compact();
    }

    public boolean validateAccessToken(String token){
        try{
            Jwts.parser().setSigningKey(secretKey).parseClaimsJws(token);
            return true;
        }
        catch (ExpiredJwtException e){
            logger.error("JWT expired");
        }
        catch (IllegalArgumentException e){
            logger.error("Token is null, empty or has only whitespace");
        }
        catch (MalformedJwtException e){
            //e.printStackTrace();
            logger.error("JWT is invalid");
        }
        catch (UnsupportedJwtException e){
            logger.error("JWT is not supported");
        }
        catch (SignatureException e){
            logger.error("Signature validation failed");
        }
        return false;
    }

    public String getSbuject(String token){
        return parseCliams(token).getSubject();
    }

    public Claims parseCliams(String token){
        return Jwts.parser()
                .setSigningKey(secretKey)
                .parseClaimsJws(token)
                .getBody();
    }
}
