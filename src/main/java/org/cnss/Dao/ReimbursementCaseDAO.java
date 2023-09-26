package org.cnss.Dao;

import org.cnss.JDBC.DatabaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class ReimbursementCaseDAO {
    private final Connection connection;

    public ReimbursementCaseDAO() {
        connection = DatabaseConnection.getConnection();
    }


    public int createCase(int patient_id, int agent_id) {
        try {
            String query = "INSERT INTO `reimbursement_case` (id_patient, id_agent) VALUES (?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setInt(1, patient_id);
            preparedStatement.setInt(2, agent_id);
            preparedStatement.executeUpdate();

            ResultSet generatedKeys = preparedStatement.getGeneratedKeys();
            if (generatedKeys.next()) {
                return generatedKeys.getInt(1);
            } else {
                throw new SQLException("Failed to retrieve the generated ID.");
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


}
