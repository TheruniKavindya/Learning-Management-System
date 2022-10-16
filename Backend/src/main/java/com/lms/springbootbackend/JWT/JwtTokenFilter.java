package com.lms.springbootbackend.JWT;

import com.lms.springbootbackend.model.Privilege;
import com.lms.springbootbackend.model.Role;
import com.lms.springbootbackend.model.User;
import io.jsonwebtoken.Claims;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class JwtTokenFilter extends OncePerRequestFilter {

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    Logger logger = LoggerFactory.getLogger(JwtTokenFilter.class);

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String header = request.getHeader("Authorization");
        logger.info("Authorization : " + header);

        if(!hasAuthorizationHeader(request)){
            filterChain.doFilter(request, response);
            return;
        }

        String accessToken = getAccessToken(request);

        if(!jwtTokenUtil.validateAccessToken(accessToken)){
            filterChain.doFilter(request, response);
            return;
        }

        setAuthenticationContext(accessToken, request);
        filterChain.doFilter(request, response);
    }

    private void setAuthenticationContext(String accessToken, HttpServletRequest request) {
        UserDetails userDetails  = getUserDetails(accessToken);

        UsernamePasswordAuthenticationToken authentication =  new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());

        authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
        SecurityContextHolder.getContext().setAuthentication(authentication);
    }

    private UserDetails getUserDetails(String accessToken) {
        User userDetails = new User();
        Claims cliams = jwtTokenUtil.parseCliams(accessToken);

        //   cliamsRole = (Role) cliams.get("role").toString();
        System.out.println("claimRole : "  + cliams.get("role"));
        String  cliamsPrivilege = (String) cliams.get("privileges");

        //System.out.println("claimRole : " + cliamsRole.getRole_name());
        System.out.println("claimPrivilegdes : " + cliamsPrivilege);

        cliamsPrivilege = cliamsPrivilege.replace("[", "").replace("]", "").replaceAll("\\s+","");
        String[] privileges = cliamsPrivilege.split(",");
        userDetails.setRole(new Role(cliams.get("role").toString()));

        for(String aPrivilege: privileges){
            userDetails.getRole().addPrivilege(new Privilege(aPrivilege));
        }

        //userDetails.addRole(new Role(cliams.get("role").toString()));

        String subject = (String) cliams.get(Claims.SUBJECT);
        String[] subjectArray = subject.split(",");

        // String[] subjectArray = jwtTokenUtil.getSbuject(accessToken).split((","));

        userDetails.setId(Integer.parseInt(subjectArray[0]));
        userDetails.setEmail(subjectArray[1]);

        System.out.println("Filtered authorities : " + privileges);

        return userDetails;
    }

    private boolean hasAuthorizationHeader(HttpServletRequest request){
        String header = request.getHeader("Authorization");
        logger.info("Authorization : " + header);
        if(ObjectUtils.isEmpty(header) || !header.startsWith("Bearer")){
            return false;
        }
        return true;
    }

    private String getAccessToken(HttpServletRequest request){
        String header = request.getHeader("Authorization");
        String token = header.split(" ")[1].trim();
        logger.info("Access token : " + token);
        return token;
    }

}
