package org.cnss.Dao;

import org.cnss.Classes.LaboratoryDoc;
import org.cnss.JDBC.DatabaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Random;


public class LaboratoryDocDAO implements DocumentDAO<LaboratoryDoc>{
    private final Connection connection;

    public LaboratoryDocDAO() {
        connection = DatabaseConnection.getConnection();
    }

    @Override
    public ResultSet getAllDocuments() {
        try {
            String query = "SELECT * FROM laboratory_docs";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();
            System.out.println(resultSet);
            return resultSet;
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean addDocument(LaboratoryDoc doc) {
        try {
            int checker = 0;
            String query = "INSERT INTO laboratory_docs (code , laboratory, description, category, payed_amount, reimbursement_rate) VALUES (?,?,?,?,?,?)";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, doc.getCode());
            preparedStatement.setString(2, doc.getLaboratory());
            preparedStatement.setString(3, doc.getDescription().toString()); // Convert Description enum to a string
            preparedStatement.setString(4, doc.getCategory().toString()); // Convert Category enum to a string
            preparedStatement.setInt(5, doc.getPayedAmount());
            preparedStatement.setInt(6, doc.getReimbursementRate());
            checker = preparedStatement.executeUpdate();

            return checker > 0;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


    @Override
    public boolean updateDocument(LaboratoryDoc doc) {
        return false;
    }

    public static String generateRandomCode() {
        String characters = "1234567890";
        StringBuilder code = new StringBuilder();
        Random random = new Random();

        for (int i = 0; i < 8; i++) {
            int randomIndex = random.nextInt(characters.length());
            char randomChar = characters.charAt(randomIndex);
            code.append(randomChar);
        }

        return code.toString();
    }
}
