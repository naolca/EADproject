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

@WebServlet("/journals/add-journal")
public class AddJournalServlet extends HttpServlet {
  private JournalRepository journalRepository;

  public void init(final ServletConfig config) {
    try {
      UnitOfWork uof = UnitOfWork.getInstance();
      journalRepository = uof.getJournalRepository();

    } catch (ClassNotFoundException | SQLException e) {
      e.printStackTrace();
    }
  }

  public void doGet(final HttpServletRequest req, final HttpServletResponse res) throws ServletException, IOException {
    final RequestDispatcher rd = req.getRequestDispatcher("/user/add-journal.jsp");
    rd.forward(req, res);
  }

  public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
    // Retrieve data from the form
    HttpSession session = (HttpSession) req.getSession();
    User user = (User) session.getAttribute("user");

    String title = req.getParameter("title");
    String content = req.getParameter("content");

    Journal journal = new Journal(title, content, user.id);

    journalRepository.saveJournal(journal);
    res.sendRedirect("/journals");
  }
}
