package com.project.persistence.repositories;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.project.domain.User;

public class UserRepository {
  private final Connection connection;

  public UserRepository(Connection connection) {
    this.connection = connection;
  }

  public void saveUser(User user) {
    String query = "INSERT INTO users (username, password) VALUES (?, ?)";

    try (PreparedStatement preparedStatement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {
      preparedStatement.setString(1, user.username);
      preparedStatement.setString(2, user.password);

      preparedStatement.executeUpdate();

      // Retrieve the generated user ID
      ResultSet generatedKeys = preparedStatement.getGeneratedKeys();
      if (generatedKeys.next()) {
        user.id = generatedKeys.getInt(1);
      }
    } catch (SQLException e) {
      e.printStackTrace(); // Handle the exception according to your application's needs
    }
  }

  public User getUserById(int userId) {
    String query = "SELECT * FROM users WHERE id = ?";

    try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
      preparedStatement.setInt(1, userId);

      ResultSet resultSet = preparedStatement.executeQuery();

      if (resultSet.next()) {
        return new User(
            resultSet.getInt("id"),
            resultSet.getString("username"),
            resultSet.getString("password"));
      }
    } catch (SQLException e) {
      e.printStackTrace(); // Handle the exception according to your application's needs
    }

    return null;
  }

  public void updateUser(User user) {
    String query = "UPDATE users SET username = ?, password = ? WHERE id = ?";

    try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
      preparedStatement.setString(1, user.username);
      preparedStatement.setString(2, user.password);
      preparedStatement.setInt(3, user.id);

      preparedStatement.executeUpdate();
    } catch (SQLException e) {
      e.printStackTrace(); // Handle the exception according to your application's needs
    }
  }

  public void deleteUser(int userId) {
    String query = "DELETE FROM users WHERE id = ?";

    try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
      preparedStatement.setInt(1, userId);

      preparedStatement.executeUpdate();
    } catch (SQLException e) {
      e.printStackTrace(); // Handle the exception according to your application's needs
    }
  }
}
