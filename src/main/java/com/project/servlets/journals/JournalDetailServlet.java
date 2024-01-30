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
import com.project.persistence.repositories.UnitOfWork;
import com.project.persistence.repositories.JournalRepository;

@WebServlet("/journals/*")
public class JournalDetailServlet extends HttpServlet {
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

      int journalId = Integer.parseInt(uriParts[2]);
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
      RequestDispatcher dispatcher = request.getRequestDispatcher("/user/journal-detail.jsp");
      dispatcher.forward(request, response);
    } catch (NumberFormatException e) {
      e.printStackTrace();
    }
  }

  public void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    try {
      System.out.println("here we go");
      String requestURI = request.getRequestURI();
      String[] uriParts = requestURI.split("/");

      int journalId = Integer.parseInt(uriParts[2]);
      HttpSession session = request.getSession();
      User user = (User) session.getAttribute("user");
      System.out.println(user.firstName);

      Journal journal = journalRepository.getJournalById(journalId);

      if (journal == null) {
        request.setAttribute("error", "Sorry, couldn't get the journal you requested.");
        RequestDispatcher dispatcher = request.getRequestDispatcher("/user/journals.jsp");
        dispatcher.forward(request, response);

        return;
      }

      if (journal.userId != user.id) {
        request.setAttribute("error", "Sorry, couldn't delete another person's journal.");
        RequestDispatcher dispatcher = request.getRequestDispatcher("/user/journals.jsp");
        dispatcher.forward(request, response);

        return;
      }

      System.out.println("Deleting");
      journalRepository.deleteJournal(journalId);
      RequestDispatcher dispatcher = request.getRequestDispatcher("/user/journals.jsp");
      dispatcher.forward(request, response);
    } catch (NumberFormatException e) {
      e.printStackTrace();
    }
  }
}
