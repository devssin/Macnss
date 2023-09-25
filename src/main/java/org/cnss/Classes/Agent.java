package org.cnss.Classes;

import javax.swing.*;

public class Agent extends User {




    private static int id;
    public Agent(String userName, String email, String password, int id) {
        super(userName, email, password);
        this.id = id;
    }
    public static void setId(int id) {
        Agent.id = id;
    }
    public static int getId() {
        return id;
    }

}
