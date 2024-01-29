package com.project.servlets.admin;

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

@WebServlet("/admin/delete-user/*")
public class DeleteUserServlet extends HttpServlet {
  private UserRepository userRepository;

  public void init(final ServletConfig config) {
    try {
      UnitOfWork uof = UnitOfWork.getInstance();
      userRepository = uof.getUserRepository();

    } catch (ClassNotFoundException | SQLException e) {
      e.printStackTrace();
    }
  }

  public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    try {
      String requestURI = request.getRequestURI();
      String[] uriParts = requestURI.split("/");

      int userId = Integer.parseInt(uriParts[3]);
      HttpSession session = request.getSession();
      User user = (User) session.getAttribute("user");

      if (userId == user.id) {
        request.setAttribute("error", "Sorry, but you cannot delete your own admin account.");
        RequestDispatcher dispatcher = request.getRequestDispatcher("/admin/admin-list.jsp");
        dispatcher.forward(request, response);

        return;
      }

      User deletedUser = userRepository.getUserById(userId);
      if (deletedUser == null) {
        throw new NotFoundException("User was not found");
      }

      userRepository.deleteUser(userId);
      if (deletedUser.role.equals("ADMIN_USER")) {
        response.sendRedirect("/admin/admins");
      } else {
        response.sendRedirect("/admin/users");
      }
    } catch (SQLException e) {
      request.setAttribute("error", "Some error occured. Try again.");
      RequestDispatcher dispatcher = request.getRequestDispatcher("/admin/home.jsp");
      dispatcher.forward(request, response);

    } catch (NumberFormatException e) {
      e.printStackTrace();

    } catch (NotFoundException e) {
      request.setAttribute("error", "User not found.");
      RequestDispatcher dispatcher = request.getRequestDispatcher("/admin/home.jsp");
      dispatcher.forward(request, response);
      e.printStackTrace();
    }
  }
}
