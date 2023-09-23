package org.cnss.Dao;

import org.cnss.Classes.User;

import java.util.List;

public interface UserDAO<user extends User> {
    user getUserById(int id);
    List<user> getAllUsers();
    boolean addUser(user user);
    boolean updateUser(user user);
    boolean deleteUser(int userId);
}
