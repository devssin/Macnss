package org.cnss.Dao;

import org.cnss.Classes.Patient;
import org.cnss.JDBC.DatabaseConnection;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class PatientDAO implements UserDAO<Patient>{
    private final Connection connection;

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

    @Override
    public int getUserByEmail(String email) {
        return 0;
    }

    @Override
    public ResultSet getAllUsers() {
        try {
            int id = 0;
            String query = "SELECT * FROM patient";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()){
                id  = resultSet.getInt("id");
            }
            if (id>0){
                return resultSet;
            }else {
                JOptionPane.showMessageDialog(null, "Aucun patient trouvé");
            }
        }catch (Exception e){

        }
        return null;
    }

    @Override
    public boolean addUser(Patient user) {
        return false;
    }

    @Override
    public boolean updateUser(Patient user) {
        return false;
    }
}
