package com.maituananh.service;

import com.maituananh.model.User;

import java.util.List;

public interface ManageUserService {
    public abstract List getAllUser();
    public abstract void deleteUser(int id);
    public abstract User inForEditUser(int id);
    public abstract void saveUser(User user);
    public abstract void addUser(User user);
    public abstract List searchUser(String name);
}
