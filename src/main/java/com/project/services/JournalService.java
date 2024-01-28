package com.project.services;// JournalService.java

import com.project.domain.Journal;
import com.project.persistence.repositories.JournalRepository;
import com.project.persistence.repositories.UnitOfWork;

import java.sql.SQLException;
import java.util.List;

public class JournalService {
  public static List<Journal> getAllJournalEntries(int userId) throws SQLException, ClassNotFoundException {
    // Replace this with your actual data retrieval logic from the database
    // For simplicity, let's assume you have a static list
    UnitOfWork uof = UnitOfWork.getInstance();
    JournalRepository journalRepository = uof.getJournalRepository();
    return journalRepository.getJournalsByUserId(userId);
  }
}
