package org.cnss;

import org.cnss.Classes.LaboratoryDoc;
import org.cnss.Dao.*;
import org.cnss.Classes.Medicine;
import javax.swing.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import org.cnss.Classes.Description;
import org.cnss.Classes.Category;


public class AgentApp {
    public static void main() throws SQLException {
        AgentDAO agentDAO = new AgentDAO();
        PatientDAO patientDAO = new PatientDAO();
        ReimbursementCaseDAO reimbursementCaseDAO = new ReimbursementCaseDAO();
        MedicineDAO medicineDAO = new MedicineDAO();
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
                         int caseId = reimbursementCaseDAO.createCase(patient_id,agent_id);
                         if(caseId>0){
                             JOptionPane.showMessageDialog(null,"Dossier bien créé !");
                             int subchoice = Integer.parseInt(JOptionPane.showInputDialog(null,"Gestion du dossierCnss\n" +
                                     "1 : Ajouter un medicament\n" +
                                     "2 : Ajouter un document du Laboratoire \n" +
                                     "3 : Ajouter une visite médicale\n"));
                             switch (subchoice){
                                 case 1 : {
                                     int searchChoice = Integer.parseInt(JOptionPane.showInputDialog(null,"" +
                                             "1 : Entrer le nom du medicament\n" +
                                             "2 : Entrer le code du medicament"));
                                     switch (searchChoice){
                                         case 1 : {
                                             String name = JOptionPane.showInputDialog(null,"Entrer le nom du medicament");
                                             String rate = null;
                                             String code = null;
                                             String codeBare ;
                                             int payed_amount = 0;
                                             HashMap<String, String> medicineData = medicineDAO.checkMedicineByname(name);

                                             if (!medicineData.isEmpty()) {
                                                 rate = medicineData.get("rate");
                                                 code = medicineData.get("code");
                                             }
                                             if ("70%".equals(rate)) {
                                                 int Reimbursement_rate = 70;
                                                 codeBare = JOptionPane.showInputDialog(null,"Enter le codeBarre du medicament (optionel)");
                                                 if(codeBare.trim().isEmpty()){
                                                     codeBare = null;
                                                 }
                                                 payed_amount = Integer.parseInt(JOptionPane.showInputDialog(null,"Enter le montant payé"));

                                                 Medicine medicine = new Medicine(code,codeBare,name,payed_amount,Reimbursement_rate);

                                                 boolean isDocAdded =medicineDAO.addDocument(medicine);
                                                 if (isDocAdded) {
                                                     boolean finalCheck = medicineDAO.doc_case(caseId,code);
                                                     if (finalCheck) JOptionPane.showMessageDialog(null,"Document bien ajouté !");
                                                 } else {
                                                     JOptionPane.showMessageDialog(null,"Erreur survenue !","error", JOptionPane.ERROR_MESSAGE);
                                                 }
                                             } else {
                                                 JOptionPane.showMessageDialog(null,"Ce produit n'est pas remboursable ou une erreur est survenue !","error", JOptionPane.ERROR_MESSAGE);
                                             }
                                             break;
                                         }
                                         case 2 : {
                                             String name = JOptionPane.showInputDialog(null,"Entrer le nom du medicament");
                                             String rate = null;
                                             String code = null;
                                             String codeBare ;
                                             int payed_amount = 0;
                                             HashMap<String, String> medicineData = medicineDAO.checkMedicineByCode(code);

                                             if (!medicineData.isEmpty()) {
                                                 rate = medicineData.get("rate");
                                                 code = medicineData.get("code");
                                             }
                                             if ("70%".equals(rate)) {
                                                 int Reimbursement_rate = 70;
                                                 codeBare = JOptionPane.showInputDialog(null,"Enter le codeBarre du medicament (optionel)");
                                                 if(codeBare.trim().isEmpty() || codeBare == null){
                                                     codeBare = null;
                                                 }
                                                 payed_amount = Integer.parseInt(JOptionPane.showInputDialog(null,"Enter le montant payé"));

                                                 Medicine medicine = new Medicine(code,codeBare,name,payed_amount,Reimbursement_rate);

                                                 boolean isDocAdded =medicineDAO.addDocument(medicine);

                                                 if (isDocAdded) {
                                                     JOptionPane.showMessageDialog(null,"Document bien ajouté !");
                                                 } else {
                                                     JOptionPane.showMessageDialog(null,"Erreur survenue !","error", JOptionPane.ERROR_MESSAGE);
                                                 }
                                             } else {
                                                 JOptionPane.showMessageDialog(null,"Ce produit n'est pas remboursable ou une erreur est survenue !","error", JOptionPane.ERROR_MESSAGE);
                                             }
                                         }
                                     }
                                     break;
                                 }
                                 case 2: {
                                     String labo = JOptionPane.showInputDialog(null, "Enter the name of the laboratory");
                                     Description[] descriptionValues = Description.values();
                                     JComboBox<Description> descriptionComboBox = new JComboBox<>(descriptionValues);
                                     descriptionComboBox.setSelectedItem(descriptionValues[0]);

                                     LaboratoryDocDAO laboDAO = new LaboratoryDocDAO();

                                     JPanel panel = new JPanel();
                                     panel.add(new JLabel("Select Description:"));
                                     panel.add(descriptionComboBox);

                                     int result = JOptionPane.showConfirmDialog(null, panel, "Description Selection", JOptionPane.OK_CANCEL_OPTION);

                                     if (result == JOptionPane.OK_OPTION) {
                                         Description selectedDescription = (Description) descriptionComboBox.getSelectedItem();
                                         Category selectedCategory = (Category) JOptionPane.showInputDialog(
                                                 null,
                                                 "Select Category:",
                                                 "Category Selection",
                                                 JOptionPane.QUESTION_MESSAGE,
                                                 null,
                                                 Category.values(),
                                                 Category.MALADIE
                                         );

                                         int payed_amount = Integer.parseInt(JOptionPane.showInputDialog(null,"Enter le montant payé"));
                                         String randomCode = laboDAO.generateRandomCode();

                                         int reimbursement_rate = (selectedCategory == Category.MALADIE) ? 70 : 90;
                                         LaboratoryDoc doc = new LaboratoryDoc(randomCode, payed_amount, reimbursement_rate, Description.RADIO, labo, Category.MALADIE);


                                         if (selectedCategory == Category.ESTHETIQUE) {
                                             JOptionPane.showMessageDialog(null,"Ce type de document n'est pas remboursable","error",JOptionPane.ERROR_MESSAGE);
                                         } else {
                                             boolean isDocAdded = laboDAO.addDocument(doc);
                                             if (isDocAdded) {
                                                 JOptionPane.showMessageDialog(null,"Document bien ajouté !");
                                             } else {
                                                 JOptionPane.showMessageDialog(null,"Erreur survenue !","error", JOptionPane.ERROR_MESSAGE);
                                             }
                                         }
                                     }
                                     break;
                                 }

                                 default:
                                     throw new IllegalStateException("Unexpected value: " + subchoice);
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
