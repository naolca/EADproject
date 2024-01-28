package com.project.servlets.auth;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.project.customexceptions.NotFoundException;
import com.project.domain.User;
import com.project.persistence.repositories.UnitOfWork;
import com.project.persistence.repositories.UserRepository;

@WebServlet("/auth/login")
public class AdminServlet extends HttpServlet {
  private UserRepository userRepository;

  public void init(final ServletConfig config) {
    try {
      UnitOfWork uof = UnitOfWork.getInstance();
      userRepository = uof.getUserRepository();

    } catch (ClassNotFoundException | SQLException e) {
      e.printStackTrace();
    }
  }

  public void doGet(final HttpServletRequest req, final HttpServletResponse res) throws ServletException, IOException {
    try {
      HttpSession session = req.getSession();
      if (session.getAttribute("username") == null) {
        res.sendRedirect("/login");
        return;
      }
      List<User> users = userRepository.get();

      req.setAttribute("userList", users);

      RequestDispatcher rd = req.getRequestDispatcher("/displayUsers.jsp");
      rd.forward(req, res);
    } catch (SQLException e) {
      RequestDispatcher dispatcher = req.getRequestDispatcher("/internal-server-error.jsp");
      dispatcher.forward(req, res);
    }
  }
}
