package com.project.servlets.admin;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.project.domain.User;
import com.project.persistence.repositories.UnitOfWork;
import com.project.persistence.repositories.UserRepository;

@WebServlet("/admin/admins")
public class AdminsListServlet extends HttpServlet {
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
      // if (session.getAttribute("username") == null) {
      // res.sendRedirect("/login");
      // return;
      // }
      List<User> users;
      String searchKey = req.getParameter("searchKey");

      if (searchKey != null) {
        users = userRepository.searchUsers(searchKey);
      } else {
        users = userRepository.getAllUsers();
      }

      req.setAttribute("userList", this.filterUsersByRole(users, "ADMIN_USER"));
      req.setAttribute("sidebarData", "admins");

      RequestDispatcher rd = req.getRequestDispatcher("/admin/admin-list.jsp");
      rd.forward(req, res);
    } catch (SQLException e) {
      RequestDispatcher dispatcher = req.getRequestDispatcher("/internal-server-error.jsp");
      dispatcher.forward(req, res);
    }
  }

  private List<User> filterUsersByRole(List<User> users, String role) {
    List<User> filteredUsers = new ArrayList<>();
    for (User user : users) {
      if (user.role.equals(role)) {
        filteredUsers.add(user);
      }
    }
    return filteredUsers;
  }
}
