package org.cnss;

import org.cnss.Classes.*;
import org.cnss.Dao.*;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Objects;
import java.util.Properties;
import java.util.UUID;


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

            String verification_code = UUID.randomUUID().toString();
            String body = "Votre verification code est : " + verification_code;
            sendMail(body, "Verification email", email);

            String code_recived = JOptionPane.showInputDialog(null, "Entrez le code de verification");

            if(!Objects.equals(code_recived, verification_code)){
                JOptionPane.showMessageDialog(null, "Verification code est invalid !!", "Erreur", JOptionPane.ERROR_MESSAGE);
                return;
            }
            int choice = -1;
            while (choice != 0){
                choice= Integer.parseInt(JOptionPane.showInputDialog(null, """
                    Bienvenue dans votre espace MaCss

                    1 : Créer un dossier pour un patient

                    2 : Voir la listes des dossiers
                    
                    0 : Terminer;

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
                            if(caseId>0) {
                                JOptionPane.showMessageDialog(null, "Dossier bien créé !");
                                int subchoice = 0;
                                while (subchoice != 4){
                                    subchoice = Integer.parseInt(JOptionPane.showInputDialog(null,
                                            "Gestion du dossier Cnss\n" +
                                                    "1 : Ajouter un medicament\n" +
                                                    "2 : Ajouter un document du Laboratoire\n" +
                                                    "3 : Ajouter une visite médicale\n" +
                                                    "4 : Terminer et quitter"));
                                    switch (subchoice) {
                                        case 1: {
                                            int searchChoice = Integer.parseInt(JOptionPane.showInputDialog(null, "" +
                                                    "1 : Entrer le nom du medicament\n" +
                                                    "2 : Entrer le code du medicament"));
                                            switch (searchChoice) {
                                                case 1: {
                                                    String name = JOptionPane.showInputDialog(null, "Entrer le nom du medicament");
                                                    String rate = null;
                                                    String code = null;
                                                    String codeBare;
                                                    int payed_amount = 0;
                                                    HashMap<String, String> medicineData = medicineDAO.checkMedicineByname(name);

                                                    if (!medicineData.isEmpty()) {
                                                        rate = medicineData.get("rate");
                                                        code = medicineData.get("code");
                                                    }
                                                    if ("70%".equals(rate)) {
                                                        int Reimbursement_rate = 70;
                                                        codeBare = JOptionPane.showInputDialog(null, "Enter le codeBarre du medicament (optionel)");
                                                        if (codeBare.trim().isEmpty()) {
                                                            codeBare = null;
                                                        }
                                                        payed_amount = Integer.parseInt(JOptionPane.showInputDialog(null, "Enter le montant payé"));

                                                        Medicine medicine = new Medicine(code, codeBare, name, payed_amount, Reimbursement_rate);

                                                        boolean isDocAdded = medicineDAO.addDocument(medicine);
                                                        if (isDocAdded) {
                                                            boolean finalCheck = medicineDAO.doc_case(caseId, code);
                                                            if (finalCheck)
                                                                JOptionPane.showMessageDialog(null, "Document bien ajouté !");
                                                        } else {
                                                            JOptionPane.showMessageDialog(null, "Erreur survenue !", "error", JOptionPane.ERROR_MESSAGE);
                                                        }
                                                    } else {
                                                        JOptionPane.showMessageDialog(null, "Ce produit n'est pas remboursable ou une erreur est survenue !", "error", JOptionPane.ERROR_MESSAGE);
                                                    }
                                                    break;
                                                }
                                                case 2: {
                                                    String name = JOptionPane.showInputDialog(null, "Entrer le nom du medicament");
                                                    String rate = null;
                                                    String code = null;
                                                    String codeBare;
                                                    int payed_amount = 0;
                                                    HashMap<String, String> medicineData = medicineDAO.checkMedicineByCode(code);

                                                    if (!medicineData.isEmpty()) {
                                                        rate = medicineData.get("rate");
                                                        code = medicineData.get("code");
                                                    }
                                                    if ("70%".equals(rate)) {
                                                        int Reimbursement_rate = 70;
                                                        codeBare = JOptionPane.showInputDialog(null, "Enter le codeBarre du medicament (optionel)");
                                                        if (codeBare.trim().isEmpty() || codeBare == null) {
                                                            codeBare = null;
                                                        }
                                                        payed_amount = Integer.parseInt(JOptionPane.showInputDialog(null, "Enter le montant payé"));

                                                        Medicine medicine = new Medicine(code, codeBare, name, payed_amount, Reimbursement_rate);

                                                        boolean isDocAdded = medicineDAO.addDocument(medicine);

                                                        if (isDocAdded) {
                                                            JOptionPane.showMessageDialog(null, "Document bien ajouté !");
                                                        } else {
                                                            JOptionPane.showMessageDialog(null, "Erreur survenue !", "error", JOptionPane.ERROR_MESSAGE);
                                                        }
                                                    } else {
                                                        JOptionPane.showMessageDialog(null, "Ce produit n'est pas remboursable ou une erreur est survenue !", "error", JOptionPane.ERROR_MESSAGE);
                                                    }
                                                }
                                            }
                                            break;
                                        }
                                        case 2: {
                                            String labo = JOptionPane.showInputDialog(null, "Entrer le nom du laboratoire");
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

                                                int payed_amount = Integer.parseInt(JOptionPane.showInputDialog(null, "Entrer le montant payé"));
                                                String randomCode = laboDAO.generateRandomCode();

                                                int reimbursement_rate = (selectedCategory == Category.MALADIE) ? 70 : 90;
                                                LaboratoryDoc doc = new LaboratoryDoc(randomCode, payed_amount, reimbursement_rate, selectedDescription, labo, selectedCategory);


                                                if (selectedCategory == Category.ESTHETIQUE) {
                                                    JOptionPane.showMessageDialog(null, "Ce type de document n'est pas remboursable", "error", JOptionPane.ERROR_MESSAGE);
                                                } else {
                                                    boolean isDocAdded = laboDAO.addDocument(doc);
                                                    if (isDocAdded) {
                                                        JOptionPane.showMessageDialog(null, "Document bien ajouté !");
                                                    } else {
                                                        JOptionPane.showMessageDialog(null, "Erreur survenue !", "error", JOptionPane.ERROR_MESSAGE);
                                                    }
                                                }
                                            }
                                            break;
                                        }
                                        case 3 : {
                                            String doctor = JOptionPane.showInputDialog(null, "Entrer the nom du docteur");
                                            Category selectedCategory = (Category) JOptionPane.showInputDialog(
                                                    null,
                                                    "Select Category:",
                                                    "Category Selection",
                                                    JOptionPane.QUESTION_MESSAGE,
                                                    null,
                                                    Category.values(),
                                                    Category.MALADIE
                                            );

                                            ConsultationDAO consult = new ConsultationDAO();

                                            int payed_amount = Integer.parseInt(JOptionPane.showInputDialog(null, "Enter le montant payé"));
                                            String randomCode = consult.generateRandomCode();

                                            int reimbursement_rate = (selectedCategory == Category.MALADIE) ? 70 : 90;

                                            Consultation doc = new Consultation(randomCode, payed_amount, reimbursement_rate, selectedCategory);

                                            if (selectedCategory == Category.ESTHETIQUE) {
                                                JOptionPane.showMessageDialog(null, "Ce type de document n'est pas remboursable", "error", JOptionPane.ERROR_MESSAGE);
                                            } else {
                                                boolean isDocAdded = consult.addDocument(doc);
                                                if (isDocAdded) {
                                                    JOptionPane.showMessageDialog(null, "Document bien ajouté !");
                                                } else {
                                                    JOptionPane.showMessageDialog(null, "Erreur survenue !", "error", JOptionPane.ERROR_MESSAGE);
                                                }

                                                break;
                                            }
                                        }
                                        case 4 : {
                                            break;
                                        }
                                        default:
                                            throw new IllegalStateException("Unexpected value: " + subchoice);
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
            }
        } else {
            JOptionPane.showMessageDialog(null, "Agent introuvable !!", "Erreur", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static Boolean sendMail(String body,String subject ,String email) {
        final String username = "yassin.aaynealhayate@gmail.com";
        final String password = "rzma gghi rvtn avzy";
        Properties properties = System.getProperties();
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.host", "smtp.gmail.com");
        properties.put("mail.smtp.port", "587");
        properties.put("mail.smtp.ssl.protocols", "TLSv1.2");
        properties.put("mail.smtp.starttls.enable", "true");
        Session session = Session.getInstance(properties, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
        });
        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(username));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(email));
            message.setSubject(subject);
            message.setText(body);
            Transport.send(message);
            return true;
        } catch (MessagingException e) {
            e.printStackTrace();
            return false;
        }
    }
}
