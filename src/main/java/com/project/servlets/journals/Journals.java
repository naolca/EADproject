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

@WebServlet("/edit-journal")
public class Journals extends HttpServlet {
  private static final long serialVersionUID = 1L;

  private JournalRepository journalRepository;

  public void init(final ServletConfig config) {
    try {
      UnitOfWork uof = UnitOfWork.getInstance();
      journalRepository = uof.getJournalRepository();
    } catch (ClassNotFoundException | SQLException e) {
      try {
        throw new ServletException("Initialization failed", e);
      } catch (ServletException e1) {
        // TODO Auto-generated catch block
        e1.printStackTrace();
      }
    }
  }

  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    try {
      int id = Integer.parseInt(request.getParameter("id"));
      Journal journal = journalRepository.getJournalById(id);
      request.setAttribute("journal", journal);
      request.getRequestDispatcher("/edit-journal.jsp").forward(request, response);
    } catch (Exception e) {
      throw new ServletException("Error processing GET request", e);
    }
    // Forward the request to the JSP page
    request.getRequestDispatcher("/user/journals.jsp").forward(request, response);
  }
}
