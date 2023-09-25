package org.cnss.Dao;

import org.cnss.Classes.User;

import java.sql.ResultSet;
import java.util.List;

public interface UserDAO<user extends User> {
    user getUserById(int id);
    ResultSet getAllUsers();
    boolean addUser(user user);
    boolean updateUser(user user);
    boolean deleteUser(int userId);
}
