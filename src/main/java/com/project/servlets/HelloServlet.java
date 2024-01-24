package com.project.servlets;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet("/hello")
public class HelloServlet extends HttpServlet {
  public void init() {
  }

  public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException {
    res.getWriter().println("Hello, world!");
  }

  public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException {
    res.getWriter().println("Hello World!");
  }

  public void destroy() {
  }
}
