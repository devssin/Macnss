package org.cnss;

import org.cnss.Dao.PatientDAO;

import javax.swing.*;

public class PatientApp {
    public static void main() {

        JOptionPane.showMessageDialog(null,"Espace patient");
        PatientDAO patientDAO = new PatientDAO();

    }
}
