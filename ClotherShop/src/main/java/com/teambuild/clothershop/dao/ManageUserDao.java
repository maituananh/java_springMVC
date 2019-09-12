package com.teambuild.clothershop.dao;

import com.teambuild.clothershop.model.User;

import java.util.List;

public interface ManageUserDao {
    User findID(int id);
    List listAllUser();
    void addUser(User user);
    void editRoleUser(int id, int role);
}
