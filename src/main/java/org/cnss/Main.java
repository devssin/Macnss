package org.cnss;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        int option = Integer.parseInt(JOptionPane.showInputDialog(null,"Bienvenu dans votre espace macnss\n" +
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
