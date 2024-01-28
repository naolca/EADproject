package com.project.servlets.admin;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/admin")
public class AdminServlet extends HttpServlet {

  public void init(final ServletConfig config) {
  }

  public void doGet(final HttpServletRequest req, final HttpServletResponse res) throws ServletException, IOException {
    req.setAttribute("sidebarData", "home");
    final RequestDispatcher rd = req.getRequestDispatcher("/admin/home.jsp");
    rd.forward(req, res);
  }

}
