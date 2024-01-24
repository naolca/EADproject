package com.project.filters;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class AuthorizationFilter implements Filter {
  public void init(FilterConfig filterConfig) {
  }

  @Override
  public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
      throws IOException, ServletException {
    HttpServletRequest httpRequest = (HttpServletRequest) request;
    HttpSession session = httpRequest.getSession();

    if (isUserAuthenticated(session)) {
      if (hasRequiredRole(session)) {
        chain.doFilter(request, response);
      } else {
        request.getRequestDispatcher("/access-denied.jsp").forward(request, response);
      }
    } else {
      request.getRequestDispatcher("/login.jsp").forward(request, response);
    }
  }

  public void destroy() {
  }

  private boolean isUserAuthenticated(HttpSession session) {
    return session.getAttribute("email") != null;
  }

  private boolean hasRequiredRole(HttpSession session) {
    String role = (String) session.getAttribute("role");

    return "ROLE_ADMIN".equals(role);
  }
}
