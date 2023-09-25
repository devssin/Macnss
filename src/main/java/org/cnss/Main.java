package org.cnss;

import javax.swing.*;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {
        int option = Integer.parseInt(JOptionPane.showInputDialog(null,"Espace MaCnss\n" +
                "1 : Espace Agent \n" +
                "2 : Espace Patient"));

        switch (option){
            case 1 : {
                AgentApp.main();
                break;
            }case 2 : {
                PatientApp.main();
                break;
            }case 3 : {
                AdminApp.main();
                break;
            }
        }
    }
}
