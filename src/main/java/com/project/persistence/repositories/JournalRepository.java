package com.project.persistence.repositories;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.project.domain.Journal;

public class JournalRepository {
    private final Connection connection;

    public JournalRepository(Connection connection) {
        this.connection = connection;
    }

    public void saveJournal(Journal journal) {
        String query = "INSERT INTO journals (title, content, user_id) VALUES (?, ?, ?)";

        try (PreparedStatement preparedStatement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {
            preparedStatement.setString(1, journal.title);
            preparedStatement.setString(2, journal.content);
            preparedStatement.setInt(3, journal.userId);

            preparedStatement.executeUpdate();

            // Retrieve the generated journal ID
            ResultSet generatedKeys = preparedStatement.getGeneratedKeys();
            if (generatedKeys.next()) {
                journal.id = generatedKeys.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace(); // Handle the exception according to your application's needs
        }
    }

    public Journal getJournalById(int journalId) {
        String query = "SELECT * FROM journals WHERE id = ?";

        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, journalId);

            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                return new Journal(
                        resultSet.getInt("id"),
                        resultSet.getString("title"),
                        resultSet.getString("content"),
                        resultSet.getInt("user_id")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace(); // Handle the exception according to your application's needs
        }

        return null;
    }

    public List<Journal> getJournalsByUserId(int userId) {
        String query = "SELECT * FROM journals WHERE user_id = ?";
        List<Journal> journals = new ArrayList<>();

        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, userId);

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                journals.add(new Journal(
                        resultSet.getInt("id"),
                        resultSet.getString("title"),
                        resultSet.getString("content"),
                        resultSet.getInt("user_id")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace(); // Handle the exception according to your application's needs
        }

        return journals;
    }

    public void updateJournal(Journal journal) {
        String query = "UPDATE journals SET title = ?, content = ?, user_id = ? WHERE id = ?";

        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, journal.title);
            preparedStatement.setString(2, journal.content);
            preparedStatement.setInt(3, journal.userId);
            preparedStatement.setInt(4, journal.id);

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace(); // Handle the exception according to your application's needs
        }
    }

    public void deleteJournal(int journalId) {
        String query = "DELETE FROM journals WHERE id = ?";

        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, journalId);

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace(); // Handle the exception according to your application's needs
        }
    }
    
    public List<Journal> searchJournalsByTitle(String title) {
        String query = "SELECT * FROM journals WHERE title LIKE ?";
        List<Journal> journals = new ArrayList<>();

        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, "%" + title + "%");

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                journals.add(new Journal(
                        resultSet.getInt("id"),
                        resultSet.getString("title"),
                        resultSet.getString("content"),
                        resultSet.getInt("user_id")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace(); // Handle the exception according to your application's needs
        }

        return journals;
    }

}
