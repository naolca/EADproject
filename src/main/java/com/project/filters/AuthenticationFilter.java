package com.project.filters;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class AuthenticationFilter implements Filter {

  @Override
  public void doFilter(ServletRequest request, ServletResponse response, FilterChain next)
      throws IOException, ServletException {
    HttpServletRequest servletRequest = (HttpServletRequest) request;

    if (isUserAuthenticated(servletRequest.getSession())) {
      next.doFilter(request, response);
    } else {
      // Reroute them to the login page
      // request.getRequestDispatcher("/login.jsp").forward(request, response);
    }
  }

  private boolean isUserAuthenticated(HttpSession session) {
    return session.getAttribute("email") != null;
  }
}
