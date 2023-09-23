package org.cnss.Classes;

import javax.swing.*;

public class Agent extends User {
    private static int id;
    public Agent(String userName, String email, String password, int id) {
        super(userName, email, password);
        this.id = id;
    }
    public static int getId() {
        return id;
    }
    public static void add_agent(String userName, String email, String password){

    }

    @Override
    public void login(String email, String password) {

    }
}
