package org.cnss;

import org.cnss.Classes.Agent;
import org.cnss.Dao.AgentDAO;

import javax.swing.*;

public class AgentApp {
    public static void main() {
        AgentDAO agentDAO = new AgentDAO();

        String email = JOptionPane.showInputDialog(null,"Enter votre email");
        String password = JOptionPane.showInputDialog(null,"Enter votre mot de passe");

        String usernameToAuthenticate = email;
        String passwordToAuthenticate = password;
        Agent authenticatedAgent = agentDAO.authenticate(usernameToAuthenticate, passwordToAuthenticate);

        if (authenticatedAgent != null) {
            JOptionPane.showMessageDialog(null,"Authentication successful!");
        } else {
            JOptionPane.showMessageDialog(null,"Authentication failed.");
        }
    }
}

