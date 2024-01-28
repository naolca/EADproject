package com.project.servlets.journals;

import com.project.domain.Journal;
import com.project.services.JournalService;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/journals")
public class JournalsServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Retrieve data from the service
        List<Journal> journals = null;
        int userId = Integer.parseInt(request.getParameter("userId"));
        try {
            journals = JournalService.getAllJournalEntries(userId);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        // Set the data as an attribute in the request
        request.setAttribute("journals", journals);

        // Forward the request to the JSP page
        request.getRequestDispatcher("/user/journals.jsp").forward(request, response);
    }
}
