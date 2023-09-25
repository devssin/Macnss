package org.cnss.Dao;

import com.mysql.cj.protocol.Resultset;
import com.mysql.cj.protocol.x.ReusableOutputStream;
import org.cnss.Classes.Document;
import org.cnss.JDBC.DatabaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MedicineDAO implements DocumentDAO<Document>{
    private Connection connection;
    public MedicineDAO() {
        connection = DatabaseConnection.getConnection();
    }
    @Override
    public ResultSet getAllDocuments() {
        try {
            String query = "SELECT * FROM medicine";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();
            System.out.println(resultSet);
            return resultSet;
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean addDocument(Document doc) {
        return false;
    }


    @Override
    public boolean updateDocument(Document doc) {
        return false;
    }
}
