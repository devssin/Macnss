package org.cnss.Dao;

import org.cnss.Classes.Agent;
import org.cnss.JDBC.DatabaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class AgentDAO implements UserDAO<Agent> {
    private Connection connection;

    public AgentDAO() {
        connection = DatabaseConnection.getConnection();
    }
    public Agent authenticate(String email, String password) {
        try {
            String query = "SELECT * FROM agent WHERE email = ? AND password = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, email);
            preparedStatement.setString(2, password);

            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                int agentId = resultSet.getInt("id");
                String username = resultSet.getString("username");
                Agent agent = new Agent(username, email, password, agentId);
                return agent;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Agent getUserById(int id) {
        return null;
    }

    @Override
    public List<Agent> getAllUsers() {
        return null;
    }

    @Override
    public boolean addUser(Agent user) {
        return false;
    }

    @Override
    public boolean updateUser(Agent user) {
        return false;
    }

    @Override
    public boolean deleteUser(int userId) {
        return false;
    }
}

