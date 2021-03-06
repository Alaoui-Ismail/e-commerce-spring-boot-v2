package com.shop.ecommercev2.security;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.shop.ecommercev2.SpringApplicationContext;
import com.shop.ecommercev2.requests.UserLoginRequest;
import com.shop.ecommercev2.services.IUserService;
import com.shop.ecommercev2.shared.dto.UserDto;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationServiceException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.bind.annotation.CrossOrigin;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

public class AuthenticationFilter extends UsernamePasswordAuthenticationFilter {


    @Autowired
    IUserService iUserService;

    private final AuthenticationManager authenticationManager;


    public AuthenticationFilter(AuthenticationManager authenticationManager) {
        this.authenticationManager = authenticationManager;
    }


    /*
     -une fois on declenche la route /login cette methode s'execute ..
     -methode qui sert a recuperer la demande (email,password)
     -on recupere au niveau de l'objet UserLoginRequest les elements ils doivent etre identiques a celles qui sont dans
     la classe userLoginRequest
     - a ce niveau la il se creee une cridential
     */
    @Override
    @CrossOrigin("*")
    public Authentication attemptAuthentication(HttpServletRequest req, HttpServletResponse res)
            throws AuthenticationException {
        try {

            UserLoginRequest userLoginRequest = new ObjectMapper().readValue(req.getInputStream(), UserLoginRequest.class);

            return authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(userLoginRequest.getEmail()
                            , userLoginRequest.getPassword()
                            , new ArrayList<>()));


        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    @CrossOrigin("*")
    protected void successfulAuthentication(HttpServletRequest req,
                                            HttpServletResponse res,
                                            FilterChain chain,
                                            Authentication auth) throws IOException, ServletException {

        String userName = ((User) auth.getPrincipal()).getUsername();

        IUserService userService = (IUserService) SpringApplicationContext.getBean("userServiceImpl");
        UserDto userDto = userService.getUser(userName);

        String token = Jwts.builder()
                .setSubject(userName)
                .claim("id", userDto.getUserId())
                .claim("name", userDto.getFirstname() + " " + userDto.getLastname())
                .setExpiration(new Date(System.currentTimeMillis() + SecurityConstants.EXPIRATION_TIME))
                .signWith(SignatureAlgorithm.HS512, SecurityConstants.TOKEN_SECRET)
                .compact();
            res.addHeader(SecurityConstants.HEADER_STRING, SecurityConstants.TOKEN_PREFIX + token);


//
//        res.addHeader(SecurityConstants.HEADER_STRING, SecurityConstants.TOKEN_PREFIX + token);
          res.addHeader("user_id", userDto.getUserId());
          res.getWriter().write("{\"token\": \"" + token + "\", \"id\": \"" + userDto.getUserId() + "\" }");

    }
}
