package org.cnss.Dao;

import org.cnss.JDBC.DatabaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.concurrent.ExecutionException;

public class PatientDAO {
    private Connection connection;

    public PatientDAO() {
        connection = DatabaseConnection.getConnection();
    }

    public ResultSet getPatient (String matricule){
        try {
            String query = "SELECT * FROM patient WHERE `matricule` = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, matricule);
            return preparedStatement.executeQuery();
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }
}
