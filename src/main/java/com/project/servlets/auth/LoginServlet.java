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
public class LoginServlet extends HttpServlet {
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
    final RequestDispatcher rd = req.getRequestDispatcher("/auth/login.jsp");
    rd.forward(req, res);
  }

  public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
    // Retrieve data from the form
    String email = req.getParameter("email");
    String password = req.getParameter("password");

    try {
      System.out.println(" here");
      User user = userRepository.getUserByEmailAndPassword(email, password);
      System.out.println(user.toString());
      if (user != null) {
        HttpSession session = req.getSession();
        session.setAttribute("email", user.email);
        session.setAttribute("role", user.role);

        RequestDispatcher dispatcher = req.getRequestDispatcher("/users");
        dispatcher.forward(req, res);
      }
    } catch (SQLException e) {
      req.setAttribute("error", "Email or Password is wrong.");
      RequestDispatcher dispatcher = req.getRequestDispatcher("/auth/login.jsp");
      dispatcher.forward(req, res);
    } catch (NotFoundException e) {
      req.setAttribute("error", "User with this email doesn't exist");
      RequestDispatcher dispatcher = req.getRequestDispatcher("/auth/login.jsp");
      dispatcher.forward(req, res);
    }
  }
}
