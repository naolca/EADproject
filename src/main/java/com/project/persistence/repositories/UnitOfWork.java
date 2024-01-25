package com.project.persistence.repositories;

import java.sql.SQLException;

import com.project.persistence.DbConnection;

public class UnitOfWork {
  private static UnitOfWork instance;

  private final DbConnection dbConnection;

  private final JournalRepository journalRepository;
  private final UserRepository userRepository;

  private UnitOfWork() throws ClassNotFoundException, SQLException {
    dbConnection = new DbConnection();

    journalRepository = new JournalRepository(dbConnection.getConnection());
    userRepository = new UserRepository(dbConnection.getConnection());
  }

  public JournalRepository getJournalRepository() {
    return journalRepository;
  }

  public UserRepository getUserRepository() {
    return userRepository;
  }

  private void save() throws SQLException {
    dbConnection.closeConnection();
  }

  public static UnitOfWork getInstance() throws ClassNotFoundException, SQLException {
    if (instance == null) {
      instance = new UnitOfWork();
    }

    return instance;
  }

  public static void closeInstance() throws SQLException {
    if (instance != null) {
      instance.save();
    }
  }
}
