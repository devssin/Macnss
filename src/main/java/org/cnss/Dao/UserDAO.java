package org.cnss.Dao;

import org.cnss.Classes.User;

import java.sql.ResultSet;

public interface UserDAO<user extends User> {

    int getUserByEmail(String email);
    ResultSet getAllUsers();
    boolean addUser(user user);
    boolean updateUser(user user);
}
