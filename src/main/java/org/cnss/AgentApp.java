package org.cnss;

import org.cnss.Classes.Agent;
import org.cnss.Dao.AgentDAO;
import org.cnss.Classes.Medicine;
import org.cnss.Dao.MedicineDAO;
import org.cnss.Dao.PatientDAO;
import org.cnss.Dao.ReimbursementCaseDAO;

import javax.swing.*;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AgentApp {
    public static void main() throws SQLException {
        AgentDAO agentDAO = new AgentDAO();
        PatientDAO patientDAO = new PatientDAO();
        ReimbursementCaseDAO reimbursementCaseDAO = new ReimbursementCaseDAO();
        int agent_id;
        int patient_id = 0;

        String email = JOptionPane.showInputDialog(null, "Enter votre email");
        String password = JOptionPane.showInputDialog(null, "Enter votre mot de passe");

        agent_id = agentDAO.authenticate(email, password);

        if (agent_id >0) {
            int choice = Integer.parseInt(JOptionPane.showInputDialog(null, """
                    Bienvenue dans votre espace MaCss

                    1 : Créer un dossier pour un patient

                    2 : Voir la listes des dossiers

                    """));

            switch (choice) {
                case 1: {
                    String matricule = JOptionPane.showInputDialog(null, "Enter le matricule du patient");
                    ResultSet resultSet = patientDAO.getPatient(matricule);
                     while(resultSet.next()){
                        patient_id = resultSet.getInt("id");
                     }
                     if(patient_id>0){
                         boolean isCase = reimbursementCaseDAO.createCase(patient_id,agent_id);
                         if(isCase){
                             JOptionPane.showMessageDialog(null,"Dossier bien créé !");
                             int subchoice = Integer.parseInt(JOptionPane.showInputDialog(null,"Gestion du dossierCnss\n" +
                                     "1 : Ajouter un medicament\n" +
                                     "2 : Ajouter un radio \n" +
                                     "3 : Ajouter un scanner\n" +
                                     "4 : Ajouter une analyse\n" +
                                     "5 : Ajouter une visite médicale\n"));
                             switch (subchoice){
                                 case 1 : {
                                     String code = JOptionPane.showInputDialog(null,"Entrer le codeBarre du medicament");
                                     break;
                                 }
                             }
                         }else{
                             JOptionPane.showMessageDialog(null,"une erreur est survenue !", "error", JOptionPane.ERROR_MESSAGE);
                         }
                     }else{
                         JOptionPane.showMessageDialog(null,"Ce patient n'existe pas ! ", "error", JOptionPane.ERROR_MESSAGE);
                     }

                    break;
                }
                case 2: {
                    break;
                }
                default: {
                    JOptionPane.showMessageDialog(null, "Choix indisponible", "Erreur", JOptionPane.ERROR_MESSAGE);
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "Agent introuvable !!", "Erreur", JOptionPane.ERROR_MESSAGE);
        }
    }
}
