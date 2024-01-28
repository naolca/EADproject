package com.project.persistence.repositories;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.project.domain.User;
import com.project.customexceptions.*;

public class UserRepository {
  private final Connection connection;

  public UserRepository(Connection connection) {
    this.connection = connection;
  }

  public User saveUser(User user) throws SQLException, EmailExistsException {
    try {
      if (getUserByEmail(user.email) != null) {
        throw new EmailExistsException("Email is taken by another user.");
      }

      String query = "INSERT INTO users (firstName, lastName, email, password, role) VALUES (?, ?, ?, ?, ?)";
      PreparedStatement preparedStatement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
      preparedStatement.setString(1, user.firstName);
      preparedStatement.setString(2, user.lastName);
      preparedStatement.setString(3, user.email);
      preparedStatement.setString(4, user.password);
      preparedStatement.setString(5, user.role);

      preparedStatement.executeUpdate();

      // Retrieve the generated user ID
      ResultSet generatedKeys = preparedStatement.getGeneratedKeys();
      if (generatedKeys.next()) {
        user.id = generatedKeys.getInt(1);
      }
      return user;
    } catch (SQLException e) {
      e.printStackTrace(); // Handle the exception according to your application's needs
      return null;
    }
  }

  public User getUserById(int userId) throws SQLException {
    String query = "SELECT * FROM users WHERE id = ?";

    PreparedStatement preparedStatement = connection.prepareStatement(query);
    preparedStatement.setInt(1, userId);

    ResultSet resultSet = preparedStatement.executeQuery();

    if (resultSet.next()) {
      return new User(
          resultSet.getInt("id"),
          resultSet.getString("firstName"),
          resultSet.getString("lastName"),
          resultSet.getString("email"),
          resultSet.getString("password"),
          resultSet.getString("role"));
    }

    return null;
  }




      public List<User> getAllUsers() throws SQLException {
          List<User> users = new ArrayList<>();

          String query = "SELECT * FROM users";
          PreparedStatement preparedStatement = connection.prepareStatement(query);
          ResultSet resultSet = preparedStatement.executeQuery();

          while (resultSet.next()) {
              users.add(new User(
                  resultSet.getInt("id"),
                  resultSet.getString("firstName"),
                  resultSet.getString("lastName"),
                  resultSet.getString("email"),
                  resultSet.getString("password"),
                  resultSet.getString("role")
              ));
          }

          return users;
      }





      public User updateUser(User user) throws SQLException {

        try{
        String query = "UPDATE users SET firstName = ?, lastName = ?, email = ?, password = ?, role = ? WHERE id = ?";
    
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setString(1, user.firstName);
        preparedStatement.setString(2, user.lastName);
        preparedStatement.setString(3, user.email);
        preparedStatement.setString(4, user.password);
        preparedStatement.setString(5, user.role);
        preparedStatement.setInt(6, user.id);
    
        preparedStatement.executeUpdate();
        ResultSet generatedKeys = preparedStatement.getGeneratedKeys();
          if (generatedKeys.next()) {
            user.id = generatedKeys.getInt(1);
          }
        return user;
        } catch (SQLException e) {
          e.printStackTrace(); // Handle the exception according to your application's needs
          return null;
        }
        
    }

  public void deleteUser(int userId) throws SQLException, NotFoundException {
    if (getUserById(userId) == null)
      throw new NotFoundException("User with that id was not found.");

    String query = "DELETE FROM users WHERE id = ?";
    PreparedStatement preparedStatement = connection.prepareStatement(query);
    preparedStatement.setInt(1, userId);

    preparedStatement.executeUpdate();
  }

  // Check user existence and password
  public User getUserByEmailAndPassword(String email, String password) throws SQLException, NotFoundException {
    if (getUserByEmail(email) == null) {
      throw new NotFoundException("User with email was not found.");
    }

    String query = "SELECT * FROM users WHERE email = ? AND password = ?";

    PreparedStatement preparedStatement = connection.prepareStatement(query);
    preparedStatement.setString(1, email);
    preparedStatement.setString(2, password);

    System.out.println(preparedStatement);

    ResultSet resultSet = preparedStatement.executeQuery();
    System.out.println(resultSet);
    if (resultSet.next()) {
      return new User(
          resultSet.getInt("id"),
          resultSet.getString("firstName"),
          resultSet.getString("lastName"),
          resultSet.getString("email"),
          resultSet.getString("password"),
          resultSet.getString("role"));
    }
    return null;
  }

  // Check if email exists
  private User getUserByEmail(String userEmail) throws SQLException {
    String query = "SELECT * FROM users WHERE email = ?";

    PreparedStatement preparedStatement = connection.prepareStatement(query);
    preparedStatement.setString(1, userEmail);

    ResultSet resultSet = preparedStatement.executeQuery();

    if (resultSet.next()) {
      return new User(
          resultSet.getInt("id"),
          resultSet.getString("firstName"),
          resultSet.getString("lastName"),
          resultSet.getString("email"),
          resultSet.getString("password"),
          resultSet.getString("role"));
    }

    return null;
  }
}
