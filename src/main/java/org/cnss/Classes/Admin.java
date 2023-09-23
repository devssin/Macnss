package org.cnss.Classes;

public class Admin extends User{
    public Admin(String userName, String email, String password) {
        super(userName, email, password);
    }

    @Override
    public void login(String email, String password) {

    }
}
