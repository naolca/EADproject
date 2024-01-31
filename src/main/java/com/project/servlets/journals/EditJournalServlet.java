package com.project.servlets.journals;

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

import com.project.domain.Journal;
import com.project.domain.User;
import com.project.persistence.repositories.JournalRepository;
import com.project.persistence.repositories.UnitOfWork;

@WebServlet("/journals/edit-journal/*")
public class EditJournalServlet extends HttpServlet {
  private JournalRepository journalRepository;

  public void init(final ServletConfig config) {
    try {
      UnitOfWork uof = UnitOfWork.getInstance();
      journalRepository = uof.getJournalRepository();

    } catch (ClassNotFoundException | SQLException e) {
      e.printStackTrace();
    }
  }

  public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    try {
      String requestURI = request.getRequestURI();
      String[] uriParts = requestURI.split("/");

      int journalId = Integer.parseInt(uriParts[3]);
      HttpSession session = request.getSession();
      User user = (User) session.getAttribute("user");

      Journal journal = journalRepository.getJournalById(journalId);

      if (journal.userId != user.id) {
        request.setAttribute("error", "Sorry, but you cannot see other peoples journals.");
        RequestDispatcher dispatcher = request.getRequestDispatcher("/user/journals.jsp");
        dispatcher.forward(request, response);

        return;
      }

      request.setAttribute("journal", journal);
      RequestDispatcher dispatcher = request.getRequestDispatcher("/user/edit-journal.jsp");
      dispatcher.forward(request, response);
    } catch (NumberFormatException e) {
      e.printStackTrace();
    }
  }

  public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
    // Retrieve data from the form
    String requestURI = req.getRequestURI();
    String[] uriParts = requestURI.split("/");

    int journalId = Integer.parseInt(uriParts[3]);
    HttpSession session = (HttpSession) req.getSession();
    User user = (User) session.getAttribute("user");

    String title = req.getParameter("title");
    String content = req.getParameter("content");

    Journal journal = new Journal(journalId, title, content, user.id);

    journalRepository.updateJournal(journal);
    res.sendRedirect("/journals/" + journal.id);
  }
}
