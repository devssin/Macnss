package org.cnss;

import org.cnss.Classes.Agent;
import org.cnss.Dao.AgentDAO;

import javax.swing.*;

public class AdminApp {
    public static void main() {
        AgentDAO agentDAO = new AgentDAO();
        JOptionPane.showMessageDialog(null,"Admin dashbord");
        int choice = Integer.parseInt(JOptionPane.showInputDialog(null,"Gestion des agents" +
                "1 : Ajouter un agent" +
                "2 : Modifier les informations d'un agent"));

        switch (choice){
            case 1 : {
                String userName = JOptionPane.showInputDialog(null,"Entrer le nom complet de l'agent");
                String email = JOptionPane.showInputDialog(null,"Entrer le nouveau email de l'agent");
                String password = JOptionPane.showInputDialog(null,"Entrer le mot de passe de l'agent");
                Agent newAgent = new Agent(userName,email,password);
                boolean isUserAdded = agentDAO.addUser(newAgent);

                if (isUserAdded) {
                    System.out.println("User added successfully.");
                } else {
                    System.out.println("Failed to add user.");
                }
            }
        }



    }

}
