package org.cnss;

import org.cnss.Classes.Agent;
import org.cnss.Dao.AgentDAO;

import javax.swing.*;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AdminApp {
    public static void main() throws SQLException {
        AgentDAO agentDAO = new AgentDAO();
        JOptionPane.showMessageDialog(null,"Admin dashbord");
        int choice = Integer.parseInt(JOptionPane.showInputDialog(null,"Gestion des agents\n" +
                "1 : Ajouter un agent\n" +
                "2 : Modifier les informations d'un agent\n" +
                "3 : Voir la liste des agents"));

        switch (choice){
            case 1 : {
                String userName = JOptionPane.showInputDialog(null,"Entrer le nom complet de l'agent");
                String email = JOptionPane.showInputDialog(null,"Entrer le nouveau email de l'agent");
                String password = JOptionPane.showInputDialog(null,"Entrer le mot de passe de l'agent");
                Agent newAgent = new Agent(userName,email,password);
                boolean isUserAdded = agentDAO.addUser(newAgent);

                if (isUserAdded) {
                    JOptionPane.showMessageDialog(null,"User added successfully.");
                } else {
                    JOptionPane.showMessageDialog(null,"Failed to add user.","error", JOptionPane.ERROR_MESSAGE);
                }
            }
            case 2 : {
                String email = JOptionPane.showInputDialog(null,"Entrer l'email de l'agent à modofier");
                int isUserAdded = agentDAO.getUserByEmail(email);

                if (isUserAdded > 0) {
                    String userName = JOptionPane.showInputDialog(null,"Entrer le nom complet de l'agent");
                    String password = JOptionPane.showInputDialog(null,"Entrer le mot de passe de l'agent");
                    Agent newAgent = new Agent(userName,email,password);
                    boolean isUserUpdated = agentDAO.updateUser(newAgent);
                    if (isUserUpdated){
                        JOptionPane.showMessageDialog(null,"User Updated successfully.");
                    } else {
                        JOptionPane.showMessageDialog(null,"Failed to add user.","error", JOptionPane.ERROR_MESSAGE);
                    }
                } else {
                    JOptionPane.showMessageDialog(null,"Agent introuvable","error", JOptionPane.ERROR_MESSAGE);
                }
                break;
            }
            case 3 :{
                ResultSet resultSet = agentDAO.getAllUsers();
                String username;
                String email;
                while (resultSet.next()){
                    username = resultSet.getString("username");
                    email = resultSet.getString("email");
                }
                JOptionPane.showMessageDialog(null,"");
            }
        }



    }

}
