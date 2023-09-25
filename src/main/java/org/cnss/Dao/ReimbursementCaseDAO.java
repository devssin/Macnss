package org.cnss.Dao;

import org.cnss.JDBC.DatabaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.concurrent.ExecutionException;

public class ReimbursementCaseDAO {
    private Connection connection;

    public ReimbursementCaseDAO() {
        connection = DatabaseConnection.getConnection();
    }

    public boolean createCase(int patient_id, int agent_id){
        try{
            String query = "INSERT INTO `reimbursement_case` (id_patient, id_agent) VALUES (?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1,patient_id);
            preparedStatement.setInt(2,agent_id);
            preparedStatement.executeUpdate();
            return true;
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }
}
