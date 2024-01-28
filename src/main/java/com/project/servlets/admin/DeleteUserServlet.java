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
import com.project.customexceptions.NotFoundException;
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

      if (uriParts.length >= 4) {
        int userId = Integer.parseInt(uriParts[3]);

        userRepository.deleteUser(userId);

        response.sendRedirect("/admin");
      } else {
        throw new NotFoundException("User was not found");
      }
    } catch (SQLException e) {
      request.setAttribute("error", "Some error occured. Try again.");
      RequestDispatcher dispatcher = request.getRequestDispatcher("/admin/add-admin.jsp");
      dispatcher.forward(request, response);

    } catch (NumberFormatException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();

    } catch (NotFoundException e) {
      request.setAttribute("error", "User not found.");
      RequestDispatcher dispatcher = request.getRequestDispatcher("/admin/add-admin.jsp");
      dispatcher.forward(request, response);
      e.printStackTrace();
    }
  }
}
