package com.project.servlets.journals;

import com.project.domain.Journal;
import com.project.domain.User;
import com.project.persistence.repositories.JournalRepository;
import com.project.persistence.repositories.UnitOfWork;
import com.project.services.JournalService;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/journals")
public class JournalsServlet extends HttpServlet {
  private static final long serialVersionUID = 1L;
  private JournalRepository journalRepository;

  public void init(final ServletConfig config) {
    try {
      UnitOfWork uof = UnitOfWork.getInstance();
      journalRepository = uof.getJournalRepository();

    } catch (ClassNotFoundException | SQLException e) {
      e.printStackTrace();
    }
  }

  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

    try {
      // Retrieve data from the service
      HttpSession session = request.getSession();
      User user = (User) session.getAttribute("user");
      String searchKey = request.getParameter("searchKey");

      List<Journal> journals;
      if (searchKey != null) {
        journals = journalRepository.searchJournalsByUserId(user.id, searchKey);
      } else {
        journals = journalRepository.getJournalsByUserId(user.id);
      }

      // Set the data as an attribute in the request
      request.setAttribute("journals", journals);
      // Forward the request to the JSP page
      request.getRequestDispatcher("/user/journals.jsp").forward(request, response);

    } catch (SQLException e) {
      throw new RuntimeException(e);
    }
  }
}
