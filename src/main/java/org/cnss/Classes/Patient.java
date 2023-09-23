package org.cnss.Classes;

public class Patient extends User{
    private static String matricule;
    public Patient(String userName, String email, String password, String matricule) {
        super(userName, email, password);
        this.matricule = matricule;
    }
    public static String getMatricule() {
        return matricule;
    }

}
