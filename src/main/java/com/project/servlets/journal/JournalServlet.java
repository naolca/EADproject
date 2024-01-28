package com.project.servlets.journal;

import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.project.domain.Journal;
import com.project.persistence.repositories.UnitOfWork;
import com.project.persistence.repositories.JournalRepository;
import com.project.domain.User;
import javax.servlet.http.HttpSession;

@WebServlet("/journal")
public class JournalServlet extends HttpServlet {

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

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            int id = Integer.parseInt(req.getParameter("id"));
            Journal journal = journalRepository.getJournalById(id);
            req.setAttribute("journal", journal);
            req.getRequestDispatcher("/journal.jsp").forward(req, resp);
        } catch (Exception e) {
            throw new ServletException("Error processing GET request", e);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            System.out.println("POST called");
            System.out.println("title: " + req.getParameter("title"));
            String title = req.getParameter("title");
            String content = req.getParameter("content");

            System.out.println("title: " + title);

            HttpSession session = req.getSession();
            User user = (User) session.getAttribute("user");
            int userId = user.id;
            Journal journal = new Journal(title, content, userId);
            journalRepository.saveJournal(journal);
            resp.sendRedirect("/journal?id=" + journal.id);
        } catch (Exception e) {
            throw new ServletException("Error processing POST request", e);
        }
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            
            int id = Integer.parseInt(req.getParameter("id"));
            String title = req.getParameter("title");
            String content = req.getParameter("content");
            HttpSession session = req.getSession();
            User user = (User) session.getAttribute("user");
            int userId = user.id;
            Journal journal = new Journal(id, title, content, userId);
            journalRepository.updateJournal(journal);
            resp.sendRedirect("/journal?id=" + journal.id);
        } catch (Exception e) {
            throw new ServletException("Error processing PUT request", e);
        }
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            int id = Integer.parseInt(req.getParameter("id"));
            journalRepository.deleteJournal(id);
            resp.sendRedirect("/journals");
        } catch (Exception e) {
            throw new ServletException("Error processing DELETE request", e);
        }
    }
}