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

import com.project.customexceptions.EmailExistsException;
import com.project.domain.User;
import com.project.persistence.repositories.UnitOfWork;
import com.project.persistence.repositories.UserRepository;

@WebServlet("/auth/register")
public class RegisterServlet extends HttpServlet {
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
    try {
      // Retrieve data from the form
      String firstName = req.getParameter("firstName");
      String lastName = req.getParameter("lastName");
      String email = req.getParameter("email");
      String password = req.getParameter("password");

      // Create a new User object
      User newUser = new User(firstName, lastName, email, password, "NORMAL_USER");

      // Add the new user to the repository
      final User savedUser = userRepository.saveUser(newUser);
      if (savedUser != null) {
        HttpSession session = req.getSession();
        session.setAttribute("email", savedUser.email);
        session.setAttribute("role", savedUser.role);

        RequestDispatcher dispatcher = req.getRequestDispatcher("/users");
        dispatcher.forward(req, res);
      }
    } catch (SQLException e) {
      req.setAttribute("error", "Some error occured. Try again.");
      RequestDispatcher dispatcher = req.getRequestDispatcher("/auth/register.jsp");
      dispatcher.forward(req, res);
    } catch (EmailExistsException e) {
      req.setAttribute("error", "Email is taken by another user. Pick another email.");
      RequestDispatcher dispatcher = req.getRequestDispatcher("/auth/register.jsp");
      dispatcher.forward(req, res);
    }
  }

  public UserRepository getUserRepository() {
    return userRepository;
  }

}
