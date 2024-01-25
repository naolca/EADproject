package com.project.persistence;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnection {
  private final String databaseName = "projectdb";
  private final String username = "mysql";
  private final String password = "MySql!2345678";
  private final String connectionUrl = "jdbc:mysql://localhost:3306/";
  private final Connection conn;

  public DbConnection() throws ClassNotFoundException, SQLException {
    Class.forName("com.mysql.cj.jdbc.Driver");
    this.conn = DriverManager.getConnection(this.connectionUrl + this.databaseName, this.username, this.password);
  }

  public Connection getConnection() {
    return this.conn;
  }

  public void closeConnection() throws SQLException {
    this.conn.close();
  }
}
