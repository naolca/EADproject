package com.project.servlets.user;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.project.domain.User;
import com.project.persistence.repositories.UnitOfWork;
import com.project.persistence.repositories.UserRepository;

public class UserServlet {
    private UserRepository userRepository;

  public void init(final ServletConfig config) {
    try {
      UnitOfWork uof = UnitOfWork.getInstance();
      userRepository = uof.getUserRepository();

    } catch (ClassNotFoundException | SQLException e) {
      e.printStackTrace();
    }
  }

//   protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//     try {
//         List<User> users = userRepository.getAllUsers();
//         // Convert the users list to JSON and write it to the response
//     } catch (SQLException e) {
//         e.printStackTrace();
//     }
// }

// protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//     User user = new User();
//     // Populate the user object with data from the request
//     try {
//         userRepository.saveUser(user);
//         // Write a success message to the response
//     } catch (SQLException e) {
//         e.printStackTrace();
//     }
// }

protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    // get all the data from the request and create a user object
       




    // Populate the user object with data from the request
    try {
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
  
        // Create a new User object
        User updatedUser = new User(firstName, lastName, email, password, "NORMAL_USER");
        if (updatedUser != null) {
          HttpSession session = request.getSession();
          session.setAttribute("email", updatedUser.email);
          session.setAttribute("role", updatedUser.role);
  
          RequestDispatcher dispatcher = request.getRequestDispatcher("/user/home");
          dispatcher.forward(request, response);
        }
       
        // Write a success message to the response

    } catch (Exception e) {
        e.printStackTrace();
    }
}

protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    int userId = Integer.parseInt(request.getParameter("id"));
    try {
        userRepository.deleteUser(userId);
        // Write a success message to the response
        RequestDispatcher dispatcher = request.getRequestDispatcher("/");
    } catch (Exception e) {
        e.printStackTrace();
    }
}


    




}
