package com.scio.cloud.jwt.config;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.scio.cloud.jwt.util.JwtTokenUtils;

/**
 * JwtAuthenticationFilter
 *
 * @author Wang.ch
 * @date 2019-03-27 17:23:37
 */
public class JwtAuthenticationFilter extends UsernamePasswordAuthenticationFilter {

  @Override
  protected void successfulAuthentication(
      HttpServletRequest request,
      HttpServletResponse response,
      FilterChain chain,
      Authentication authResult)
      throws IOException, ServletException {
    SecurityContextHolder.getContext().setAuthentication(authResult);
    User user = (User) authResult.getPrincipal();
    String token = JwtTokenUtils.createToken(user.getUsername(), user.getAuthorities(), false);
    response.setHeader(JwtTokenUtils.TOKEN_HEADER, token);
  }
}
