package org.cnss.Classes;

public class Agent extends User {




    private static int id;
    public Agent(String userName, String email, String password) {
        super(userName, email, password);
    }
    public static void setId(int id) {
        Agent.id = id;
    }
    public static int getId() {
        return id;
    }

}
