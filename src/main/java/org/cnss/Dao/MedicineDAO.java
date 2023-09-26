package org.cnss.Dao;

import org.cnss.Classes.Medicine;
import org.cnss.JDBC.DatabaseConnection;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.HashMap;

public class MedicineDAO implements DocumentDAO<Medicine>{
    private final Connection connection;
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
    public boolean addDocument(Medicine medicine) {
        try {
            int checker = 0;
            String query = "INSERT INTO doc_medicine (CODE , barrecode, name, payed_amount, reimbursement_rate) VALUES (?,?,?,?,?)";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1,medicine.getCode());
            preparedStatement.setString(2,medicine.getCodeBarre());
            preparedStatement.setString(3,medicine.getName());
            preparedStatement.setInt(4,medicine.getPayedAmount());
            preparedStatement.setInt(5,medicine.getReimbursementRate());
            checker = preparedStatement.executeUpdate();
            if (checker>0){
                return true;
            }else {
                return false;
            }
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }

    public HashMap<String, String> checkMedicineByCode(String code) {
        try {
            String rate = null;
            String query = "SELECT * FROM medicine WHERE CODE = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, code);
            ResultSet resultSet = preparedStatement.executeQuery();

            HashMap<String, String> medicineData = new HashMap<>();

            while (resultSet.next()) {
                rate = resultSet.getString("TAUX_REMBOURSEMENT");
                code = resultSet.getString("CODE");
            }

            if (rate == null) {
                JOptionPane.showMessageDialog(null, "Medicament introuvable");
            }

            medicineData.put("rate", rate);
            medicineData.put("code", code);

            return medicineData;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public HashMap<String, String> checkMedicineByname(String name) {
        try {
            String rate = null;
            String code = null;
            String query = "SELECT * FROM medicine WHERE NOM = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, name);
            ResultSet resultSet = preparedStatement.executeQuery();

            HashMap<String, String> medicineData = new HashMap<>();

            while (resultSet.next()) {
                rate = resultSet.getString("TAUX_REMBOURSEMENT");
                code = resultSet.getString("CODE");
            }

            if (rate == null) {
                JOptionPane.showMessageDialog(null, "Medicament introuvable");
            }

            medicineData.put("rate", rate);
            medicineData.put("code", code);

            return medicineData;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public boolean doc_case(int case_id , String code){
        try{
            String query  = "INSERT INTO case_docs (id_case, medicine_code) VALUES (?,?)";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1,case_id);
            preparedStatement.setString(2,code);
            int checker = preparedStatement.executeUpdate();
            if (checker>0){
                return true;
            }else {
                return false;
            }
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }


    @Override
    public boolean updateDocument(Medicine doc) {
        return false;
    }

}
